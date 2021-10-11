package com.sunmnet.bigdata.systemManage.util;

import java.util.Random;
import java.util.UUID;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.util.HmacSign;

/**
 * 系统公共方法
 * @author wm
 * @create 2018-01-23 
 */
public class MethodUtil {

	
	/**
	 * 判断返回交易是否成功
	 * @author wm
	 * @date 2018-01-23
	 * @param type 序号类型
	 * @return boolean  true成功，false失败
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isSucceed(BaseResponseInfo responseInfo){
        boolean flag=false;
        if(SystemManageConstants.SUCCEED.equals(responseInfo.getCode())){
            flag=true;
        }
        return flag;
    }
	
	/**
	 * 获取固定位数的随机数
	 * @author wm
	 * @date 2018-01-23
	 * @param length 位数
	 * @return int 随机数
	 */
	public static int getRandomNo(int length){
		String min=SystemManageConstants.ONE;
		String max=SystemManageConstants.NINE;
		for(int i=0;i<length;i++){
			min=min+SystemManageConstants.ZERO;
			max=max+SystemManageConstants.NINE;
		}
		return nextInt(Integer.parseInt(min),Integer.parseInt(max));
	}
	public static int nextInt(int min,int max){
		Random random=new Random();
		int randomNo=random.nextInt(max)%(max-min+1) + min;
        return randomNo;
	}

	
	/**
	 * 获取加密后的密码
	 * @author wm
	 * @date 2018-01-25
	 * @param passWord 
	 * @return String
	 */
	public static String encryptionPassWord(String passWord){
		return HmacSign.signToBase64(passWord,"l3dj3grGHKxsh1gDUAAMlA");
	}
	
	/**
	 * 获取固定位数的字符串（大小写字母和数字）
	 * @author wm
	 * @date 2018-01-25
	 * @param digit 位数 
	 * @return String
	 */
    public static String produceString(int digit){
        String words = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String result = "";
        for(int i = 0; i < digit; i++){
            int rand = (int)(Math.random() * words.length());
            result += words.charAt(rand);
        }
        return result;
    }
    /**
	 * 获取UUID
	 * @author wm
	 * @date 2018-02-07
	 * @return String
	 */
    public static String getUUID (){
    	String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
    
    
}
