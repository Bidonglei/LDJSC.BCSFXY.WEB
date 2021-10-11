package com.sunmnet.bigdata.systemManage.base.support.enums;


public enum BaseResultEnum {
	
	SUCCESS("000000","交易成功"),
	FAIL("999999","交易失败"),
	SYSTEM_BUSY("888888", "系统繁忙，请稍后再试"),
	PARAM_ERROR("777777", "参数错误"),
	CALL_REMOTE_SERVICE_FAILED("666666","服务间调用失败"),
	NO_ACCESS("555555","无此权限"),
	SESSION_INVALID("444444","请重新登录"),
	INIT_PASSWORD("333333","初始化密码，请修改密码后登录"),
	;

	private String code;
    private String message;

    private BaseResultEnum(String code, String message) {
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

