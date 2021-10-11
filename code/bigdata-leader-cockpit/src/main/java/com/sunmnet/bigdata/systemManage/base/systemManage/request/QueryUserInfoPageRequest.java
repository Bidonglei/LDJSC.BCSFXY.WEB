package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import com.sunmnet.bigdata.systemManage.base.support.request.BasePageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.RelationTypeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.UserStatusEnum;

/**
 * @Description: 查询用户信息分页请求参数
 * @author wth
 * @date 2018-03-27
 * @version 1.0
 */
public class QueryUserInfoPageRequest extends BasePageRequest{

	private static final long serialVersionUID = 1L;

	//部门编号唯一标识
    private String departmentNo;    
    //用户姓名
    private String userName;
    //用户手机号   唯一约束
    private String userMobile;  
    //用户状态    正常 NORMAL,  锁定 LOCK
    private UserStatusEnum userStatus;
    //用户和学校教工，学生的关联类型  TEACHER 老师  HEADMASTER 校长
    private RelationTypeEnum  relationType;
    //关联编号  老师和校长的唯一编号
    private String relationNo;
    //用户编号
    private String userNo;
    //起始时间  格式：YYYYMMDDHHmmss    
    private String beginTime;
    //结束 格式：YYYYMMDDHHmmss    
    private String endTime;
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public UserStatusEnum getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserStatusEnum userStatus) {
		this.userStatus = userStatus;
	}	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
}
