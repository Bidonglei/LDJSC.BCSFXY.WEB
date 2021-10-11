package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import com.sunmnet.bigdata.systemManage.base.support.request.BasePageRequest;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 *功能描述 分页查询用户登陆历史信息列表
 * @author lkg
 * @date 2019/7/26
 */
public class AccountLoginHistoryPageRequest extends BasePageRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8577891631913846548L;
	
	//账号
	@ApiModelProperty(value="账号")
	@NotNull(message="不能为空")
    private String account;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}
