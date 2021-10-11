package com.sunmnet.bigdata.systemManage.common.log;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.systemManage.base.support.annotation.AnnotationUtil;
import com.sunmnet.bigdata.systemManage.base.support.annotation.Shield;
import com.sunmnet.bigdata.systemManage.base.support.enums.ShieldEnum;
import com.sunmnet.bigdata.systemManage.base.support.request.BasePageRequest;
import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.support.util.ShieldUtil;

/**
*@Description: 日志管理
*@author wm 
*@date 2018-01-23
*/
@Aspect
@Service
public class LoggerAdvice {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("within(com.sunmnet.bigdata.systemManage.controller..*) && @annotation(loggerManage)")
	public void addBeforeLogger(JoinPoint joinPoint, LoggerManage loggerManage) throws Exception {
		logger.info("执行 " + loggerManage.description() + " 开始");
		logger.info(joinPoint.getSignature().toString());
		logger.info(parseParames(joinPoint.getArgs(),loggerManage.description()));
	}
	
	@AfterReturning(pointcut = "within(com.sunmnet.bigdata.systemManage.controller..*) && @annotation(loggerManage)", returning = "rvt")
	public void addAfterReturningLogger(JoinPoint joinPoint, LoggerManage loggerManage,Object rvt) {
		logger.info("返回报文:" + rvt);
		logger.info("执行 " + loggerManage.description() + " 结束");
	}
	
	@AfterThrowing(pointcut = "within(com.sunmnet.bigdata.systemManage.controller..*) && @annotation(loggerManage)", throwing = "ex")
	public void addAfterThrowingLogger(JoinPoint joinPoint, LoggerManage loggerManage, Exception ex) {
		logger.error("执行 " + loggerManage.description() + " 异常", ex);
	}

	@SuppressWarnings("unchecked")
	private String parseParames(Object[] parames, String type) throws Exception {
		if (null == parames || parames.length <= 0) {
			return "";
		}
		
		StringBuffer param = new StringBuffer("请求报文:[{}] ");
		for (Object obj : parames) {
			
			if(obj == null){
				continue;
			}
			if(!(obj instanceof BaseRequest||obj instanceof BasePageRequest)){
				continue;
			}
			
			Map<String, String> map = new HashMap<String, String>();
			map.putAll((Map<String, String>) objectToMapBean(obj));
			
			Map<String,Object>  mapAnnatation = AnnotationUtil.checkAnnotation(obj.getClass(), Shield.class, "type");
			
			Iterator<Entry<String, Object>> entries = mapAnnatation.entrySet().iterator();  
			  
			while (entries.hasNext()) {  
			  
			    Entry<String, Object> entry = entries.next();  
			  
			    String fileName = entry.getKey();
			    String fileValue = (String) entry.getValue();
			    
			    if(StringUtils.isNotBlank(fileValue)){
			    	
			    	
			    	if(StringUtils.isNotBlank(map.get(fileName))){
						
			    		String tempValue = map.get(fileName);
			    		String newValue ="";
			    		if(fileValue.equals(ShieldEnum.MOBILE.getCode())){
			    			newValue = ShieldUtil.shieldUserMobile(tempValue);
			    		}
			    		if(fileValue.equals(ShieldEnum.USER_NAME.getCode())){
			    			newValue = ShieldUtil.shieldUserRealname(tempValue);
				    	}
			    		if(fileValue.equals(ShieldEnum.IDENTITY_CARD.getCode())){
			    			newValue = ShieldUtil.shieldUserCreditial(tempValue);
				    	}
			    		if(fileValue.equals(ShieldEnum.BANK_CARD_NO.getCode())){
			    			newValue = ShieldUtil.shieldUserBindcard(tempValue);
				    	}
			    		if(fileValue.equals(ShieldEnum.PASSWORD.getCode())){
			    			newValue = "******";
				    	}
			    		map.put(fileName, newValue);
			    	
			    	}
			    	
			    }
			} 
			
			param.append(map.toString()).append("  ");
		}
		return param.toString();
	}
	
	public static Map<String, Object> objectToMap(Object obj) throws Exception {    
        if(obj == null){    
            return null;    
        }   
  
        Map<String, Object> map = new HashMap<String, Object>();    
  
        Field[] declaredFields = obj.getClass().getDeclaredFields();    
        for (Field field : declaredFields) {    
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));  
        }    
  
        return map;  
    }
	
    public static Map<?, ?> objectToMapBean(Object obj) {  
        if(obj == null)  
            return null;   
  
        return new org.apache.commons.beanutils.BeanMap(obj);  
    }    
}
