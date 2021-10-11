package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 设置管理员菜单权限请求参数
 * @author wm
 * @date 2018-04-06
 * @version 1.0
 */
public class SetUserRoleRequest extends BaseRequest {
	
	private static final long serialVersionUID = 8437082984954039742L;
	
	@NotBlank(message = "用户编号不能为空")
    private String userNo;//用户编号  唯一约束
	private String roleNoList;
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getRoleNoList() {
		return roleNoList;
	}
	public void setRoleNoList(String roleNoList) {
		this.roleNoList = roleNoList;
	}

}
