package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * 查询学生八个系的下拉框
 * @author tkk
 * @create 2018-06-22
 * @return
 */
public class QueryStudentDepartmentModel extends BaseModel{

	private static final long serialVersionUID = -3156785678893224886L;
	private String departmentName;//系部名称
	private String departmentCode;//系部代码
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	
}
