/**
 * 用户关系 关注、被关注 好友等
 */
package cn.edu.xjtu.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.xjtu.dao.UserDAO;
import cn.edu.xjtu.dao.UserattentionsDAO;
import cn.edu.xjtu.pojo.User;
import cn.edu.xjtu.pojo.Userattentions;
import cn.edu.xjtu.util.MarkResult;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Iver3oN Zhang
 * @date 2016年5月30日
 */
@Service
public class RelationService {

	@Autowired
	UserattentionsDAO attDAO;

	@Autowired
	UserDAO userDAO;

	/**
	 * @param info
	 */
	public String focus(String info) {
		JSONObject obj = JSON.parseObject(info);
		int userid = obj.getIntValue("userid");
		int attention_userid = obj.getIntValue("attention_userid");
		Timestamp timedate = Timestamp.valueOf(obj.getString("createDate"));
		if (isExits(userid, attention_userid)) {
			return MarkResult.getResult(0, "已关注，无法重复关注");
		} else {
			Userattentions attention = new Userattentions();
			attention.setCreateDate(timedate);
			User u1 = userDAO.findById(userid);
			User u2 = userDAO.findById(attention_userid);
			u2.setId(attention_userid);
			attention.setUserByAttentionUserid(u2);
			attention.setUserByUserId(u1);
			u1.setFocusCount(u1.getFocusCount() + 1);
			u2.setIsFocusCount(u2.getIsFocusCount() + 1);
			// 设置关注数 和被关注数目
			userDAO.merge(u1);
			userDAO.merge(u2);
			attDAO.save(attention);
			//返回关注 的ID 
			return MarkResult.getResult(1, attention.getUserattentionId());
		}
	}

	/**
	 * @param userid
	 * @param attention_userid
	 * @return
	 */
	private boolean isExits(int userid, int attention_userid) {
		return attDAO.isExits(userid, attention_userid);
	}

	/**
	 * @param myid
	 * @return 所关注的好友信息JSONARRAY
	 */
	public String getMyFocus(int myid) {
		List<Userattentions> list = attDAO.findByUserId(myid);
		System.out.println(list.size());
		JSONArray array = new JSONArray();
		for (Userattentions att : list) {
			JSONObject obj = new JSONObject();
			obj = JSON.parseObject(userDAO.findById(
					att.getUserByAttentionUserid().getId()).toJSON());
			array.add(obj);
		}
		return array.toJSONString();
	}

	/**
	 * @param info
	 * @return
	 */
	public String unFocus(Integer id) {
		Userattentions att = attDAO.findById(id);
		attDAO.delete(att);
		return MarkResult.getResult(1, "取消关注成功");
	}

	/**
	 * @param a_id
	 * @param b_id
	 * @return
	 */
	public String isFocus(Integer a_id, Integer b_id) {
		if(isExits(a_id,b_id)){
			return MarkResult.getResult(0,"关注");
		}
		return MarkResult.getResult(1,"未关注");
	}

}
