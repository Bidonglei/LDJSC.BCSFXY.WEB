package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * @Description: 部门信息下拉框选择返回参数model
 * @author wm
 * @date 2018-03-23
 * @version 1.0
 */
public class QueryDepartmentDropdownModel extends BaseModel {

	private static final long serialVersionUID = 4470393731127796787L;

	 //部门编号唯一标识
    private String departmentNo;
    //部门名称
    private String departmentName;
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
