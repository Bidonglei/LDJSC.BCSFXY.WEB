package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;


/**
 * @Description: 删除部门请求参数
 * @author zfb
 * @date 2018-04-05
 * @version 1.0
 */
public class DeleteDepartmentInfoRequest extends BaseRequest {

	private static final long serialVersionUID = -7737419972623800069L;
	
	@NotBlank(message = "部门编号不能为空")
    private String departmentNo;//部门编号  唯一标识

	public String getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	
	

}
