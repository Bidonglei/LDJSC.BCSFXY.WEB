package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;


public class QueryRoleDropdownModel  extends BaseModel {

	private static final long serialVersionUID = -3183977952786070102L;
	//角色编号 唯一标识
    private String roleNo;
    //角色名称
    private String roleName;
	public String getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
    
}
