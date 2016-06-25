/**
 * 关系控制器。用户好友关系。加好友。查好友。删除好友等。
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

import cn.edu.xjtu.service.RelationService;

/**
 * @author Iver3oN Zhang
 * @date 2016年5月29日
 */
@Controller
@RequestMapping("relation")
public class RelationController {

	private static Logger logger = LoggerFactory
			.getLogger(RelationController.class);

	@Autowired
	RelationService relationService;

	// 关注
	@RequestMapping(value = "focus", method = RequestMethod.POST)
	@ResponseBody
	public String focus(@RequestBody String info) {
		logger.info(info);
		return relationService.focus(info);
	}

	// 查看我的所有关注
	@RequestMapping(value = "/{myid}/myFocus", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getMyFocus(@PathVariable int myid) {
		return relationService.getMyFocus(myid);
	}

	// 取消关注
	// 关注
	@RequestMapping(value = "unFocus/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String unFocus(@RequestBody Integer id) {
		return relationService.unFocus(id);
	}

	//a是否关注b
	@RequestMapping(value = "isFocus", method = RequestMethod.POST)
	@ResponseBody
	public String isFocus(Integer a_id,Integer b_id){
		return relationService.isFocus(a_id,b_id);
	}
	
}
