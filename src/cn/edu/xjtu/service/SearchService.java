/**
 * 
 */
package cn.edu.xjtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.edu.xjtu.dao.DetailtravelnotesDAO;
import cn.edu.xjtu.dao.NewscenicspotsDAO;
import cn.edu.xjtu.dao.TravelnotesDAO;
import cn.edu.xjtu.pojo.Detailtravelnotes;
import cn.edu.xjtu.pojo.Newscenicspots;
import cn.edu.xjtu.pojo.Travelnotes;

/**
 * @author Iver3oN Zhang
 * @date 2016年6月14日
 */
@Service
public class SearchService {
	@Autowired
	NewscenicspotsDAO spotsDAO;
	@Autowired
	TravelnotesDAO notesDAO;
	@Autowired
	DetailtravelnotesDAO detailTravelNotesDAO;
	@Autowired
	NewScenicSpotsService spotsService;
	@Autowired
	TravelNotesService notesService;
	@Autowired
	DetailTravelNotesService detailTravelNotesService;
	/**
	 * @return
	 */
	public  String search() {
		List<Newscenicspots> spots = spotsDAO.getTopSpots(0, 5);
		List<Travelnotes> notes = notesDAO.getTopNotes(0,5);
		List<Detailtravelnotes> detailtravelnotes = detailTravelNotesDAO.findTopStar(0, 5);
		JSONObject obj = new JSONObject();
		obj.put("spots",JSON.parse(spotsService.parseListToJsonString(spots)));
		obj.put("notes",JSON.parse(notesService.parseListToJsonString(notes)));
		obj.put("detailNotes", JSON.parse(detailTravelNotesService.parseListToJsonString(detailtravelnotes)));
		return obj.toJSONString();
	}
}
