package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 新增系统管理员请求参数
 * @author wm
 * @date 2018-04-04
 * @version 1.0
 */
public class AddSystemAdminInfoRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1123060506549691320L;

	@NotBlank(message = "管理员姓名不能为空")
    private String adminName;//管理员姓名
	@Pattern(regexp="^1[0-9]{10}$",message="手机号格式不正确")
	@NotBlank(message = "管理员手机号不能为空")
	private String adminMobile;//管理员手机号
	@NotBlank(message = "管理员邮箱不能为空")
    private String adminMail;//管理员邮箱
	
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
	public String getAdminMail() {
		return adminMail;
	}
	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}
}
