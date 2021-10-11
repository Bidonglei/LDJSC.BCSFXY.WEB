package com.sunmnet.bigdata.common.util;

import java.util.UUID;

/** 
 * @author 作者 E-mail: 
 * @version 创建时间：2016年8月22日 下午5:01:03 
 * 类说明 
 */
public class UuidUtil {
	 
	public static String createID(){
		 String str = UUID.randomUUID().toString().replaceAll("-", "");
		 String s = str.substring(str.length()-1,str.length());
		 String r = str.substring(str.length()-2,str.length()-1);
		 return getRandomNo(s,r);
	 }
	 public static String getRandomNo(String subSystem,String submodule) {
	        long t = System.currentTimeMillis();
	        long i = 18810900225L;
	        long s = (long) Math.floor(Math.random()*100);
	        String result = subSystem+submodule+(t+i)+s;
	        return result;
	    }
}

 