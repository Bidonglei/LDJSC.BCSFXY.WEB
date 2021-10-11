package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.RelationTypeEnum;

/**
 * @Description: 修改用户信息请求参数
 * @author zfb
 * @date 2018-04-09
 * @version 1.0
 */
public class ModifyUserInfoRequest extends BaseRequest {

	private static final long serialVersionUID = -2112969103375810016L;
	
	@NotBlank(message = "用户编号不能为空")
	private String userNo;// 用户编号 唯一约束
	//部门编号
	@NotBlank(message = "部门编号不能为空")
    private String departmentNo;
    //用户姓名
	@NotBlank(message = "用户姓名不能为空")
    private String userName;
	//用户昵称
    private String userNickname;
    //用户手机号   唯一约束
	@NotBlank(message = "手机号码不能为空")
    private String userMobile;
    private String userMail;
	//用户和学校教工，学生的关联类型  TEACHER 老师  HEADMASTER 校长
	@NotNull(message = "关联类型 不能为空")
    private RelationTypeEnum  relationType;
    //关联编号  老师和校长的唯一编号
	@NotBlank(message = "关联编号不能为空")
    private String relationNo;
	
	
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
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
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
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
