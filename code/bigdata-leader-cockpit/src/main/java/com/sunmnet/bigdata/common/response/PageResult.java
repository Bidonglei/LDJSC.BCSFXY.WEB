package com.sunmnet.bigdata.common.response;


import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 封装分页结果集
 * 
 */
public class PageResult implements Serializable{
	
	private static final long serialVersionUID = -4087907067478468052L;
	private Integer pageNum;// 要查找第几页
	private Integer pageSize;// 每页显示多少条
	private Long totalPage = 0L;// 总页数
	private Long totalRows;// 总记录数
	
	private List<?> rows;// 结果集

    public PageResult() {}

    public PageResult(List<?> queryData, Long queryTotal, int pageNum, int pageSize) {
        this.rows = queryData;
        this.totalRows = queryTotal;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.getTotalPage();
    }
	

	public Long getTotalPage() {
		if (this.getPageSize() != null) {
			if(this.getPageSize()==0){
				return 0L;
			}
			return (this.getTotalRows() + this.getPageSize() - 1) / this.getPageSize();// 总页数的算法
		} else {
			return totalPage;
		}
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Long totalRows) {
		this.totalRows = totalRows;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
