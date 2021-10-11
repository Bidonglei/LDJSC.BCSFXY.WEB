package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 查询管理员详细信息请求参数
 * @author wm
 * @date 2018-04-04
 * @version 1.0
 */
public class QuerySystemAdminInfoRequest extends BaseRequest {
	
	
	private static final long serialVersionUID = 2957328742208357290L;
	
	@NotBlank(message = "管理员编号不能为空")
    private String adminNo;//管理员编号  唯一约束

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	
	
}
