package com.sunmnet.bigdata.systemManage.common.exception;


/**
 * 用户session失效异常
 * @author wm
 * @create 2018-03-21
 */
public class SessionInvalidException extends RuntimeException{

	
	private static final long serialVersionUID = 7310965231175093715L;

	public SessionInvalidException() {
		super();
	}
	
	public SessionInvalidException(String message) {
        super(message);
    }
	
	public SessionInvalidException(String message, Throwable cause) {
		super(message, cause);
	}
	
    public SessionInvalidException(Throwable cause) {
        super(cause);
    }
}
