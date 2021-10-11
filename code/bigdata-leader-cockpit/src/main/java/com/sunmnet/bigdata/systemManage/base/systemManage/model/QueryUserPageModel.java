package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.RelationTypeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.UserStatusEnum;

/**
 * @Description: 查询用户信息返回参数model
 * @author zfb
 * @date 2018-04-04
 * @version 1.0
 */
public class QueryUserPageModel extends BaseModel {

	private static final long serialVersionUID = 6806671307264011540L;

	// 用户编号 唯一约束
	private String userNo;
	// 用户名称
	private String userName;
	// 用户昵称
	private String userNickName;
	// 用户手机号
	private String userMobile;
	 //部门编号唯一标识
    private String departmentNo;
    //部门名称
    private String departmentName;
	// 用户邮箱
	private String userMail;
	
	// 用户状态 初始化INIT， 正常 NORMAL, 锁定 LOCK
	private UserStatusEnum userStatus;
	
	private String userStatusStr;
	 //用户和学校教工，学生的关联类型  TEACHER 老师  HEADMASTER 校长
    private RelationTypeEnum  relationType;
    private String  relationTypeStr;
    //关联编号  老师和校长的唯一编号
    private String relationNo;
	// 创建时间 格式：YYYYMMDDHHmmssSSS
	private String createTime;
	// 最后修改时间 格式：YYYYMMDDHHmmssSSS
	private String lastModifyTime;
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}	
	public UserStatusEnum getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserStatusEnum userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserStatusStr() {
		return userStatusStr;
	}
	public void setUserStatusStr(String userStatusStr) {
		this.userStatusStr = userStatusStr;
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
	public RelationTypeEnum getRelationType() {
		return relationType;
	}
	public void setRelationType(RelationTypeEnum relationType) {
		this.relationType = relationType;
	}
	public String getRelationNo() {
		return relationNo;
	}
	public void setRelationNo(String relationNo) {
		this.relationNo = relationNo;
	}
	public String getRelationTypeStr() {
		return relationTypeStr;
	}
	public void setRelationTypeStr(String relationTypeStr) {
		this.relationTypeStr = relationTypeStr;
	}
	
}
