package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @author Administrator
 *
 */
public class AddDepartmentInfoRequest extends BaseRequest {
	
	private static final long serialVersionUID = -1673628005869606591L;
	@NotBlank(message = "部门名称不能为空")
    private String departmentName; //部门名称	
    private String departmentDescribe; //部门描述
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
