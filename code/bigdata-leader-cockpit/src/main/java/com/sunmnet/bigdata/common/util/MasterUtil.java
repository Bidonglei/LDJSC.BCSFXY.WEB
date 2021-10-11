package com.sunmnet.bigdata.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 学期工具类
 * */
public class MasterUtil {
	
	/*
	 * 获取系统当前的时间，例如现在是2017-11，然后判断学期开始的时间，返回学期开始的时间，例如2017-09
	 * 例如，现在是2017-03，判断学期开始的时间，返回学期开始的时间，例如：2017-02
	 * 
	 * */
	 public String getMaster() {
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
	    	String time1 = df.format(new Date());
	    	System.out.println("time1:"+time1);
	    	String tmp = time1.substring(5, 7);
	    	System.out.println("tmp:"+tmp);
	    	String tmp2 = time1.substring(0,4);
	    	Integer tmp3 = Integer.parseInt(tmp2);
	    	tmp2=(tmp3-1)+"";
	    	System.out.println("tmp2:"+tmp2);
	    	Integer num = Integer.parseInt(tmp);
	    	if(num>=9&&num <=12) {
	    		return tmp2+"-09";
	    	}else if(num>=1&&num<2) {
	    		return tmp2+"-09";
	    	}else {
	    		return tmp2+"-02";
	    	}
	    }
}
