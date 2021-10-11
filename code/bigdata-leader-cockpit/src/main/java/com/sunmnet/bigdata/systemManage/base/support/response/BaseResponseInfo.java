package com.sunmnet.bigdata.systemManage.base.support.response;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;


/**
 * @Description: 统一返回信息实体
 * @author wm
 * @date 2018-01-23
 * @version 1.0
 */
public class BaseResponseInfo<T> implements Serializable  {
	
	private static final long serialVersionUID = -9058775243277452302L;

	private T data;//返回数据
	private String code;//返回码
	private String message;//返回信息
	
	
	public BaseResponseInfo() {
        super();
    }
	
	public BaseResponseInfo(BaseResultEnum baseResultEnum) {
        this.code = baseResultEnum.getCode();
        this.message = baseResultEnum.getMessage();
    }
	
	public void setBaseResponseInfo(BaseResultEnum baseResultEnum) {
        this.code = baseResultEnum.getCode();
        this.message = baseResultEnum.getMessage();
    }
	
	public BaseResponseInfo(BaseResultEnum baseResultEnum,T data) {
        this.code = baseResultEnum.getCode();
        this.message = baseResultEnum.getMessage();
        this.data = data;
    }
	
	public void setBaseResponseInfo(BaseResultEnum baseResultEnum,T data) {
        this.code = baseResultEnum.getCode();
        this.message = baseResultEnum.getMessage();
        this.data = data;
    }
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
