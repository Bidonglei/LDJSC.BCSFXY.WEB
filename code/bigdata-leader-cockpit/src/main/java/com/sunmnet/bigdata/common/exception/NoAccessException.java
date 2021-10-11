package com.sunmnet.bigdata.common.exception;

public class NoAccessException extends RuntimeException {

	private static final long serialVersionUID = -5942155619194171496L;

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