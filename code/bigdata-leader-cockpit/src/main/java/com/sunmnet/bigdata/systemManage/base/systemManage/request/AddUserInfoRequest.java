package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.RelationTypeEnum;

/**
 * @author Administrator
 *
 */
public class AddUserInfoRequest extends BaseRequest {
	
	private static final long serialVersionUID = -2276989691055558586L;
	@NotBlank(message = "部门编号不能为空")
    private String departmentNo; //系统编号  唯一标识
	@NotBlank(message = "用户姓名不能为空")
    private String userName;//用户姓名
	@NotBlank(message = "手机不能为空")
	private String userMobile;//手机
	@NotBlank(message = "邮箱不能为空")
	private String userMail;//邮箱密码
	@NotNull(message = "关联关系类型不能为空")
	private RelationTypeEnum relationType;//STUDENT 学生 TEACHER 老师  HEADMASTER 校长
	@NotBlank(message = "教工号/学号不能为空")
	private String relationNo;//关联编号  老师和校长的唯一编号
	
	
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
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
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
}
