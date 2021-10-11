package com.sunmnet.bigdata.systemManage.base.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnnotationUtil {

	  /**
	   *  获取方法上的所有注释
	   *  @author wm 2018-01-23 
	   *  @param  obj  方法所在类
	   *  @param mothodName  方法名
	   */
	  public static List<Object> getMehtodAntitation(Object obj,String mothodName){
	    Method method;
	    List<Object> methodAnnoTationList = new ArrayList<Object>();
	    try {
	      method = ((Class<?>) obj).getMethod(mothodName,String.class);
	      
	      Annotation[] methodAnnotations = method.getAnnotations();
	      
	      for(Annotation me : methodAnnotations){
	        Class<?> annotationType =  me.annotationType();
	        methodAnnoTationList.add(annotationType);
	       // System.out.println(mothodName+"方法上的注释有: " + annotationType);
	      }
	      return methodAnnoTationList;
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		return methodAnnoTationList; 
	  }
	
	  /**
	   *  获取类上的所有注释
	   *  @author wm 2018-01-23 
	   *  @param  obj  所在类
	   */
	  public static List<Object> getClassAntitation(Object obj){
	   
		List<Object> classAnnotationList = new ArrayList<Object>();
	    try {
	    	Annotation[] classAnnotation = ((Class<?>) obj).getAnnotations();
	 	    
	 	    for(Annotation cAnnotation : classAnnotation){
	 	      Class<?> annotationType =  cAnnotation.annotationType();
	 	      classAnnotationList.add(annotationType);
	 	     // System.out.println(((Class<?>) obj).getName()+"类上的注释有: " +annotationType);
	 	    }
	 	    
	      return classAnnotationList;
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		return classAnnotationList; 
	  }
	
	 
	  /**
	   *  获取属性上的所有注释
	   *  @author wm 2018-01-23 
	   *  @param  obj  所在类
	   */
	  public static Map<String,List<Object>> getPropertyAntitation(Object obj){
	   
		Map<String,List<Object>> propertyAnnotionMap = new HashMap<String, List<Object>>();
	    try {

	    	Field[] fields =  ((Class<?>) obj).getDeclaredFields();
		    
		    for(Field f : fields){
		    	
		    	String filedName = f.getName();
			    System.out.println("属性名称:【"+filedName+"】");
			    Annotation[] allAnnotations = f.getAnnotations();
			    List<Object> propertyAnnotions = new ArrayList<Object>();
			    
			    for(Annotation an : allAnnotations){
		          Class<?> annotationType = an.annotationType();
		          propertyAnnotions.add(annotationType);
		         // System.out.println("属性【"+filedName+"】的注释类型有: " + annotationType);
		        }
			    
			    propertyAnnotionMap.put(filedName, propertyAnnotions);
		        //System.out.println("------------------------");
		    }
	 	    
	      return propertyAnnotionMap;
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		return propertyAnnotionMap; 
	  }
	  
	  
	  
	 
	  /**
	   *  判断类属性上有没有此类型的注解,有此注解拿到相关方法的值
	   *  @author wm 2018-01-23 
	   *  @param  obj  注解类
	   *  @param  annotationObj   注解
	   *  @param  method 注解方法
	   */
	  @SuppressWarnings("all")
	  public static Map<String,Object> checkAnnotation(Object obj,Class<? extends Annotation> annotationObj,String method){
		 
		  Map<String,Object>  checkAnnotation = new HashMap<String, Object>();
		  try {
			  Field[] fields =  ((Class<?>) obj).getDeclaredFields();
			    
		      for(Field f : fields){
		          String filedName = f.getName();
		          //1、获取属性上的指定类型的注释
		          Annotation annotation = f.getAnnotation(annotationObj);
		      
		          //有该类型的注释存在
		          if (annotation!=null) {
		        	  Object temp = annotationObj.getDeclaredMethod(method, null).invoke(annotation);
		        	  checkAnnotation.put(filedName, temp);
		        	  //System.out.println("属性名称:【"+filedName+"】"+method+"注解值："+temp);
		          }
		      } 
		  } catch (Exception e) {
			  return checkAnnotation;
		  }
	  
		  return checkAnnotation;
	  }
	  
	  


}
