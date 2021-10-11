package com.sunmnet.bigdata.systemManage.base.support.request;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * @Description: 请求参数实体基类，请求参数实体对象需要继承此对象
 * @author wm
 * @date 2018-01-23
 * @version 1.0
 */
public class BaseRequest implements Serializable{

	
	private static final long serialVersionUID = 967987289258006456L;
	private String token;
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}

