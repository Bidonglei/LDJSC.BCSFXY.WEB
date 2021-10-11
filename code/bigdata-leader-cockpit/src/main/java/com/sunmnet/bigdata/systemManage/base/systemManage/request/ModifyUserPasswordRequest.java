package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @author Administrator
 *
 */
public class ModifyUserPasswordRequest extends BaseRequest  {
	
	private static final long serialVersionUID = -3169676089117315043L;

	@NotBlank(message = "用户编号不能为空")
	private String userNo;// 用户编号 唯一约束
	@NotBlank(message = "用户旧密码不能为空")
    private String userOldPassword;//用户旧密码
	@NotBlank(message = "用户密码不能为空")
    private String userPassword;//用户密码

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserOldPassword() {
		return userOldPassword;
	}

	public void setUserOldPassword(String userOldPassword) {
		this.userOldPassword = userOldPassword;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

}
