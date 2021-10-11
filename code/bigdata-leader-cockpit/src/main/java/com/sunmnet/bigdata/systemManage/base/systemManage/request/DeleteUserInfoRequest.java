package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 删除用户请求参数
 * @author zfb
 * @date 2018-04-05
 * @version 1.0
 */
public class DeleteUserInfoRequest  extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3417374669051711601L;
	
	@NotBlank(message = "用户编号不能为空")
    private String userNo;//用户编号  唯一标识

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	

}
