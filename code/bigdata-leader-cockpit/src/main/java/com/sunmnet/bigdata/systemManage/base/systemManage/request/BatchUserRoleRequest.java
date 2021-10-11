package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.NotNull;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.BatchUserRoleTypeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.RelationTypeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.UserStatusEnum;

/**
 * @Description:用户批量授权角色请求参数
 * @author wm
 * @date 2018-07-11
 */
public class BatchUserRoleRequest extends BaseRequest {
	
	private static final long serialVersionUID = -5021226161998516942L;
	
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
    //起始时间  格式：YYYYMMDDHHmmss    
    private String beginTime;
    //结束 格式：YYYYMMDDHHmmss    
    private String endTime;
	@NotNull(message = "批量类型不能为空")
	private BatchUserRoleTypeEnum batchUserRoleType;
	//角色编号集合,用英文逗号隔开
	private String roleNoList;
	//批量用户编号集合，用英文逗号隔开
	private String userNoList;
	
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
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
	public UserStatusEnum getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserStatusEnum userStatus) {
		this.userStatus = userStatus;
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
	public BatchUserRoleTypeEnum getBatchUserRoleType() {
		return batchUserRoleType;
	}
	public void setBatchUserRoleType(BatchUserRoleTypeEnum batchUserRoleType) {
		this.batchUserRoleType = batchUserRoleType;
	}
	public String getRoleNoList() {
		return roleNoList;
	}
	public void setRoleNoList(String roleNoList) {
		this.roleNoList = roleNoList;
	}
	public String getUserNoList() {
		return userNoList;
	}
	public void setUserNoList(String userNoList) {
		this.userNoList = userNoList;
	}
}
