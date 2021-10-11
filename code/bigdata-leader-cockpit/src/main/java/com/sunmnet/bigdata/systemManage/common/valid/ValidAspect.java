package com.sunmnet.bigdata.systemManage.common.valid;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;


/**
*@Description: 参数进入Controller前使用JSR-303校验
*@author wm 
*@date 2018-01-23
*/
@Aspect
@Configuration
public class ValidAspect {
	
	@SuppressWarnings("rawtypes")
	@Around("execution(* *(.. , @javax.validation.Valid (*) || @org.springframework.validation.annotation.Validated (*) , ..))")
    public Object toValid(ProceedingJoinPoint joinPoint) throws Throwable{  
		BindingResult result = null;
		Object[] args = joinPoint.getArgs();
		if (args != null && args.length != 0){
			for (Object object : args) {
				if (object instanceof BindingResult){
					result = (BindingResult)object;
					break;
				}
			}
		}
		if (result != null && result.hasErrors()){
			BaseResponseInfo resultInfo = new BaseResponseInfo();
            List<ObjectError> validList = result.getAllErrors();
            for(ObjectError error : validList){
                String errorInfo = error.getDefaultMessage();
                Object[] obj = error.getArguments();
                DefaultMessageSourceResolvable temp = (DefaultMessageSourceResolvable)obj[0];
                String codes = temp.getCode();
                resultInfo.setCode(BaseResultEnum.PARAM_ERROR.getCode());
                resultInfo.setMessage(codes+":"+errorInfo);
                break;
            }
            
            return resultInfo;  
		}
		return joinPoint.proceed();
    }
    
}
