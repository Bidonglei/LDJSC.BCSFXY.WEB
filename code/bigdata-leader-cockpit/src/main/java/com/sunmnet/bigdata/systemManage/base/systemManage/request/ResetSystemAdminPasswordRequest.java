package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 重置管理员秘密请求参数
 * @author wm
 * @date 2018-04-06
 * @version 1.0
 */
public class ResetSystemAdminPasswordRequest extends BaseRequest {
	
	
	
	private static final long serialVersionUID = -4599002892314024150L;
	
	
	@NotBlank(message = "管理员编号不能为空")
    private String adminNo;//管理员编号  唯一约束

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	
	
}
