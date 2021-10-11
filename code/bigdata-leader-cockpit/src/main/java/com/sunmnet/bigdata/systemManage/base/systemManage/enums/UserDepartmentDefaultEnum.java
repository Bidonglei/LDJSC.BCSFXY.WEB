package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

/**
 * 用户默认部门枚举
 * @author wth
 * @date 2018-03-27
 */
public enum UserDepartmentDefaultEnum {
	// 用户默认部门枚举
	STUDENT("STUDENT","学生部门"),
	OTHER("OTHER","其他部门");

	private String code;
	private String msg;

	
	private UserDepartmentDefaultEnum(String code, String msg) {
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

