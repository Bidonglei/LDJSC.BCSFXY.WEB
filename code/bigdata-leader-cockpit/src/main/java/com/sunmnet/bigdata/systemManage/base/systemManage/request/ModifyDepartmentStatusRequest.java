package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.DepartmentStatusEnum;


/**
 * @Description: 修改部门状态请求参数
 * @author zfb
 * @date 2018-04-05
 * @version 1.0
 */
public class ModifyDepartmentStatusRequest  extends BaseRequest {

	private static final long serialVersionUID = 7904799519513343800L;
	@NotBlank(message = "部门编号不能为空")
	private String departmentNo;// 部门编号 唯一约束
	
	@NotNull(message = "部门状态不能为空")
    private DepartmentStatusEnum departmentStatus;//部门状态    正常 NORMAL,  锁定 LOCK

	public String getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}

	public DepartmentStatusEnum getDepartmentStatus() {
		return departmentStatus;
	}

	public void setDepartmentStatus(DepartmentStatusEnum departmentStatus) {
		this.departmentStatus = departmentStatus;
	}
	
	

}
