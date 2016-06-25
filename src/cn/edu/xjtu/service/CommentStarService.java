/**
 * 
 */
package cn.edu.xjtu.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.xjtu.dao.CommentsDAO;
import cn.edu.xjtu.dao.DetailtravelnotesDAO;
import cn.edu.xjtu.dao.NewscenicspotsDAO;
import cn.edu.xjtu.dao.StarsDAO;
import cn.edu.xjtu.dao.TravelnotesDAO;
import cn.edu.xjtu.dao.UserDAO;
import cn.edu.xjtu.pojo.Comments;
import cn.edu.xjtu.pojo.Detailtravelnotes;
import cn.edu.xjtu.pojo.Newscenicspots;
import cn.edu.xjtu.pojo.Stars;
import cn.edu.xjtu.pojo.Travelnotes;
import cn.edu.xjtu.util.MarkResult;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Iver3oN Zhang
 * @date 2016年5月30日
 */
@Service
public class CommentStarService {

	@Autowired
	UserDAO userDAO;

	@Autowired
	StarsDAO starDAO;

	@Autowired
	TravelnotesDAO travelnotesDAO;

	@Autowired
	NewscenicspotsDAO spotsDAO;

	@Autowired
	CommentsDAO commentDAO;

	@Autowired
	DetailtravelnotesDAO dnotsDAO;

	/**
	 * @param starinfo
	 */
	public String star(String starinfo) {
		JSONObject obj = JSON.parseObject(starinfo);
		// 点赞还是取消点赞 0是点赞1是取消点赞
		int tag = obj.getIntValue("tag");
		// 点赞的人的ID
		int userId = obj.getIntValue("userId");
		int type = obj.getIntValue("type");
		int id = obj.getIntValue("id");
		// 0是点赞
		if (tag == 0) {
			Stars star = new Stars();
			if (type == 0) {
				// 给哪个新景点点赞
				// int newSpotsId = obj.getIntValue("newSpotsId");
				Newscenicspots spots = spotsDAO.findById(id);
				spots.setStarCount(spots.getStarCount() + 1);
				spotsDAO.merge(spots);
				star.setNewscenicspots(spots);
			} else if (type == 1) {
				// 给哪个游记点赞
				// int travelnotesId = obj.getIntValue("travelnotesId");
				Travelnotes notes = travelnotesDAO.findById(id);
				notes.setStarCount(notes.getStarCount() + 1);
				travelnotesDAO.merge(notes);
				star.setTravelnotes(notes);
			} else {
				Detailtravelnotes dnotes = dnotsDAO.findById(id);
				dnotes.setStarCount(dnotes.getStarCount() + 1);
				dnotsDAO.merge(dnotes);
				star.setDetailtravelnotes(dnotes);
				// TODO
			}
			star.setTopicType(type);
			star.setUser(userDAO.findById(userId));
			starDAO.save(star);
			return MarkResult.getResult(1, null);
		} else {
			Stars star = starDAO.findStar(userId, type, id);
			starDAO.delete(star);
			return MarkResult.getResult(1, null);
		}

	}

	/**
	 * @param commentinfo
	 */
	public String comment(String commentinfo) {
		JSONObject obj = JSON.parseObject(commentinfo);
		// 评论的人的ID
		int userId = obj.getIntValue("userId");
		int toUserId = obj.getIntValue("toUserId");
		// 评论的类型。是给新景点 评论还是给游记 给详细游记呢。 分别是：0 1 2
		int type = obj.getIntValue("type");
		String content = obj.getString("content");
		Comments comment = new Comments();
		int id = obj.getIntValue("id");
		if (type == 0) {
			// 给哪个游记点赞
			// int newSpotsId = obj.getIntValue("newSpotsId");
			Newscenicspots spots = spotsDAO.findById(id);
			spots.setCommentCount(spots.getCommentCount() + 1);
			spotsDAO.merge(spots);
			comment.setNewscenicspots(spots);
		} else if (type == 1) {
			// int travelnotesId = obj.getIntValue("travelnotesId");
			Travelnotes notes = travelnotesDAO.findById(id);
			notes.setCommentCount(notes.getCommentCount() + 1);
			travelnotesDAO.merge(notes);
			comment.setTravelnotes(notes);
		} else {
			// TODO
			Detailtravelnotes dnotes = dnotsDAO.findById(id);
			dnotes.setCommentCount(dnotes.getCommentCount() + 1);
			dnotsDAO.merge(dnotes);
			comment.setDetailtravelnotes(dnotes);
		}
		comment.setUserByFromUid(userDAO.findById(userId));
		comment.setTopicType(type);
		// 为0表示是回复文章不是回复人
		if (toUserId == 0) {
			comment.setUserByToUid(null);
		} else {
			comment.setUserByToUid(userDAO.findById(toUserId));
		}
		comment.setDatetime(Timestamp.valueOf(obj.getString("datetime")));
		comment.setContent(content);
		commentDAO.save(comment);
		return MarkResult.getResult(1, null);
	}
}
