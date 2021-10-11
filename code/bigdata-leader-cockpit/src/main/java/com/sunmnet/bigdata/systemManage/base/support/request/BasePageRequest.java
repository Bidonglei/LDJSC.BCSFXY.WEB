package com.sunmnet.bigdata.systemManage.base.support.request;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * @Description: 请求参数实体基类，请求参数实体对象需要继承此对象  分页查询使用
 * @author wm
 * @date 2018-03-21
 * @version 1.0
 */
public class BasePageRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private String token;
	@NotNull(message = "当前页不能为空")
	@Min(value=1,message = "当前页必须大于1")
	private int pageNum; //  当前页
	@NotNull(message = "每页显示的记录数量不能为空")
	@Min(value=1,message = "每页显示的记录必须大于1")
	private int pageSize;//  每页显示的记录数量
	private String order;//排序的顺序(asc,desc)
	private String sort;//排序的字段
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	

}

