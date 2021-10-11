package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * @Description: 查询用户用户的权限菜单信息服务间调用参数model
 * @author wm
 * @date 2018-04-12
 * @version 1.0
 */
public class QueryUserRoleMenuInfoRemoteRequestModel  extends BaseModel {

	private static final long serialVersionUID = -15710157836392026L;
	
	
	private String userNo;
	private String systemNo;

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getSystemNo() {
		return systemNo;
	}

	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
	
	
}
