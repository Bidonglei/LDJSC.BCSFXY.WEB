package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import com.sunmnet.bigdata.systemManage.base.support.request.BasePageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.AdminStatusEnum;

/**
 * @Description: 分页查询管理员信息列表请求参数
 * @author wm
 * @date 2018-04-04
 * @version 1.0
 */
public class QuerySystemAdminInfoPageRequest extends BasePageRequest {
	
	
	private static final long serialVersionUID = -4716648576209558993L;
	
	//管理员编号  唯一约束
    private String adminNo;
    //管理员姓名
    private String adminName;
    //管理员手机号
    private String adminMobile;
    //管理员状态  初始化INIT， 正常 NORMAL,  锁定 LOCK 
    private AdminStatusEnum adminStatus;
    private String startTime;//开始时间  格式：YYYYMMDDHHmmss
    private String endTime;//最后修改时间  格式：YYYYMMDDHHmmss
	
	public String getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminMobile() {
		return adminMobile;
	}
	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}
	public AdminStatusEnum getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(AdminStatusEnum adminStatus) {
		this.adminStatus = adminStatus;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
