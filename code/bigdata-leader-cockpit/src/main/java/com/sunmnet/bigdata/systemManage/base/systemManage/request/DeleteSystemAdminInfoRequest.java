package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 删除系统管理员请求参数
 * @author wm
 * @date 2018-04-04
 * @version 1.0
 */
public class DeleteSystemAdminInfoRequest extends BaseRequest {
	
	private static final long serialVersionUID = -6658149316038280851L;
	
	@NotBlank(message = "管理员编号不能为空")
    private String adminNo;//管理员编号  唯一约束

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	
}
