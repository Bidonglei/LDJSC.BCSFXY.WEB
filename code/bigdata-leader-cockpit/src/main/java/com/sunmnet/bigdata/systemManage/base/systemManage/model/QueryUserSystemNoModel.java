package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * @Description: 查询用户拥有的系统权限返回参数model
 * @author 
 * @date 2018-07-31
 * @version 1.0
 */
public class QueryUserSystemNoModel  extends BaseModel {
	
	private static final long serialVersionUID = -6699874624198445049L;
	
	//系统编号  唯一标识
    private String systemNo;
    //系统名称
    private String systemName;
    //系统url
    private String systemUrl;
	public String getSystemNo() {
		return systemNo;
	}
	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getSystemUrl() {
		return systemUrl;
	}
	public void setSystemUrl(String systemUrl) {
		this.systemUrl = systemUrl;
	}
    
}
