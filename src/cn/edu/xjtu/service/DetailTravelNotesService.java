/**
 * 
 */
package cn.edu.xjtu.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.xjtu.dao.DetailtravelnotesDAO;
import cn.edu.xjtu.dao.TravelnotespictureDAO;
import cn.edu.xjtu.dao.UserDAO;
import cn.edu.xjtu.pojo.Detailtravelnotes;
import cn.edu.xjtu.pojo.Travelnotespicture;
import cn.edu.xjtu.util.MarkResult;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Iver3oN Zhang
 * @date 2016年6月3日
 */
@Service
public class DetailTravelNotesService {

	@Autowired
	TravelnotespictureDAO picDAO;
	@Autowired
	UserDAO userDAO;

	@Autowired
	DetailtravelnotesDAO notesDAO;

	/**
	 * @param nodesInfo
	 * @return
	 */
	public String addDetailNotes(String nodesInfo) {
		JSONObject json = JSON.parseObject(nodesInfo);
		/*
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 * String datetime = ;
		 */
		// 获取游记的属性
		Detailtravelnotes notes = new Detailtravelnotes();
		notes.setCreateTime(Timestamp.valueOf(json.getString("datetime")
				+ ":00"));
		notes.setContent(json.getString("discription"));
		notes.setLocation(json.getString("location"));
		notes.setLongitude(json.getDouble("longitude"));
		notes.setLatitude(json.getDouble("latitude"));
		// 权限。哪些人可见
		notes.setRightType(json.getIntValue("rightType"));
		notes.setCommentCount(0);
		notes.setStarCount(0);
		notes.setScanCount(0);
		int id = json.getIntValue("userid");
		notes.setUser(userDAO.findById(id));
		notesDAO.save(notes);
		// 获取游记图片属性jsonarray
		JSONArray array = JSON
				.parseArray(json.getString("travlenotespictures"));
		for (int i = 0; i < array.size(); i++) {
			Travelnotespicture pic = new Travelnotespicture();
			pic.setSummary(array.getJSONObject(i).getString("summary"));
			pic.setUrl(array.getJSONObject(i).getString("url"));
			pic.setType(array.getJSONObject(i).getInteger("type"));
			//图片位置
			pic.setPosition(array.getJSONObject(i).getInteger("position"));
			//图片 文字  视频 的经纬度信息  用于绘制路径
			pic.setLongitude(array.getJSONObject(i).getDouble("longitude"));
			pic.setLatitude(array.getJSONObject(i).getDouble("latitude"));
			pic.setDetailtravelnotes(notes);
			picDAO.save(pic);
		}
		return MarkResult.getResult(1, null);
	}

	/**
	 * @param id
	 * @return
	 */
	public String getDetailNotesById(Integer id) {
		Detailtravelnotes note = notesDAO.findById(id);
		System.out.println(note+"获取到的note");
		// 浏览量+1
		note.setScanCount(note.getScanCount() + 1);
		notesDAO.merge(note);
		return note.toString();
	}

	/**
	 * @param id
	 * @return
	 */
	public String getNotesByUserId(Integer id) {
		List<Detailtravelnotes> list = notesDAO.findByUserId(id);
		return parseListToJsonString(list);
	}

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	// 当session加载某个实体时，会对这个实体中的集合属性值采用延迟加载
	public String findTopStarDetailNotes(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		List<Detailtravelnotes> list = notesDAO.findTopStar(offset, limit);
		return parseListToJsonString(list);
	}

	/**
	 * @param info
	 * @return
	 */
	public String findNearByDetailNotes(String info) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param info
	 * @return
	 */
	public String getMyFriendsDetailNotesByLocation(String info) {
		JSONObject json = JSON.parseObject(info);
		double longitude = json.getDoubleValue("longitude");
		double latitude = json.getDoubleValue("latitude");
		int userid = json.getIntValue("userid");
		int limit = json.getIntValue("count");
		List<Detailtravelnotes> list = notesDAO.getNotesOfMyfriends(userid,
				longitude, latitude, limit);
		return parseListToJsonString(list);
	}

	// //将获取到的结果List 转换为json字符串返回给app
	public String parseListToJsonString(List<Detailtravelnotes> list) {
		JSONArray array = new JSONArray();
		for (Detailtravelnotes notes : list) {
			JSONObject obj = JSON.parseObject(notes.toString());
			array.add(obj);
		}
		return array.toJSONString();
	}

	/**
	 * @param id
	 * @return
	 */
	public String delete(Integer id) {
		Detailtravelnotes notes = notesDAO.findById(id);
		if (notes != null) {
			notesDAO.delete(notes);
			return MarkResult.getResult(1, null);
		} else {
			return MarkResult.getResult(0, "出错，请稍后删除");
		}
	}
}
