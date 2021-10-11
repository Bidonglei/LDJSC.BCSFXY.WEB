package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

/**
 * 菜单级别
 * @author wm
 * @date 2018-04-07
 */
public enum MenuLevelEnum {
	//菜单级别  等级  ONE 主菜单 TWO 子菜单  THREE 级为功能按钮
	ONE("ONE","一级菜单"),
	TWO("TWO","二级菜单"),
	THREE("THREE","三级菜单");

	private String code;
	private String msg;

	
	private MenuLevelEnum(String code, String msg) {
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

