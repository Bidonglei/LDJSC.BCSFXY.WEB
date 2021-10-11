package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

/**
 * 角色是否拥有菜单、功能点授权状态枚举
 * @author wm
 * @date 2018-04-08
 */
public enum RoleMenuStatusEnum {
	//角色是否拥有菜单、功能点授权状态   YES 有 NO没有
	YES("YES","拥有"),
	NO("NO","不拥有");

	private String code;
	private String msg;

	
	private RoleMenuStatusEnum(String code, String msg) {
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

