package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

/**
 * 部门状态枚举
 * @author zfb
 * @date 2018-04-05
 */
public enum DepartmentStatusEnum {
	// 部门状态   正常 NORMAL,  锁定 LOCK	
	NORMAL("NORMAL","正常"),
	LOCK("LOCK","锁定");
	
	private String code;
	private String msg;

	
	private DepartmentStatusEnum(String code, String msg) {
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
