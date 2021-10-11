package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * 服务间调用 指标管理：根据学生专业编号查询对应的班级下拉框
 * @author tkk
 * @create 2018-06-22
 * @return
 */
public class QueryClassByMajorNoRequest extends BaseRequest{

	private static final long serialVersionUID = 1244082970695221676L;
	@NotBlank(message = "专业编号不能为空")
	private String majorCode;
	@NotBlank(message = "isPublic为固定值YES,不能为空，用于后台权限验证使用")
	private String isPublic;

	public String getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	public String getMajorCode() {
		return majorCode;
	}
	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}
	
	
}
