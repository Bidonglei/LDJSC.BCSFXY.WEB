package com.sunmnet.bigdata.common.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Description: 
 * @author Leo Wu
 * @date 2016年10月27日  下午4:07:28
 * @version 1.0
 */
public class BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
