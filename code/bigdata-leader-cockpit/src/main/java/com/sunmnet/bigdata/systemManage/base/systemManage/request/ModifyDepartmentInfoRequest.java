package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 修改部门信息
 * @author zfb
 * @date 2018-04-09
 * @version 1.0
 */
public class ModifyDepartmentInfoRequest extends BaseRequest {

	private static final long serialVersionUID = -2148349004649690538L;
	@NotBlank(message = "部门编号不能为空")
	private String departmentNo;// 部门编号 唯一约束
	
	@NotBlank(message = "部门名称不能为空")
    private String departmentName;//部门名称
	
    private String departmentDescribe;//部门描述

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

	public String getDepartmentDescribe() {
		return departmentDescribe;
	}

	public void setDepartmentDescribe(String departmentDescribe) {
		this.departmentDescribe = departmentDescribe;
	}
	

}
