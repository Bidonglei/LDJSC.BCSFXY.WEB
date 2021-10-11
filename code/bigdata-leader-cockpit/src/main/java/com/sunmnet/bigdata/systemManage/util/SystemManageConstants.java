package com.sunmnet.bigdata.systemManage.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 系统常量
 * @author wm
 * @create 2018-01-23 
 */
@Component
public class SystemManageConstants {
	
	/**
	 * 一级菜单编号
	 */
	public static final String FIRST_MENO_NO = "F";// 一级菜单编号
	/**
	 * 二级级菜单编号
	 */
	public static final  String SECOND_MENO_NO = "S";// 二级级菜单编号
	/**
	 * 功能点编号
	 */
	public static  final String THIRD_MENO_NO = "T";// 功能点编号
	
	/**
	 * 数字 3
	 */
	public static final int THREE = 3;
	/**
	 * 数字 6
	 */
	public static final int SIX = 6;
	/**
	 * 字符串   0
	 */
	public static final String ZERO="0";
	/**
	 * 字符串   1
	 */
	public static final String ONE="1";
	/**
	 * 字符串  9
	 */
	public static final String NINE="9";
	/**
	 * 交易成功 000000
	 */
	public static final String SUCCEED = "000000";
	/**
	 * 用户昵称位数
	 */
	public static final int USERNICKNAME_DIGIT = 6;
	/**
	 * 数据库存时间都是YYYYMMDDHHmmssSSS
	 * 接收的是YYYYMMDDHHmmss
	 * 处理成和数据库一样格式要加000
	 */
	public static final String TIME_ADD_ZORE= "000";
	/**
	 * 管理员昵称位数
	 */
	public static final int ADMINNICKNAME_DIGIT = 6;
	/**
	 * 用户初始化密码
	 */
	public static String USER_INIT_PASSWORD;
	/**
	 * 管理员初始化密码
	 */
	public static String ADMIN_INIT_PASSWORD;
	/**
	 * fastDFSAgentUrl
	 */
	public static String FASTDFS_AGENT_URL;
	
	
	/**
	 * 管理系统编号
	 */
	public static String SYSTEM_NO;
	
	@Value("${user.init.password}")
    public void setUserInitPassWord( String userInitPassWord) {
		SystemManageConstants.USER_INIT_PASSWORD = userInitPassWord;
    }
	@Value("${admin.init.password}")
    public void setAdminInitPassWord( String adminInitPassWord) {
		SystemManageConstants.ADMIN_INIT_PASSWORD = adminInitPassWord;
    }
	@Value("${system.no}")
    public void setSystemNo( String systemNo) {
		SystemManageConstants.SYSTEM_NO = systemNo;
    }
//	@Value("${fastdfs.agent.url}")
//    public void setFastDFSAgentUrl( String fastDFSAgentUrl) {
//		SystemManageConstants.FASTDFS_AGENT_URL = fastDFSAgentUrl;
//    }
	
}
