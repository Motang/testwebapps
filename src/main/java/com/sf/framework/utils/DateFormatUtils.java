package com.sf.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式转换工具类
 * 
 * @author 625586
 * 
 */
public class DateFormatUtils extends org.apache.commons.lang3.time.DateFormatUtils {

	public static String format(Date date) {
		if (date == null) {
			return null;
		}
		String s = org.apache.commons.lang3.time.DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
		if (s == null) {
			return org.apache.commons.lang3.time.DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return s;
	}

	/**
	 * 功能：按照日期格式，将字符串解析为日期对象
	 * 
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static final Date parseDate(String strDate, String format) {

		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(format);

		try {
			date = df.parse(strDate);
		} catch (ParseException e) {
		}

		return (date);
	}

	/**
	 * 功能：将默认日期转成指定格式日期对象
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date formatDate(Date date, String format) {
		SimpleDateFormat inDf = new SimpleDateFormat(format);
		SimpleDateFormat outDf = new SimpleDateFormat(format);
		String reDate = "";
		try {
			reDate = inDf.format(date);
			return outDf.parse(reDate);
		} catch (Exception e) {

		}
		return date;
	}

}
