package com.bw.utils;

import java.sql.Date;

public class DateUtil {
	/*方法1：根据传入的日期获取年龄*/
	//示例:
	public static int getAge (Date src) {
		Date date= new Date(20);
		int age= date.getYear();
		return age;
	}
	
	/*方法2：根据传入的参数获取该日期的月初日期，
	 *例如给定的日期为“2019-09-19 19:29:39”，
	 *返回“2019-09-01 00:00:00”
	 */
	//示例:
	public static Date getDateByMonthInit (Date src) {
		return src;
	//TODO
	}
	
	/*方法3 :根据传入的参数获取该日器的月末日期，
	 *例如给定的日期为“2019-09-19 19:29:39”，
	 *返回“2019-09-30 23:59:59”，注意月大月小以及闰年。
	 */
	//示例:
	public static Date getDateByMonthLast(Date src) {
		long time = src.getTime();
		
		return src;
	//TODO
	}
	
	/*方法4：求未来日期离今天还剩的天数*/
	//示例:
	public static int getDaysByFuture (Date future) {
		long time = future.getTime();
		return 1;
	//TODO
	}
	/*方法5：求过去日期离今天过去的天数*/
	//示例:
	public static int getDaysByDeparted (Date departed) {
		Object clone = departed.clone();
		
		return 10;
	//TODO
	}
}
