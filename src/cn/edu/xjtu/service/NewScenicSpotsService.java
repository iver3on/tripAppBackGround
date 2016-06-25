/**
 * 
 */
package cn.edu.xjtu.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.xjtu.dao.NewscenicspotsDAO;
import cn.edu.xjtu.dao.TravelnotespictureDAO;
import cn.edu.xjtu.dao.UserDAO;
import cn.edu.xjtu.pojo.Newscenicspots;
import cn.edu.xjtu.pojo.Travelnotespicture;
import cn.edu.xjtu.util.MarkResult;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Iver3oN Zhang
 * @date 2016年5月26日
 * @email grepzwb@qq.com NewScenicspotsService.java Impossible is nothing
 */
@Service
public class NewScenicSpotsService {

	@Autowired
	UserDAO userDAO;

	@Autowired
	private NewscenicspotsDAO spotsDAO;

	@Autowired
	TravelnotespictureDAO picDAO;

	public String addSpots(String spots) {
		return parseSpot(spots);
	}

	public String parseSpot(String spots) {
		Newscenicspots spot = new Newscenicspots();
		JSONObject obj = JSON.parseObject(spots);
		spot.setScenicname(obj.getString("scenicname"));
		spot.setLongitude(obj.getDouble("longitude"));
		spot.setLatitude(obj.getDouble("latitude"));
		spot.setSummary(obj.getString("summary"));
		spot.setLocation(obj.getString("location"));
		spot.setCommentCount(0);
		spot.setStarCount(0);
		spot.setScanCount(0);
		spot.setDatetime(Timestamp.valueOf(obj.getString("datetime")));
		int id = obj.getIntValue("userid");
		spot.setUser(userDAO.findById(id));
		spotsDAO.save(spot);
		// 获取游记图片属性jsonarray
		JSONArray array = JSON.parseArray(obj.getString("travlenotespictures"));
		// int type = obj.getIntValue("type");
		for (int i = 0; i < array.size(); i++) {
			Travelnotespicture pic = new Travelnotespicture();
			pic.setSummary(array.getJSONObject(i).getString("summary"));
			pic.setUrl(array.getJSONObject(i).getString("url"));
			pic.setPosition(array.getJSONObject(i).getInteger("position"));
			pic.setNewscenicspots(spot);
			// System.out.println(array.getJSONObject(i).getString("summary"));
			picDAO.save(pic);
		}
		return MarkResult.getResult(1, null);
	}

	/**
	 * @param location
	 * @return
	 */
	public String getNearBySpots(String location) {
		JSONObject obj = JSON.parseObject(location);
		double longitude = obj.getDoubleValue("longitude");
		double latitude = obj.getDoubleValue("latitude");
		int limit = obj.getIntValue("limit");
		List<Newscenicspots> list = spotsDAO.getNearBySpots(longitude,
				latitude, limit);
		return parseListToJsonString(list);
	}

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	public String findTopSpots(Integer offset, Integer limit) {
		List<Newscenicspots> list = spotsDAO.getTopSpots(offset, limit);
		return parseListToJsonString(list);
	}

	/**
	 * @param id
	 * @return
	 */
	public String getSpotsByUserId(Integer id) {
		List<Newscenicspots> list = spotsDAO.getSpotsByUserId(id);
		return parseListToJsonString(list);
	}

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	public String findTopCommentSpots(Integer offset, Integer limit) {
		List<Newscenicspots> list = spotsDAO.getTopCommentSpots(offset, limit);
		return parseListToJsonString(list);
	}

	/**
	 * @param id
	 * @return
	 */
	public String delete(Integer id) {
		Newscenicspots spots = spotsDAO.findById(id);
		if (spots != null) {
			spotsDAO.delete(spots);
			return MarkResult.getResult(1, null);
		} else {
			return MarkResult.getResult(0, "出错，请稍后删除");
		}
	}

	// 将获取到的结果List 转换为json字符串返回给app
	public String parseListToJsonString(List<Newscenicspots> list) {
		JSONArray array = new JSONArray();
		for (Newscenicspots spot : list) {
			JSONObject obj = JSON.parseObject(spot.toString());
			array.add(obj);
		}
		return array.toJSONString();
	}

	/**
	 * @param info
	 * @return
	 */
	public String updateInfo(String info) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param id
	 * @return
	 */
	public String getSpotsById(Integer id) {
		Newscenicspots spot = spotsDAO.findById(id);
		spot.setScanCount(spot.getScanCount() + 1);
		spotsDAO.merge(spot);
		return spot.toString();
	}

}
