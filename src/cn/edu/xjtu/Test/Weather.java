/**
 * 
 */
package cn.edu.xjtu.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * @author Iver3oN Zhang
 * @date 2016年6月8日
 */
public class Weather {

	public static String getWeatherString() throws Exception {
		URL url = new URL("http://wthrcdn.etouch.cn/weather_mini?city=西安");
		HttpURLConnection httpURLConnection = (HttpURLConnection) url
				.openConnection();
		/*
		 * httpURLConnection.setRequestProperty("Accept-Charset", "GBK");
		 * httpURLConnection.setRequestProperty("Charset", "GBK");
		 */
		InputStream inputStream = httpURLConnection.getInputStream();
		// 用GZIPInputStream 对原始的输入流包装一下
		GZIPInputStream gis = new GZIPInputStream(inputStream);
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(gis, "UTF-8"));

		// BufferedReader bufferedReader = new BufferedReader(new
		// InputStreamReader(inputStream,"UTF-8"));
		String responseStr = "";
		String readLine = null;
		while ((readLine = bufferedReader.readLine()) != null) {
			responseStr = responseStr + readLine;
		}
		inputStream.close();
		bufferedReader.close();
		httpURLConnection.disconnect();
		return responseStr;
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getWeatherString());
	}

}
