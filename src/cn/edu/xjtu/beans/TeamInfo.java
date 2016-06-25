/**
 * 
 */
package cn.edu.xjtu.beans;

/**
 * @author Iver3oN Zhang
 * @date 2016年6月5日
 */
public class TeamInfo {
	public final static String PRODUCT_NAME_CHINESE = "友行";
	public final static String PRODUCT_NAME_ENGLISH = "FriendTrip";
	public final static String PRODUCT_MARK = "友情伴随旅行，让心灵产生共鸣";
	public final static String PRODUCT_WEBSITE = "www.friendtrip.com";
	public final static String PRODUCT_RIGHT = "@2016 FRIENDTRIP.COM ALL RIGHT RESERVED";

	public static String toJSON() {
		return "{\"PRODUCT_NAME_CHINESE\":\"" + PRODUCT_NAME_CHINESE
				+ "\",\"PRODUCT_NAME_ENGLISH\":\"" + PRODUCT_NAME_ENGLISH
				+ "\",\"PRODUCT_MARK\":\"" + PRODUCT_MARK
				+ "\",\"PRODUCT_WEBSITE\":\"" + PRODUCT_WEBSITE
				+ "\",\"PRODUCT_RIGHT\":\"" + PRODUCT_RIGHT + "\"}";
	}

}
