package com.sunmnet.bigdata.common.valid;

import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.enums.BaseResultEnum;
import com.sunmnet.bigdata.common.response.BaseResponseInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;


/**
*@Description: 参数进入Controller前使用JSR-303校验
*@author wm
*@date 2018-01-23
*/
@Aspect
@Configuration
public class CommonValidAspect {

	@SuppressWarnings("rawtypes")
	@Around("execution(* com.sunmnet.bigdata.web..*(.. , @javax.validation.Valid (*) || @org.springframework.validation.annotation.Validated (*) , ..))")
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
//			BaseResponseInfo resultInfo = new BaseResponseInfo();
			JsonResult re = new JsonResult();
			StringBuffer msg = new StringBuffer();
			List<ObjectError> validList = result.getAllErrors();
            for(ObjectError error : validList){
                String errorInfo = error.getDefaultMessage();
                Object[] obj = error.getArguments();
                DefaultMessageSourceResolvable temp = (DefaultMessageSourceResolvable)obj[0];
                String codes = temp.getCode();
//                resultInfo.setCode(BaseResultEnum.PARAM_ERROR.getCode());
//                resultInfo.setMessage(codes+":"+errorInfo);

//				re.setMsg(codes+":"+errorInfo);
				msg.append(codes+":"+errorInfo+";");
			}
			re.setSuccess(false);
			re.setErrorCode("-1");
			re.setMsg(msg.toString());
			re.setObj(null);

            return re;
		}
		return joinPoint.proceed();
    }

}
