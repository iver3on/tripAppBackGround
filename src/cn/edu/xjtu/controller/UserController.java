/**
 * 注册用户的控制器  
 */
package cn.edu.xjtu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xjtu.service.UserService;

/**
 * @author Iver3oN Zhang
 * @date 2016年5月29日
 */

@Controller
@RequestMapping("user")
public class UserController {

	private static Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	UserService userService;

	// 注册
	@RequestMapping(value = "register", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String register(@RequestBody String info) {
		logger.info(info);
		String result = userService.register(info);
		return result;
	}

	// 注册结果 检查手机号码
	@RequestMapping(value = "/{username}/registerResult", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String registerResult(@PathVariable String username) {
		String result = userService.isExits(username);
		return result;
	}

	// 登录
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String login(@RequestBody String loginInfo) {
		return userService.login(loginInfo);
	}

	// 查找个人信息
	@RequestMapping(value = "getInfo/{userid}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getInfo(@PathVariable Integer userid) {
		return userService.getPersonalInfo(userid);
	}

	// 更新个人资料
	@RequestMapping(value = "update", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateInfo(@RequestBody String info) {
		return userService.updateInfo(info);
	}
}
