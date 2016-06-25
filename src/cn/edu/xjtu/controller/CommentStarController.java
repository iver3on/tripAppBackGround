/**
 * 评论 点赞  的控制器。对新景点评论 点赞。对游记评论 点赞。
 */
package cn.edu.xjtu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xjtu.service.CommentStarService;

/**
 * @author Iver3oN Zhang
 * @date 2016年5月29日
 */

@Controller
@RequestMapping("commentOrStar")
public class CommentStarController {
	private static Logger logger = LoggerFactory
			.getLogger(CommentStarController.class);

	@Autowired
	CommentStarService commentStarService;

	// 点赞
	@RequestMapping(value = "star", method = RequestMethod.POST)
	@ResponseBody
	public String star(@RequestBody String starinfo) {
		logger.info("star" + starinfo);
		return commentStarService.star(starinfo);
	}

	// 评论
	@RequestMapping(value = "comment", method = RequestMethod.POST)
	@ResponseBody
	public String comment(@RequestBody String commentinfo) {
		return commentStarService.comment(commentinfo);
	}
}
