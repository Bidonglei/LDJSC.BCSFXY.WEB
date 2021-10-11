package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;


/**
 * @Description: 查询菜单查询参数model
 * @author zfb
 * @date 2018-04-12
 * @version 1.0
 */
public class QueryMenuInfoRequestModel  extends BaseModel {

	private static final long serialVersionUID = -8545095812873000293L;

	private String systemNo;

	public String getSystemNo() {
		return systemNo;
	}

	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
	
	
}
