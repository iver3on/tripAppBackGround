/**
 * 
 */
package cn.edu.xjtu.service;

import cn.edu.xjtu.beans.TeamInfo;

/**
 * @author Iver3oN Zhang
 * @date 2016年6月5日
 */
public class OtherService {

	/**
	 * @return
	 */
	public String aboutUs() {
		return TeamInfo.toJSON();
	}

}
