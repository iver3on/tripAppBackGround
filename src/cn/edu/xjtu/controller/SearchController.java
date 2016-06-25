/**
 * 
 */
package cn.edu.xjtu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xjtu.service.SearchService;

/**
 * @author Iver3oN Zhang
 * @date 2016年6月14日
 */

@Controller
@RequestMapping("search")
public class SearchController {
	@Autowired
	SearchService searchService;
	
	//点击搜索输入框。返回点赞了最多热门的新景点   心情 游记 。
	@RequestMapping(value="firstSearch",method = RequestMethod.GET)
	@ResponseBody public String firstSearch(){
		return searchService.search();
	}
}
