package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.AdminStatusEnum;

/**
 * @Description: 修改管理员状态请求参数
 * @author wm
 * @date 2018-04-04
 * @version 1.0
 */
public class ModifySystemAdminStutasRequest extends BaseRequest {
	
	
	private static final long serialVersionUID = -4716648576209558993L;
	
	@NotBlank(message = "管理员编号不能为空")
    private String adminNo;//管理员编号  唯一约束
	@NotNull(message = "管理员状态不能为空")
    private AdminStatusEnum adminStatus;//管理员状态  初始化INIT， 正常 NORMAL,  锁定 LOCK 
	
	public String getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	public AdminStatusEnum getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(AdminStatusEnum adminStatus) {
		this.adminStatus = adminStatus;
	}
	
	
	
	
}
