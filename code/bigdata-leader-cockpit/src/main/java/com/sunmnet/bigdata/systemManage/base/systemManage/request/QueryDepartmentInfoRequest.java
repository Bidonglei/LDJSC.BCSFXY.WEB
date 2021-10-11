package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;


/**
 * @Description: 查看部门详情请求参数
 * @author zfb
 * @date 2018-04-04
 * @version 1.0
 */
public class QueryDepartmentInfoRequest  extends BaseRequest {

	private static final long serialVersionUID = 4746205279315212306L;
	
	@NotBlank(message = "部门编号不能为空")
	private String departmentNo;// 部门编号 唯一约束

	public String getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	
	
}
