package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 修改管理员密码请求参数
 * @author wm
 * @date 2018-04-09
 * @version 1.0
 */
public class ModifySystemAdminPasswordRequest extends BaseRequest {
	
	
	
	private static final long serialVersionUID = -4599002892314024150L;
	
	
	@NotBlank(message = "管理员编号不能为空")
    private String adminNo;//管理员编号  唯一约束
	@NotBlank(message = "原始密码不能为空")
	private String oldAdminPassword;
	@NotBlank(message = "新密码不能为空")
    private String adminPassword;//管理员密码	（密文）
	
	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getOldAdminPassword() {
		return oldAdminPassword;
	}

	public void setOldAdminPassword(String oldAdminPassword) {
		this.oldAdminPassword = oldAdminPassword;
	}
	
}
