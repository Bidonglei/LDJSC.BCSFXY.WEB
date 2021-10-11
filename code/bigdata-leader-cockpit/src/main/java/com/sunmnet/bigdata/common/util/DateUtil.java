package com.sunmnet.bigdata.common.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期公共方法类
 * @author wm
 * @create 2018-01-23 
 */
public class DateUtil {
    /**
     * 年月日时分秒(无下划线) yyyyMMddHHmmss
     */
    public static final String dtLong = "yyyyMMddHHmmss";
    /**
     * 年月日时分秒毫秒(无下划线) yyyyMMddHHmmssSSS
     */
    public static final String dateandtime = "yyyyMMddHHmmssSSS";

    /**
     * 完整时间 yyyy-MM-dd HH:mm:ss
     */
    public static final String simple = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年月日(无下划线) yyyyMMdd
     */
    public static final String dtShort = "yyyyMMdd";

    /**
     * 月日(无下划线) MMdd
     */
    public static final String monthDay = "MMdd";

    /**
     * 年(无下划线) yyyy
     */
    public static final String year = "yyyy";
    /**
     * 月(无下划线) MM
     */
    public static final String month = "MM";
    
    /**
     * 时间    HH:mm:ss
     */
    public static final String dtTime = "HH:mm:ss";
    /**
     * 时间    HHmmss
     */
    public static final String dateTime = "HHmmss";

    /**
     * 年月日 yyyy-MM-dd
     */
    public static final String dtDate = "yyyy-MM-dd";


    /**
     * 当前时间加减天数    加传正数减传负数
     *
     * @return 以yyyy-MM-dd为格式的时间
     */
    public static String getNewDate(int count) {
        Date date = new Date();
        date = new Date(date.getTime() + count * 24 * 60 * 60 * 1000);
        DateFormat df = new SimpleDateFormat(dtDate);
        return df.format(date);
    }


    /**
     * 返回系统当前时间(精确到毫秒)
     * @return 以yyyyMMddHHmmssSSS为格式的当前系统时间
     */
    public static String getDateAndTimes() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dateandtime);
        return df.format(date);
    }


    /**
     * 返回系统当前时间,作为一个唯一的订单编号
     * @return 以yyyyMMddHHmmss为格式的当前系统时间
     */
    public static String getTimeDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtLong);
        return df.format(date);
    }

    /**
     * 获取系统当前日期(精确到毫秒)，格式：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getDateFormatter() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(simple);
        return df.format(date);
    }

    /**
     * 获取系统当期年月日(精确到天)，格式：yyyyMMdd
     * @return
     */
    public static String getDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtShort);
        return df.format(date);
    }


    /**
     * 获取系统当期月日(精确到天)，格式：MMdd
     * @return
     */
    public static String getMonthDay() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(monthDay);
        return df.format(date);
    }
    /**
     * 获取系统当期年，格式：yyyy
     * @return
     */
    public static String getYear() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(year);
        return df.format(date);
    }
    /**
     * 获取系统当期月，格式：MM
     * @return
     */
    public static String getMonth() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(month);
        return df.format(date);
    }
    /**
     * 获取系统当期年月日(精确到天带下划线-)，格式：yyyy-MM-dd
     * @return
     */
    public static String getDayDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtDate);
        return df.format(date);
    }


    /**
     * 获取系统时间，格式：HH:mm:ss
     * @return
     */
    public static String getTime() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtTime);
        return df.format(date);
    }


    /**
     * 获取系统时间，格式：HHmmss
     * @return
     */
    public static String getDateTime() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dateTime);
        return df.format(date);
    }


    /**
     * 取得日期date以后某日的日期，如果要的得到以前的日期，参数传负值
     * @param date 基准日期   days 要加的天数
     * @return
     */
    public static String addDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date).toString();
    }

    /**
     * 将日期字符串yyyyMMdd转换为格式 yyyy-MM-dd
     * @param str
     * @return
     */
    public static String stringFormat(String str) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        return df.format(date);
    }


    /**
     * 将日期字符串转换日期为格式 yyyyMMdd
     * @param str
     * @return
     */
    public static Date stringToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 获取开始时间和结束时间中间的时间字符串
     * @param startdate 开始时间
     * @param enddate   结束时间
     * @return List<String>
     */
    public static List<String> getBetweenTwoDateAllDateString(String startdate, String enddate) {
        List<String> str = new ArrayList<String>();

        Date date1 = stringToDate(startdate);
        Date date2 = stringToDate(enddate);
        str.add(stringFormat(startdate));
        if (date2.getTime() == date1.getTime()) {

        } else {
            while (date2.getTime() > date1.getTime()) {
                date1 = stringToDate(startdate);
                startdate = addDay(date1, 1);
                str.add(stringFormat(startdate));
            }
            str.remove(str.size() - 1);
        }

        return str;
    }

    /**
     * 获取系统时间，格式：HHmm
     * @return
     */
    public static String getPayDateTime() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HHmm");
        return df.format(date);
    }
    
    /**
     * 将日期字符串yyyyMMdd转换为时间戳
     * @param str
     * @return
     */
    public static Long stringToTimestamp(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
    /**
     * 获取当前13位时间戳
     * @return
     */
    public static Long timeStamp13(){
    	return System.currentTimeMillis();
    }
    
    /**
   	 * 根据输入和输出的格式，格式化字符串日期格式
   	 * @param inFormart 输入格式，字符串日期的格式
   	 * @param outFormart 输出字符串日期格式
   	 * @param strDate 字符串日期
   	 * @author wm
   	 * @date 2018-03-02
   	 * @return String
   	 */
    public static String formartStringDate(String inFormart,String outFormart,String strDate)throws Exception{
    	String result = null;
		SimpleDateFormat inSdf = new SimpleDateFormat(inFormart);
		SimpleDateFormat outSdf = new SimpleDateFormat(outFormart);
		Date date = inSdf.parse(strDate);
		result = outSdf.format(date);
    	return result;
    }
    
    
}
