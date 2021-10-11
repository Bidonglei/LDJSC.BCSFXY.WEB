package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;


/**
 * @Description: 添加角色请求参数
 * @author wm
 * @date 2018-04-07
 * @version 1.0
 */
public class AddRoleInfoRequest extends BaseRequest {
	
	private static final long serialVersionUID = -8238691921186131108L;

	@NotBlank(message = "角色名称不能为空")
    private String roleName;//角色名称
    private String roleDescribe;//角色描述
	
    public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescribe() {
		return roleDescribe;
	}
	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}
	
}
