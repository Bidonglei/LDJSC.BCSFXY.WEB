package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

/**
 * 教师管理类型枚举
 * @author tkk
 * 2018-05-25
 *
 */
public enum ManagerTypeEnums {

	LEADER("LEADER","领导班子"),
	DIVISIONCHIEFS("DIVISIONCHIEFS","处职干部"),
	SECTIONCHIEFS("SECTIONCHIEFS","科职干部"),
	OTHERMANAGERS("OTHERMANAGERS","其他管理人员");
	
	private String code;
    private String message;
	private ManagerTypeEnums(String code, String message) {
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
