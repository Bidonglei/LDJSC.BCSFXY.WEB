package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

/**
 * 管理员状态枚举
 * @author wm
 * @date 2018-04-04
 */
public enum AdminStatusEnum {
	//管理员状态  初始化INIT， 正常 NORMAL,  锁定 LOCK 
	INIT("INIT","初始化"),
	NORMAL("NORMAL","正常"),
	LOCK("LOCK","锁定");

	private String code;
	private String msg;

	
	private AdminStatusEnum(String code, String msg) {
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

