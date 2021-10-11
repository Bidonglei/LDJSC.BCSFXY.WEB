package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;


/**
 * @Description: 查询管理系统菜单列表，管理员有的角色标注请求参数
 * @author wm
 * @date 2018-04-16
 * @version 1.0
 */
public class QueryAdminRoleMenuRequest  extends BaseRequest {

	private static final long serialVersionUID = 4746205279315212306L;
	
	@NotBlank(message = "管理员编号不能为空")
	private String adminNo;// 管理员编号

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	
}
