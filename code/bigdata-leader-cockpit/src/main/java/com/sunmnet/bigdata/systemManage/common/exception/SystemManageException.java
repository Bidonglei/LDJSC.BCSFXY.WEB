package com.sunmnet.bigdata.systemManage.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;

@ControllerAdvice
public class SystemManageException extends RuntimeException{
	
	private static final long serialVersionUID = -5415440425944293954L;

	@SuppressWarnings("rawtypes")
	public static BaseResponseInfo exception(){
		return new BaseResponseInfo(BaseResultEnum.SYSTEM_BUSY);
	}
	
	/**
	 * 用户无权限异常
	 * @author wm
	 * @create 2018-03-21
	 */
	@ExceptionHandler(NoAccessException.class)
    public Object handleNoAccessException(Exception ex, HttpServletRequest req, HttpServletResponse res) {
		BaseResponseInfo<Object> baseResponseInfo = new BaseResponseInfo<Object>();
		baseResponseInfo.setBaseResponseInfo(BaseResultEnum.NO_ACCESS);
        return new ResponseEntity<>(baseResponseInfo, HttpStatus.OK);
    }
	/**
	 * 用户session失效异常
	 * @author wm
	 * @create 2018-03-21
	 */
	@ExceptionHandler(SessionInvalidException.class)
    public Object handleSessionInvalidException(Exception ex, HttpServletRequest req, HttpServletResponse res) {
		BaseResponseInfo<Object> baseResponseInfo = new BaseResponseInfo<Object>();
		baseResponseInfo.setBaseResponseInfo(BaseResultEnum.SESSION_INVALID);
        return new ResponseEntity<>(baseResponseInfo, HttpStatus.OK);
    }
	
	
}
