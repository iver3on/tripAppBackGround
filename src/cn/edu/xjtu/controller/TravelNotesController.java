/*
 * 游记
 * 
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

import cn.edu.xjtu.service.TravelNotesService;

@Controller
@RequestMapping("travelnotes")
public class TravelNotesController {

	private static Logger logger = LoggerFactory
			.getLogger(TravelNotesController.class);

	@Autowired
	TravelNotesService notesService;

	// 添加心情
	@RequestMapping(value = "addNotes", method = RequestMethod.POST)
	@ResponseBody
	public String addNotes(@RequestBody String nodesInfo) {
		logger.info(nodesInfo);
		return notesService.addNotes(nodesInfo);
	}

	// 按照心情ID得到心情
	@RequestMapping(value = "/{id}/getNotesById", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getNotesById(@PathVariable Integer id) {
		String notes = notesService.getNotesById(id);
		return notes;
	}

	// 查询此用户的所有心情
	@RequestMapping(value = "/{id}/getNotesByUserId", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getNotesByUserId(@PathVariable Integer id) {
		String notes = notesService.getNotesByUserId(id);
		return notes;
	}

	// 删除景点
	@RequestMapping(value = "deleteNotes/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String deleteNotes(@PathVariable Integer id) {
		return notesService.delete(id);
	}

	// 找到点赞量前几的心情 limit和offset
	@RequestMapping(value = "/{offset}/{limit}/findTopStarNotes", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findTopStarNotes(@PathVariable Integer offset,
			@PathVariable Integer limit) {
		return notesService.findTopNotes(offset, limit);
	}

	// 根据APP定位信息得到附近的心情（音视频图片）
	@RequestMapping(value = "findNearByNotes", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getNotesByLocation(@RequestBody String info) {
		return notesService.getNotesByLocation(info);
	}

	// 查找 我的好友最近一月发的所有游记
	@RequestMapping(value = "getRecentMyFriendsNotes/{id}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getRecentMyFriendsNotes(@PathVariable Integer id) {
		return notesService.getRecentMyFriendsNotes(id);
	}

	// 查看附近好友的所有心情
	@RequestMapping(value = "getMyFriendsNotesByLocation", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getMyFriendsNotesByLocation(@RequestBody String info) {
		return notesService.getMyFriendsNotesByLocation(info);
	}
}
