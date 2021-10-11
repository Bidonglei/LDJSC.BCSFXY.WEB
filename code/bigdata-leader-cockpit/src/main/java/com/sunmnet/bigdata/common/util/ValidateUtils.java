package com.sunmnet.bigdata.common.util;

import org.springframework.util.StringUtils;


/**
 * 正则验证工具类
 * @author sqj
 *
 */
public final class ValidateUtils {
    private ValidateUtils() {
    }

    /**
	 * 验证是否为合法的手机号码(中国)
	 * @param mobile 手机号码
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		if (!StringUtils.hasText(mobile)) {
			return false;
		}
		return mobile.trim().matches("^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$");
	}
	
	/**
	 * 验证是否为合法的Email
	 * @author sqj
	 * @created 2013-12-10 下午4:09:18
	 *
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		if (!StringUtils.hasText(email)) {
			return false;
		}
		return email.matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?");
	}
	
	/**
	 * 验证是否为合法的用户名
	 * @author sqj
	 * @created 2013-12-10 下午4:09:18
	 *
	 * @param username
	 * @return
	 */
	public static boolean isUsername(String username) {
		if (!StringUtils.hasText(username)) {
			return false;
		}
		return username.matches("^\\w{4,}$");
	}

    /**
	 * 验证是否为合法的URL
	 * @author sqj
	 * @created 2013-12-10 下午4:09:18
	 *
	 * @param url
	 * @return
	 */
	public static boolean isURL(String url) {
		if (!StringUtils.hasText(url)) {
			return false;
		}
		return url.matches("[a-zA-z]+://[^\\s]*");
	}
}