package com.sunmnet.bigdata.systemManage.util;

import com.sunmnet.bigdata.systemManage.base.support.util.DateUtil;


/**
 * 系统序号生产
 * @author wm
 * @create 2018-01-23 
 */
public class SequenceUtil {

	private static String orderType = "O";// 订单
	private static String userType = "U";// 用户编号
	private static String departmentType = "D";// 部门编号
	private static String adminType = "A";// 管理员编号
	private static String roleType = "R";// 角色编号
	private static String imgType = "I";// 图片编号
	private static String indexType = "ID";// 指标编号前缀

	/**
	 *功能描述 获取指标编号
	 * @author lkg
	 * @date 2019/6/4
	 */
	public static String getIndexNo() {
		return getSequence(indexType);
	}
	
	/**
	 * 获取角色编号
	 * @author wm
	 * @date 2018-04-04
	 * @param type 序号类型
	 * @return String 位数=type位数+（13为时间戳+六位随机数）
	 */
	public static String getRoleNo() {
		return getSequenceTimeStamp(roleType);
	}
	
	/**
	 * 获取部门编号
	 * @author wm
	 * @date 2018-04-04
	 * @param type 序号类型
	 * @return String 位数=type位数+（13为时间戳+六位随机数）
	 */
	public static String getDepartmentNo(){
		return getSequenceTimeStamp(departmentType);
	}
	/**
	 * 获取管理员编号
	 * @author wm
	 * @date 2018-03-28
	 * @param type 序号类型
	 * @return String 位数=type位数+（13为时间戳+六位随机数）
	 */
	public static String getAdminNo(){
		return getSequenceTimeStamp(adminType);
	}
	
	/**
	 * 获取用户编号
	 * @author wm
	 * @date 2018-03-28
	 * @param type 序号类型
	 * @return String 位数=type位数+（13为时间戳+六位随机数）
	 */
	public static String getUserNo(){
		return getSequenceTimeStamp(userType);
	}
	
	/**
	 * 图片编号
	 * @author zfb
	 * @date 2018-01-21
	 * @param type 序号类型
	 * @return String 位数=type位数+（13为时间戳+六位随机数）
	 */
	public static String getImgNo(){
		return getSequenceTimeStamp(imgType);
	}
	
	
	
	/**
	 * 获取订单号
	 * @author wm
	 * @date 2018-01-23
	 * @param type 序号类型
	 * @return String 位数=type位数+23
	 */
	public static String getOrderNumber(){
		return getSequence(orderType);
	}
	
	/**
	 * 获取序号公共方法
	 * @author wm
	 * @date 2018-01-23
	 * @param type 序号类型
	 * @return String 位数=type位数+24
	 */
	private static String getSequence(String type){
		return type+DateUtil.getDateAndTimes()+MethodUtil.getRandomNo(SystemManageConstants.SIX);
	}
	
	/**
	 * 获取序号公共方法时间戳类型
	 * @author wm
	 * @date 2018-01-23
	 * @param type 序号类型
	 * @return String 位数=type位数+（13为时间戳+六位随机数）
	 */
	private static String getSequenceTimeStamp(String type){
		long usetNO = DateUtil.timeStamp13()+MethodUtil.getRandomNo(SystemManageConstants.SIX);
		return type+usetNO;
	}
	
	
	
}
