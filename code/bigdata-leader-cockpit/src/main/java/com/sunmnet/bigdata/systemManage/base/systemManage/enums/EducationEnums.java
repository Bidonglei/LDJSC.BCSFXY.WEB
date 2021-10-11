package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

/**
 * 学历/学历枚举
 * @author wm
 * 2018-06-22
 *
 */
public enum EducationEnums {
    //大专及以下 DZJYX 本科 BK 硕士 SS  博士 BS  博士以上  BSYS
	DZJYX("DZJYX","大专及以下"),
	BK("BK","本科"),
	SS("SS","硕士"),
	BS("BS","博士"),
	BSYS("BSYS","博士以上");
	
	private String code;
    private String message;
	private EducationEnums(String code, String message) {
		this.code = code;
		this.message = message;
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
	
	
}
