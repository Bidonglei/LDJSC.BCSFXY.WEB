package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 重置用户密码请求参数
 * @author zfb
 * @date 2018-04-11
 * @version 1.0
 */
public class ResetUserPasswordRequest extends BaseRequest  {

	private static final long serialVersionUID = -6989406175001355384L;
	
	@NotBlank(message = "用户编号不能为空")
	private String userNo;// 用户编号 唯一约束

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

}
