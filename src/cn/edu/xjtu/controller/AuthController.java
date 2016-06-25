package cn.edu.xjtu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.qcloud.PicCloud;

@Controller
@RequestMapping("auth")
public class AuthController {
	private static final Logger logger = LoggerFactory
			.getLogger(AuthController.class);

	@RequestMapping(value = "/qPicAuth", method = RequestMethod.GET)
	@ResponseBody
	public String qPicAuth(String type, String fileid) {
		// 请将下面的APP_ID_V2，SECRET_ID_V2，SECRET_KEY_V2，BUCKET替换为开发者自己的项目信息
		int APP_ID_V2 = 10042654; // 项目ID
		String SECRET_ID_V2 = "AKIDGAh2WYUcIpliJ0vMrUzLGHztYv2h3cRo"; // 项目SecretID
		String SECRET_KEY_V2 = "P1QwPYqYmMltQv9lFcM15SkYG1dkY4HY"; // 项目SecretKey
		String BUCKET = "friendtrip"; // 空间名称bucket
		PicCloud pc = new PicCloud(APP_ID_V2, SECRET_ID_V2, SECRET_KEY_V2,
				BUCKET);
		String sign = "";
		long expired = System.currentTimeMillis() / 1000 + 3600;
		if (null == type || "".equals(type)) {
			sign = pc.getSign(expired);
		} else if ("upload".equals(type)) {
			sign = pc.getSign(expired);
		} else if ("copy".equals(type) || "del".equals(type)
				|| "download".equals(type)) {
			sign = pc.getSignOnce(fileid);
		} else {
			sign = "";
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ver", "V2");
		jsonObject.put("sign", sign.toString());
		return jsonObject.toJSONString();
	}
}
