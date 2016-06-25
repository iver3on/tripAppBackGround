package cn.edu.xjtu.util;

import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.xjtu.pojo.Comments;
import cn.edu.xjtu.pojo.Stars;
import cn.edu.xjtu.pojo.Travelnotespicture;
import cn.edu.xjtu.pojo.User;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import edu.emory.mathcs.backport.java.util.TreeSet;

/**
 * @author Iver3oN Zhang
 * @date 2016年6月2日
 */
public class JSONUtil {

	static Logger logger = LoggerFactory.getLogger(JSONUtil.class);

	// 点赞集合解析成JSON
	public static String toStarJSON(Set set) {
		Iterator<Stars> iter = set.iterator();
		JSONArray array = new JSONArray();
		while (iter.hasNext()) {
			Stars star = iter.next();
			User u = star.getUser();
			array.add(JSON.parse(u.toJSON()));
		}
		logger.info("array:" + array.toJSONString());
		return array.toJSONString();
	}

	// 评论集合解析成JSON
	public static String toCommentJSON(Set set) {
		System.out.println(set.size());
		Iterator<Comments> iter = set.iterator();
		JSONArray array = new JSONArray();
		while (iter.hasNext()) {
			Comments comments = iter.next();
			array.add(JSON.parse(comments.toString()));
		}
		logger.info("array:" + array.toJSONString());
		return array.toJSONString();
	}

	/*
	 * // 图片集合解析成JSON public static String toPicJSON(Set set) { int size =
	 * set.size(); JSONArray array = new JSONArray(); if(size==0) return "[]";
	 * else if(size==1){ Iterator<Travelnotespicture> iter = set.iterator();
	 * while (iter.hasNext()) { Travelnotespicture pic = iter.next();
	 * array.add(JSON.parse(pic.toString())); } logger.info("array:" +
	 * array.toJSONString()); }else if(size>1){ //
	 * 使用treeset并实现comparable接口对picture按照position排序 Set s = new TreeSet(set);
	 * Iterator<Travelnotespicture> iter = s.iterator(); while (iter.hasNext())
	 * { Travelnotespicture pic = iter.next();
	 * array.add(JSON.parse(pic.toString())); } logger.info("array:" +
	 * array.toJSONString()); } return array.toJSONString(); }
	 */
	public static String toPicJSON(Set set) {
		JSONArray array = new JSONArray();
		// 使用treeset并实现comparable接口对picture按照position排序
		Set s = new TreeSet(set);
		Iterator<Travelnotespicture> iter = s.iterator();
		while (iter.hasNext()) {
			Travelnotespicture pic = iter.next();
			array.add(JSON.parse(pic.toString()));
		}
		logger.info("array:" + array.toJSONString());
		return array.toJSONString();
	}
}
