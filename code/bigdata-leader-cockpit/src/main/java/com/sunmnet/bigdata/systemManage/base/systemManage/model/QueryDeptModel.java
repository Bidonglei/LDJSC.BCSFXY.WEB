package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * 服务间调用 指标管理：查询学校的一级部门下拉框
 * @author tkk
 * @create 2018-06-22
 * @return
 */
public class QueryDeptModel extends BaseModel{

	private static final long serialVersionUID = 2833872812625391113L;
	
	private String deptCode;//部门编号
	private String deptName;//部门名称
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
}
