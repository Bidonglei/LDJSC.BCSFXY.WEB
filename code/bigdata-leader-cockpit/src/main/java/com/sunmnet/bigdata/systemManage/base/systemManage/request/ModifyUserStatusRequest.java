package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.UserStatusEnum;

/**
 * @Description: 修改用户状态请求参数
 * @author zfb
 * @date 2018-04-04
 * @version 1.0
 */
public class ModifyUserStatusRequest extends BaseRequest {

	
	
	private static final long serialVersionUID = -2121820336243235353L;
	
	@NotBlank(message = "用户编号不能为空")
	private String userNo;// 用户编号 唯一约束
	
	@NotNull(message = "用户状态不能为空")
    private UserStatusEnum userStatus;//用户状态   初始化INIT， 正常 NORMAL,  锁定 LOCK 
	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public UserStatusEnum getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatusEnum userStatus) {
		this.userStatus = userStatus;
	}
	
    
}
