package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 角色授权菜单、功能点请求参数
 * @author wm
 * @date 2018-04-08
 * @version 1.0
 */
public class RoleSetMenuFunctionRequest extends BaseRequest {
	
	private static final long serialVersionUID = 7255378981657664132L;
	
	@NotBlank(message = "角色编号不能为空")
    private String roleNo;//角色编号 唯一标识	
    private String menuList;//菜单功能点集合
	public String getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	public String getMenuList() {
		return menuList;
	}
	public void setMenuList(String menuList) {
		this.menuList = menuList;
	}
}
