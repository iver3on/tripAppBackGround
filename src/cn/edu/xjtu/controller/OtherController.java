/**
 * 
 */
package cn.edu.xjtu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xjtu.service.OtherService;

/**
 * @author Iver3oN Zhang
 * @date 2016年6月5日
 */

@Controller
@RequestMapping("other")
public class OtherController {

	@Autowired
	OtherService othsService;

	@RequestMapping(value = "aboutUs", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String aboutUs() {
		return othsService.aboutUs();
	}
}
