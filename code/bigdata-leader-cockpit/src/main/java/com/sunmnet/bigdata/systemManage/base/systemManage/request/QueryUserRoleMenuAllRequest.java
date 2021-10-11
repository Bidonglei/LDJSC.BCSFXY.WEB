package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 查询用户权限菜单编号请求参数
 * @author wm
 * @date 2018-05-27
 * @version 1.0
 */
public class QueryUserRoleMenuAllRequest extends BaseRequest {

	
	private static final long serialVersionUID = -3581323068256217573L;
	
	@NotBlank(message = "用户编号不能为空")
    private String userNo; //用户编号 唯一标识

	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
}
