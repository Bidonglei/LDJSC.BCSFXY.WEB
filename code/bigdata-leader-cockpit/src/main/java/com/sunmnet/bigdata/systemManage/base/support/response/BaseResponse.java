package com.sunmnet.bigdata.systemManage.base.support.response;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * @Description: 返回参数实体基类，返回参数实体对象需要继承此对象
 * @author wm
 * @date 2018-01-23
 * @version 1.0
 */
public class BaseResponse implements Serializable  {
	
	private static final long serialVersionUID = -9058775243277452302L;

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
