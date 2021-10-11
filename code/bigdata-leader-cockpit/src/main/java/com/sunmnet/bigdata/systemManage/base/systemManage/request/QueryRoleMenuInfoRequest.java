package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 查询角色授权的菜单请求参数
 * @author wm
 * @date 2018-04-08
 * @version 1.0
 */
public class QueryRoleMenuInfoRequest extends BaseRequest {

	private static final long serialVersionUID = -320147772600321801L;
	
	@NotBlank(message = "角色编号不能为空")
    private String roleNo; //角色编号 唯一标识

	public String getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	
	
}
