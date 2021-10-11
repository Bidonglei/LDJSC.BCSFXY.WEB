package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

/**
 * @Description: 用户批量授权角色方式
 * @author wm
 * @date 2018-07-11
 */
public enum BatchUserRoleTypeEnum {
	
	CUSTOM("CUSTOM", "自定义"),
	CONDITION("CONDITION", "条件查询");

	private String code;
    private String message;
    
    private BatchUserRoleTypeEnum(String code, String message) {
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
