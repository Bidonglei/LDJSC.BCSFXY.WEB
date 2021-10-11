package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

/**
 * @Description: 用户分类
 * @author wm
 * @date 2018-04-27
 */
public enum RelationTypeEnum {
	
	TEACHER("TEACHER", "老师"),
	HEADMASTER("HEADMASTER", "校长"),
	STUDENT("STUDENT", "学生"),
	;

	private String code;
    private String message;
    
    private RelationTypeEnum(String code, String message) {
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
