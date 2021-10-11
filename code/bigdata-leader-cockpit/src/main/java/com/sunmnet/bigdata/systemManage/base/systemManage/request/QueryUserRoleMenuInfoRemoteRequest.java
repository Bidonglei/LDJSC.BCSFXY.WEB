package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 查询用户用户的权限菜单信息服务间调用请求参数
 * @author wm
 * @date 2018-04-12
 * @version 1.0
 */
public class QueryUserRoleMenuInfoRemoteRequest extends BaseRequest {

	
	private static final long serialVersionUID = -4971752948016105667L;
	
	@NotBlank(message = "用户编号不能为空")
    private String userNo; //用户编号 唯一标识
	@NotBlank(message = "系统编号不能为空")
	private String systemNo;//系统编号

	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getSystemNo() {
		return systemNo;
	}
	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
}
