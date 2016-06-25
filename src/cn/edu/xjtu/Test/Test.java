package cn.edu.xjtu.Test;

import cn.edu.xjtu.beans.TeamInfo;
import cn.edu.xjtu.util.AvatarUtil;
import cn.edu.xjtu.util.GetDistance;

public class Test {

	public static void main(String[] args) {
		/*
		 * List<Student> students = new ArrayList<Student>(); for (int i = 0; i
		 * < 5; i++) { Student stu = new Student(i, "Student" + i, 18 + i);
		 * students.add(stu); } System.out.println(JSON.toJSONString(students));
		 */
	//	System.out.println(GetDistance.GetLongDistance(109.007858, 34.229602,
		//		112.454638, 34.624029));
		//System.out.println(TeamInfo.toJSON());
		System.out.println(AvatarUtil.getAvatarURL());
	}
}
