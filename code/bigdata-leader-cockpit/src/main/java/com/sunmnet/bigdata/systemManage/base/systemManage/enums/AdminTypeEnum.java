package com.sunmnet.bigdata.systemManage.base.systemManage.enums;
/**
 * 管理员类型 枚举
 * @author wm
 * @date 2018-04-04
 */
public enum AdminTypeEnum {
	// 管理员类型  SUPERADMIN 超级管理员    ADMIN 管理员
	SUPERADMIN("SUPERADMIN","超级管理员"),
	ADMIN("ADMIN","管理员");

	private String code;
	private String msg;

	
	private AdminTypeEnum(String code, String msg) {
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

