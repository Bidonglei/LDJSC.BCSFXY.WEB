package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 设置管理员菜单权限请求参数
 * @author wm
 * @date 2018-04-06
 * @version 1.0
 */
public class SetSystemAdminMenuRoleRequest extends BaseRequest {
	
	private static final long serialVersionUID = -671590492275963138L;
	
	@NotBlank(message = "管理员编号不能为空")
    private String adminNo;//管理员编号  唯一约束
	@NotBlank(message = "菜单编号集合不能为空")
	private String menuNoList;
	
	
	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}

	public String getMenuNoList() {
		return menuNoList;
	}

	public void setMenuNoList(String menuNoList) {
		this.menuNoList = menuNoList;
	}

}
