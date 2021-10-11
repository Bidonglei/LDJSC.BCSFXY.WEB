package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;


/**
 * @Description: 删除角色信息请求参数
 * @author wm
 * @date 2018-04-07
 * @version 1.0
 */
public class DeleteRoleInfoRequest extends BaseRequest {

	
	private static final long serialVersionUID = 261881819542851090L;
	
	@NotBlank(message = "角色编号不能为空")
    private String roleNo;//角色编号 唯一标识 

	public String getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	
}
