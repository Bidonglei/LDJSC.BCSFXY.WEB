package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryDepartmentDropdownModel;

/**
 * @Description: 部门信息下拉框选择返回参数
 * @author wm
 * @date 2018-03-23
 * @version 1.0
 */
public class QueryDepartmentDropdownResponse extends BaseResponse {

	private static final long serialVersionUID = 175632481942277406L;
	
	private List<QueryDepartmentDropdownModel> list;

	public List<QueryDepartmentDropdownModel> getList() {
		return list;
	}

	public void setList(List<QueryDepartmentDropdownModel> list) {
		this.list = list;
	}
}