package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

/**
 * 是否设置预警  YES是 NO否
 * @author wm
 * @date 2019-02-19
 */
public enum IsWarnEnum {
	// 是否设置预警  YES 是 NO 否
	YES("YES", "是"), 
	NO("NO", "否");
	
	private String code;
	private String msg;

	private IsWarnEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

