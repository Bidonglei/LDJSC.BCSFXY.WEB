package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * 服务间调用 指标管理：根据学生八个系的系编号查询对应的专业下拉框
 * @author tkk
 * @create 2018-06-22
 * @return
 */
public class QueryMajorByDepartmentNoModel extends BaseModel{

	private static final long serialVersionUID = -3510755781474425074L;
	private String majorNo;//专业编号
	private String majorName;//专业名称
	public String getMajorNo() {
		return majorNo;
	}
	public void setMajorNo(String majorNo) {
		this.majorNo = majorNo;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
	
}
