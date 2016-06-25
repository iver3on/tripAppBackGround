package cn.edu.xjtu.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.xjtu.dao.TravelnotesDAO;
import cn.edu.xjtu.dao.TravelnotespictureDAO;
import cn.edu.xjtu.dao.UserDAO;
import cn.edu.xjtu.pojo.Travelnotes;
import cn.edu.xjtu.pojo.Travelnotespicture;
import cn.edu.xjtu.util.MarkResult;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
public class TravelNotesService {

	@Autowired
	TravelnotesDAO notesDAO;
	@Autowired
	TravelnotespictureDAO picDAO;
	@Autowired
	UserDAO userDAO;

	// 添加游记，其中包括添加游记的图片信息
	public String addNotes(String nodesInfo) {
		JSONObject json = JSON.parseObject(nodesInfo);
		/*
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 * String datetime = ;
		 */
		// 获取游记的属性
		Travelnotes notes = new Travelnotes();
		notes.setDatetime(Timestamp.valueOf(json.getString("datetime")));
		notes.setDiscription(json.getString("discription"));
		notes.setLocation(json.getString("location"));
		notes.setRightType(json.getIntValue("rightType"));
		notes.setLongitude(json.getDouble("longitude"));
		notes.setLatitude(json.getDouble("latitude"));
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
			pic.setTravelnotes(notes);
			pic.setPosition(array.getJSONObject(i).getInteger("position"));
			System.out.println(array.getJSONObject(i).getString("summary"));
			picDAO.save(pic);
		}
		return MarkResult.getResult(1, null);
	}

	public String getNotesByUserId(Integer id) {
		List<Travelnotes> list = notesDAO.findAllNotesByUserId(id);
		return parseListToJsonString(list);
	}

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	public String findTopNotes(Integer offset, Integer limit) {
		List<Travelnotes> list = notesDAO.getTopNotes(offset, limit);
		return parseListToJsonString(list);
	}

	/**
	 * @param info
	 * @return
	 */
	public String getNotesByLocation(String info) {

		return null;
	}

	/**
	 * @param info
	 * @return
	 */
	public String getMyFriendsNotesByLocation(String info) {
		JSONObject json = JSON.parseObject(info);
		double longitude = json.getDoubleValue("longitude");
		double latitude = json.getDoubleValue("latitude");
		int userid = json.getIntValue("userid");
		int limit = json.getIntValue("count");
		List<Travelnotes> list = notesDAO.getNotesOfMyfriends(userid,
				longitude, latitude, limit);
		return parseListToJsonString(list);
	}

	/**
	 * @param id
	 * @return
	 */
	public String getNotesById(Integer id) {
		Travelnotes notes = notesDAO.findById(id);
		notes.setScanCount(notes.getScanCount() + 1);
		notesDAO.merge(notes);
		return notes.toString();
	}

	// //将获取到的结果List 转换为json字符串返回给app
	public String parseListToJsonString(List<Travelnotes> list) {
		JSONArray array = new JSONArray();
		for (Travelnotes notes : list) {
			JSONObject obj = JSON.parseObject(notes.toString());
			array.add(obj);
		}
		return array.toJSONString();
	}

	/**
	 * @param id
	 * @return
	 */
	public String getRecentMyFriendsNotes(Integer id) {
		List<Travelnotes> list = notesDAO.findByTime(id);
		return parseListToJsonString(list);
	}

	/**
	 * @param id
	 * @return
	 */
	public String delete(Integer id) {
		Travelnotes notes = notesDAO.findById(id);
		if (notes != null) {
			notesDAO.delete(notes);
			return MarkResult.getResult(1, null);
		} else {
			return MarkResult.getResult(0, "出错，请稍后删除");
		}
	}
}
