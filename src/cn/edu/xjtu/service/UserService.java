/**
 * 
 */
package cn.edu.xjtu.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.xjtu.dao.UserDAO;
import cn.edu.xjtu.pojo.User;
import cn.edu.xjtu.util.AvatarUtil;
import cn.edu.xjtu.util.MarkResult;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Iver3oN Zhang
 * @date 2016年5月29日
 */

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;

	/**
	 * @param info
	 * @return
	 */
	public String register(String info) {
		JSONObject obj = JSON.parseObject(info);
		String username = obj.getString("username");
		User user = new User();
		user.setName(username);
		user.setPassword(obj.getString("password"));
		user.setNickname(obj.getString("nickname"));
		user.setPushtoken(obj.getString("pushtoken"));
		user.setProfilePhoto(AvatarUtil.getAvatarURL());
		user.setFocusCount(0);
		user.setIsFocusCount(0);
		user.setFriendsCount(0);
		userDAO.save(user);
		return getPersonalInfo(username);
	}

	// 此用户名是否存在
	public String isExits(String name) {
		if (userDAO.findByName(name).size() != 0)
			return "exits";
		else
			return "notExits";
	}

	/**
	 * @param loginInfo
	 * @return
	 */
	public String login(String loginInfo) {
		JSONObject obj = JSON.parseObject(loginInfo);
		String username = obj.getString("username");
		String password = obj.getString("password");
		if (isRight(username, password)) {
			return getPersonalInfo(username);
		}
		return MarkResult.getResult(0, "用户名或者密码错误");
	}

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	private boolean isRight(String username, String password) {
		return userDAO.findUserByNameAndPassword(username, password) != null;
	}

	/**
	 * @return
	 */
	public String getPersonalInfo(String username) {
		User u = (User) userDAO.findByName(username).get(0);
		return MarkResult.getResult(1, JSON.parseObject(u.toJSON()));
	}

	/**
	 * @param userid
	 * @return
	 */
	public String getPersonalInfo(Integer userid) {
		User u = userDAO.findById(userid);
		return u.toJSON();
	}

	/**
	 * @param info
	 * @return
	 */
	public String updateInfo(String info) {
		JSONObject json = JSON.parseObject(info);
		User u = userDAO.findById(json.getInteger("id"));
		String password = json.getString("password");
		String nickname = json.getString("nickname");
		String photo = json.getString("profilephoto");
		String email = json.getString("email");
		String region = json.getString("region");
		String gender = json.getString("gender");
		String birthday = json.getString("birthday");
		String signature = json.getString("signature");
		if (!password.equals(""))
			u.setPassword(password);
		if (!nickname.equals(""))
			u.setNickname(nickname);
		if (!email.equals(""))
			u.setEmail(email);
		if (!photo.equals(""))
			u.setProfilePhoto(photo);
		if (!region.equals(""))
			u.setRegion(region);
		if (!gender.equals(""))
			u.setGender(gender);
		if (!birthday.equals(""))
			u.setBirthday(Date.valueOf(birthday));
		if (!signature.equals(""))
			u.setSignature(signature);
		userDAO.merge(u);
		return MarkResult.getResult(1, u.toJSON());
	}
}
