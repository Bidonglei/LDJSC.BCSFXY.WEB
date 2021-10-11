package com.sunmnet.bigdata.common.util;

import java.util.Calendar;

import com.alibaba.druid.util.StringUtils;

/**
 * 业务相关公共处理类
 * @author niuliqiang
 *
 */
public class BusinessUtils {

	/**
	 * 根据学年获取开始时间
	 * @param schoolYear
	 * @return
	 */
	public static String getStartDateBySchoolYear(String schoolYear) {
		String retDate = "";
		if(StringUtils.isEmpty(schoolYear)) {
			int year =  Calendar.getInstance().get(Calendar.YEAR);
			int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
			if(month <= 8) {
				retDate = (year - 1) + "-09";
			}else {
				retDate = year + "-09";
			}
		}else {
			retDate = schoolYear + "-09";
		}
		return retDate;
	}
	
	/**
	 * 根据学年获取结束时间
	 * @param schoolYear
	 * @return
	 */
	public static String getEndDateBySchoolYear(String schoolYear) {
		String retDate = "";
		if(StringUtils.isEmpty(schoolYear)) {
			int year =  Calendar.getInstance().get(Calendar.YEAR);
			int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
			if(month <= 8) {
				retDate = (year) + "-08";
			}else {
				retDate = (year + 1) + "-08";
			}
		}else {
			retDate = Integer.valueOf(schoolYear) + 1 + "-08";
		}
		return retDate;
	}
	
	/**
	 * 获取当前学期开始日期
	 * @return
	 */
	public static String getCurrTermStartDate() {
		String fromDate = null;
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int year =  Calendar.getInstance().get(Calendar.YEAR);
		if(month <= 2) {
			fromDate = (year - 1) + "-" + "09";
		}
		
		if(month > 2 && month < 9) {
			fromDate = year + "-02";
		}
		
		if(month >= 9) {
			fromDate = year + "-09";
			
		}
		return fromDate;
	}
}
