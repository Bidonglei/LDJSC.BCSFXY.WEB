package com.sunmnet.bigdata.common.bean;

import org.apache.commons.lang3.StringUtils;

import io.swagger.annotations.ApiModelProperty;

public class JsonResult {

	@ApiModelProperty(value="返回是否成功")
	private Boolean success = Boolean.valueOf(true);

	@ApiModelProperty(value="返回信息")
	private String msg = "";

	@ApiModelProperty(value="返回其他对象信息")
	private Object obj = null;

	@ApiModelProperty(value="返回错误代码")
	private String errorCode = null;

	public JsonResult() {
		this.success = Boolean.valueOf(true);
	}

	public JsonResult(Boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public JsonResult(Boolean success) {
		this.success = success;
	}

	public Boolean getSuccess() {
		return this.success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return this.obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
		if ((obj == null) && (StringUtils.isEmpty(this.msg))) {
			this.success = Boolean.valueOf(false);
			this.msg = "查询/执行 -> 失败/无数据";
		} else if (((obj instanceof String)) && (StringUtils.isEmpty(String.valueOf(obj)))) {
			this.success = Boolean.valueOf(false);
			this.msg = "查询/执行 -> 失败/无数据";
		}
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String toString() {
		return "JsonResult{success=" + this.success + ", msg='" + this.msg + '\'' + ", obj=" + this.obj + ", errorCode="
				+ this.errorCode + '}';
	}
}