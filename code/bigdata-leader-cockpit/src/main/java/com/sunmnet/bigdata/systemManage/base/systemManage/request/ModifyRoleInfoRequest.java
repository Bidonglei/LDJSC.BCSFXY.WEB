package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;


/**
 * @Description: 修改角色信息请求参数
 * @author wm
 * @date 2018-04-07
 * @version 1.0
 */
public class ModifyRoleInfoRequest extends BaseRequest {

	private static final long serialVersionUID = -4689334788507753876L;
	
	@NotBlank(message = "角色编号不能为空")
    private String roleNo;//角色编号 唯一标识 
	@NotBlank(message = "角色名称不能为空")
    private String roleName;//角色名称
	@NotBlank(message = "角色描述不能为空")
    private String roleDescribe;//角色描述
	public String getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
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
