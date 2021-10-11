package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.AdminStatusEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.AdminTypeEnum;

/**
 * @Description:  查询管理员详细信息返回参数
 * @author wm
 * @date 2018-04-04
 * @version 1.0
 */
public class QuerySystemAdminInfoResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7019412562694859763L;
	//管理员编号  唯一约束
    private String adminNo;
    //管理员姓名
    private String adminName;
    // 管理员昵称
    private String adminNickname;
    //管理员手机号
    private String adminMobile;
    //管理员邮箱
    private String adminMail;
    // 管理员类型  SUPERADMIN 超级管理员    ADMIN 管理员
    private AdminTypeEnum adminType;
    private String adminTypeStr;
    //管理员状态  初始化INIT， 正常 NORMAL,  锁定 LOCK 
    private AdminStatusEnum adminStatus;
    private String adminStatusStr;
    //创建时间  格式：YYYYMMDDHHmmssSSS
    private String createTime;
    //最后修改时间  格式：YYYYMMDDHHmmssSSS
    private String lastModifyTime;
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
	public String getAdminNickname() {
		return adminNickname;
	}
	public void setAdminNickname(String adminNickname) {
		this.adminNickname = adminNickname;
	}
	public String getAdminMobile() {
		return adminMobile;
	}
	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}
	public String getAdminMail() {
		return adminMail;
	}
	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}
	public AdminTypeEnum getAdminType() {
		return adminType;
	}
	public void setAdminType(AdminTypeEnum adminType) {
		this.adminType = adminType;
	}
	public String getAdminTypeStr() {
		return adminTypeStr;
	}
	public void setAdminTypeStr(String adminTypeStr) {
		this.adminTypeStr = adminTypeStr;
	}
	public AdminStatusEnum getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(AdminStatusEnum adminStatus) {
		this.adminStatus = adminStatus;
	}
	public String getAdminStatusStr() {
		return adminStatusStr;
	}
	public void setAdminStatusStr(String adminStatusStr) {
		this.adminStatusStr = adminStatusStr;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
}
