package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 修改管理员信息请求参数
 * @author wm
 * @date 2018-04-09
 * @version 1.0
 */
public class ModifySystemAdminInfoRequest extends BaseRequest {
	
	private static final long serialVersionUID = 1123060506549691320L;
	
	@NotBlank(message = "管理员编号不能为空")
	private String adminNo;//管理员编号
	@NotBlank(message = "管理员姓名不能为空")
    private String adminName;//管理员姓名
	@Pattern(regexp="^1[0-9]{10}$",message="手机号格式不正确")
	@NotBlank(message = "管理员手机号不能为空")
	private String adminMobile;//管理员手机号
	@NotBlank(message = "管理员邮箱不能为空")
    private String adminMail;//管理员邮箱
	@NotBlank(message = "管理员昵称不能为空")
	private String adminNickname;//管理员昵称
	
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
	public String getAdminMail() {
		return adminMail;
	}
	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}
	public String getAdminNickname() {
		return adminNickname;
	}
	public void setAdminNickname(String adminNickname) {
		this.adminNickname = adminNickname;
	}
}
