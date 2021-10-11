package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * @Description: 根据用户编号查询角色信息
 * @author zfb
 * @date 2018-04-18
 * @version 1.0
 */
public class QueryUserRoleInfoModel extends BaseModel {

	private static final long serialVersionUID = 6687543421132112391L;
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
