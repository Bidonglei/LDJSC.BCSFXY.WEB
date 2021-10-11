package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import com.sunmnet.bigdata.systemManage.base.support.request.BasePageRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 *功能描述 分页查询用户登陆信息列表
 * @author lkg
 * @date 2019/7/26
 */
public class AccountLoginPageRequest extends BasePageRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8577891631913846548L;
	
	//账号
	@ApiModelProperty(value="账号")
    private String account;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}
