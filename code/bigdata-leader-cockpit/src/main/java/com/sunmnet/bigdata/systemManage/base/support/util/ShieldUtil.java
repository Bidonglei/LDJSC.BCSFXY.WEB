package com.sunmnet.bigdata.systemManage.base.support.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*@Description: 屏蔽工具类
*@author wm 
*@date 2018-01-23
*/
public class ShieldUtil {

	private static Logger logger = LoggerFactory.getLogger(ShieldUtil.class);
	
	private final static String ASTERISK_SIGN = "*";
	private final static String USER_MOBILE_SIGN = "****";
	private final static String USER_CREDITIAL_SIGN = "********";
	private final static String USER_BINDCARD_SIGN = "******";

	public final static String USER_MOBILE_TYPE = "mobile";
	public final static String USER_CREDITIAL_TYPE = "creditial";
	public final static String USER_BINDCARD_TYPE = "bindcard";
	public final static String USER_REALNAME_TYPE = "realname";

	public static String shieldUserInfo(String userInfo, String userType) {
		if (StringUtils.isBlank(userInfo) || StringUtils.isBlank(userType)) {
			return "";
		}
		if (StringUtils.equals(USER_MOBILE_TYPE, userType)) {
			userInfo = shieldUserMobile(userInfo);
		} else if (StringUtils.equals(USER_CREDITIAL_TYPE, userType)) {
			userInfo = shieldUserCreditial(userInfo);
		} else if (StringUtils.equals(USER_BINDCARD_TYPE, userType)) {
			userInfo = shieldUserBindcard(userInfo);
		} else if (StringUtils.equals(USER_REALNAME_TYPE, userType)) {
			userInfo = shieldUserRealname(userInfo);
		}
		return userInfo;
	}

	public static List<Map<String, Object>> shieldUserInfoList (List<Map<String, Object>> dataList, String key, String userType) {
		if (null != dataList && dataList.size() > 0) {
			for (Map<String, Object> data : dataList) {
				String value = (String)data.get(key);
				if (StringUtils.isNotBlank(value)) {
					data.put(key, shieldUserInfo(value, userType));
				}
			}
		}
		return dataList;
	}
	
	/**
	 * 手机号4~7（地区）位用*号代替
	 * @param mobile
	 * @return
	 */
	public static String shieldUserMobile(String mobile) {
		return replace(3, 7, USER_MOBILE_SIGN, mobile);
	}
	
	/**
	 * 身份证号6~14（年月日）位用*号代替
	 * @param creditial
	 * @return
	 */
	public static String shieldUserCreditial(String creditial) {
		if (StringUtils.isBlank(creditial)) {
			return "";
		}
		int creditialLength = creditial.length();
		if (creditialLength >= 18) {
			return replace(6, 14, USER_CREDITIAL_SIGN, creditial);
		} else if (8 < creditial.length() && creditial.length() < 18) {
			return replace(creditialLength - 8, creditialLength, USER_CREDITIAL_SIGN, creditial);
		} else {
			logger.warn("The creditial length is't more than 8, so return creditial.");
			return creditial;
		}
		
	}
	
	/**
	 * 卡后后6位用*号代替
	 * @return
	 */
	public static String shieldUserBindcard(String bindcard) {
		if (StringUtils.isBlank(bindcard)) {
			return "";
		}
		int length = bindcard.length();
		return replace(length - 6, length, USER_BINDCARD_SIGN, bindcard);
	}
	
	/**
	 * 用户名用*号代替
	 * @param realname
	 * @return
	 */
	public static String shieldUserRealname(String realname) {
		if (StringUtils.isBlank(realname)) {
			return "";
		}
		int length = realname.length();
		String sign = ASTERISK_SIGN;
		if (length == 3) {
			sign += ASTERISK_SIGN;
		} else if (length == 4){
			sign += ASTERISK_SIGN + ASTERISK_SIGN;
		}
		return replace(1, length, sign, realname);
	}

	private static String replace(int beginIndex, int endIndex, String sign, String source) {
		try {
			String before = source.substring(0, beginIndex);
			String after = source.substring(endIndex);
			return before + sign + after;
		} catch (Exception e) {
			logger.error("敏感信息替换异常。" + "屏蔽信息 source:" + source + " beginIndex:" + beginIndex + " endIndex：" + endIndex, e);
			return source;
		}
	}
}
