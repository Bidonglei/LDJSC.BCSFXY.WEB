package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * 服务间调用 指标管理：根据一级部门编号查询二级部门信息下拉框
 * @author tkk
 * @create 2018-06-22
 * @return
 */
public class QuerySecondDeptByFirstDeptNoRequest extends BaseRequest{

	private static final long serialVersionUID = 4918683555481280903L;
	@NotBlank(message = "一级部门编号不能为空")
	private String parentsNo;
	@NotBlank(message = "isPublic为固定值YES,不能为空，用于后台权限验证使用")
	private String isPublic;

	public String getParentsNo() {
		return parentsNo;
	}
	public void setParentsNo(String parentsNo) {
		this.parentsNo = parentsNo;
	}
	public String getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	
	
}
