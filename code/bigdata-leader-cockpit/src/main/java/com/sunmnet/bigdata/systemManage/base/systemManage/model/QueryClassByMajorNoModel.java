package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * 服务间调用 指标管理：根据学生专业编号查询对应的班级下拉框
 * @author tkk
 * @create 2018-06-22
 * @return
 */
public class QueryClassByMajorNoModel extends BaseModel{
	private static final long serialVersionUID = -8560658837174016957L;
	private String classNo;//班级编号
	private String className;//班级名称
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
