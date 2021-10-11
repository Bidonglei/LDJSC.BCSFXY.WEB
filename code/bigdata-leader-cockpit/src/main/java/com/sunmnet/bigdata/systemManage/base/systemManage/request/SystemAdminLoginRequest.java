package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 用户登录请求参数
 * @author wm
 * @date 2018-02-07
 * @version 1.0
 */
public class SystemAdminLoginRequest extends BaseRequest {

	private static final long serialVersionUID = 8351649838436920471L;
	@NotBlank(message = "登录名不能为空")
	private String adminMobile;//管理员手机号
	@NotBlank(message = "密码不能为空")
	private String adminPassword;//管理员用户密码
	public String getAdminMobile() {
		return adminMobile;
	}
	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
}
