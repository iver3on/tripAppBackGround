/**
 * 新景点的控制器
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

import cn.edu.xjtu.service.NewScenicSpotsService;

/**
 * @author Iver3oN Zhang
 * @date 2016年5月26日
 * @email grepzwb@qq.com NewScenicspotsController.java Impossible is nothing
 */
@Controller
@RequestMapping("newscenicspots")
public class NewScenicspotsController {

	private static Logger logger = LoggerFactory
			.getLogger(NewScenicspotsController.class);

	@Autowired
	NewScenicSpotsService spotsService;

	// 添加景点
	@RequestMapping(value = "addSpots", method = RequestMethod.POST)
	@ResponseBody
	public String addSpots(@RequestBody String spots) {
		logger.info(spots);
		return spotsService.addSpots(spots);
	}

	// 按照游记ID得到详细游记
	@RequestMapping(value = "/{id}/getSpotsById", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getSpotsById(@PathVariable Integer id) {
		String spot = spotsService.getSpotsById(id);
		return spot;
	}

	// 根据APP定位的用户的位置信息，返回附近的新景点。景点表有经纬度和地点名称。。这个估计得分析。(一般附近新景点少。没有必要看点赞量最多的)
	@RequestMapping(value = "findAllSpots", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findAllSpotsByLocation(@RequestBody String location) {
		return spotsService.getNearBySpots(location);
	}

	// 找到点赞量前几的新景点 limit和offset
	@RequestMapping(value = "/{offset}/{limit}/findTopStarSpots", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findTopStarSpots(@PathVariable Integer offset,
			@PathVariable Integer limit) {
		return spotsService.findTopSpots(offset, limit);
	}

	// TODO

	// 找到评论量前几的新景点 limit和offset
	@RequestMapping(value = "/{offset}/{limit}/findTopCommentSpots", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findTopCommentSpots(@PathVariable Integer offset,
			@PathVariable Integer limit) {
		return spotsService.findTopCommentSpots(offset, limit);
	}

	// 查询此用户添加的所有景点
	@RequestMapping(value = "/{id}/getSpotsByUserId", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getDetailNotesByUserId(@PathVariable Integer id) {
		String notes = spotsService.getSpotsByUserId(id);
		return notes;
	}

	// 删除景点
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String deleteSpots(@PathVariable Integer id) {
		return spotsService.delete(id);
	}

	@RequestMapping(value = "updateSpots", method = RequestMethod.POST)
	@ResponseBody
	public String updateInfo(@RequestBody String info) {
		return spotsService.updateInfo(info);
	}
}
