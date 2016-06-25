/**
 * 
 */
package cn.edu.xjtu.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Iver3oN Zhang
 * @date 2016年6月12日
 */
public class AvatarUtil {
	
	//获取随机头像
	public static String getAvatarURL(){
		List<String> list= new ArrayList<String>();
		list.add("http://7xui79.com1.z0.glb.clouddn.com/resizeApi%20%283%29.png");
		list.add("http://7xui79.com1.z0.glb.clouddn.com/resizeApi.png");
		list.add("http://7xui79.com1.z0.glb.clouddn.com/resizeApi%20%284%29.png");
		list.add("http://7xui79.com1.z0.glb.clouddn.com/resizeApi%20%282%29.png");
		list.add("http://7xui79.com1.z0.glb.clouddn.com/resizeApi%20%281%29.png");
		Random r = new Random();
		return list.get(r.nextInt(list.size()-1));
	}

}
