package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;


/**
 * @Description: 查询角色授权的菜单查询参数model
 * @author wm
 * @date 2018-04-08
 * @version 1.0
 */
public class QueryRoleMenuInfoRequestModel extends BaseModel {

	private static final long serialVersionUID = -320147772600321801L;
	
    private String roleNo; //角色编号 唯一标识
    private String systemNo;
    
	public String getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	public String getSystemNo() {
		return systemNo;
	}
	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
	
}
