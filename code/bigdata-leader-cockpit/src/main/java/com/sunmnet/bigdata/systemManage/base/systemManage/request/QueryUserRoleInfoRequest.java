package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * 根据用户编号查询角色信息 
 * @author zfb
 * @create 2018-04-18
 * @return
 */
public class QueryUserRoleInfoRequest  extends BaseRequest {

	private static final long serialVersionUID = 6784586778495790251L;
	
	@NotBlank(message = "用户编号不能为空")
	private String userNo;// 用户编号 唯一约束

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	

}
