/**
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

import cn.edu.xjtu.service.DetailTravelNotesService;

/**
 * @author Iver3oN Zhang
 * @date 2016年6月3日
 */

@Controller
@RequestMapping("detailnotes")
public class DetailtravelnotesController {

	private static Logger logger = LoggerFactory
			.getLogger(DetailtravelnotesController.class);

	@Autowired
	DetailTravelNotesService detailnotesService;

	// 添加详细游记
	@RequestMapping(value = "addDetailNotes", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addDetailNotes(@RequestBody String nodesInfo) {
		logger.info(nodesInfo);
		return detailnotesService.addDetailNotes(nodesInfo);
	}

	// 按照游记ID得到详细游记
	@RequestMapping(value = "/{id}/getDetailNotesById", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getDetailNotesById(@PathVariable Integer id) {
		String notes = detailnotesService.getDetailNotesById(id);
		return notes;
	}

	// 按照用户ID得到他的所有详细游记
	@RequestMapping(value = "/{id}/getDetailNotesByUserId", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getDetailNotesByUserId(@PathVariable Integer id) {
		String notes = detailnotesService.getNotesByUserId(id);
		return notes;
	}

	// 找到点赞量前几的心情 limit和offset
	@RequestMapping(value = "/{offset}/{limit}/findTopStarDetailNotes", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findTopStarNotes(@PathVariable Integer offset,
			@PathVariable Integer limit) {
		return detailnotesService.findTopStarDetailNotes(offset, limit);
	}

	// 根据APP定位信息得到附近的心情（音视频图片）
	@RequestMapping(value = "findNearByDetailNotes", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getNotesByLocation(@RequestBody String info) {
		return detailnotesService.findNearByDetailNotes(info);
	}

	@RequestMapping(value = "getRecentMyFriendsDetailNotes/{id}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public void getRecentMyFriendsNotes() {

	}

	// 删除景点
	@RequestMapping(value = "detailNotes/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String detailDetailNotes(@PathVariable Integer id) {
		return detailnotesService.delete(id);
	}

	// 查看附近好友的所有心情
	@RequestMapping(value = "getMyFriendsDetailNotesByLocation", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getMyFriendsNotesByLocation(@RequestBody String info) {
		return detailnotesService.getMyFriendsDetailNotesByLocation(info);
	}
}
