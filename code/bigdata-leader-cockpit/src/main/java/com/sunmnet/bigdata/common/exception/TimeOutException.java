package com.sunmnet.bigdata.common.exception;

public class TimeOutException  extends RuntimeException {

	private static final long serialVersionUID = 7291981334863268461L;

	public TimeOutException() {
		super();
	}
	
	public TimeOutException(String message) {
        super(message);
    }
	
	public TimeOutException(String message, Throwable cause) {
		super(message, cause);
	}
	
    public TimeOutException(Throwable cause) {
        super(cause);
    }
}
