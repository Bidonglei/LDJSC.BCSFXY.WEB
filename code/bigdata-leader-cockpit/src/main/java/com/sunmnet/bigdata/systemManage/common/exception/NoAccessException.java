package com.sunmnet.bigdata.systemManage.common.exception;


/**
 * 用户无权限异常
 * @author wm
 * @create 2018-03-21
 */
public class NoAccessException extends RuntimeException{

	private static final long serialVersionUID = -1454241265898960967L;
	
	public NoAccessException() {
		super();
	}
	
	public NoAccessException(String message) {
        super(message);
    }
	
	public NoAccessException(String message, Throwable cause) {
		super(message, cause);
	}
	
    public NoAccessException(Throwable cause) {
        super(cause);
    }
}
