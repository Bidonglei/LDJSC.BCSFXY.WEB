package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * @Description: 批量删除用户授权角色model
 * @author 
 * @date 2018-07-11
 * @version 1.0
 */
public class BatchUserRoleModel   extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2230991417273104619L;
	//用户编号
	private String userNo;

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	
    
}
