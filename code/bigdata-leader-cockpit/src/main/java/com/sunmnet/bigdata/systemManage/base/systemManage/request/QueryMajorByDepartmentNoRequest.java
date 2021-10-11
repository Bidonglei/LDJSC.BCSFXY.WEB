package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * 服务间调用 指标管理：根据学生八个系的系编号查询对应的专业下拉框
 * @author tkk
 * @create 2018-06-22
 * @return
 */
public class QueryMajorByDepartmentNoRequest extends BaseRequest{

	private static final long serialVersionUID = 5055344267481453872L;
	@NotBlank(message = "系编号不能为空")
	private String departmentNo;
	@NotBlank(message = "isPublic为固定值YES,不能为空，用于后台权限验证使用")
	private String isPublic;

	public String getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	
}
