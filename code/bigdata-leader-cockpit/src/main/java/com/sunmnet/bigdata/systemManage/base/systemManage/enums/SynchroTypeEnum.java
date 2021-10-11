package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

/**
 * @Description: 同步方式
 * @author wm
 * @date 2018-06-27
 */
public enum SynchroTypeEnum {
	
	CUSTOM("CUSTOM", "自定义"),
	CONDITION("CONDITION", "条件查询");

	private String code;
    private String message;
    
    private SynchroTypeEnum(String code, String message) {
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
