package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;
/**
 * @Description: 查询系统信息下拉框选择返回参数model
 * @author wm
 * @date 2018-03-23
 * @version 1.0
 */
public class QuerySystemDropdownModel extends BaseModel {

	private static final long serialVersionUID = 4470393731127796787L;

	//系统编号  唯一标识
    private String systemNo;
    //系统名称
    private String systemName;
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
	
	
	
}
