package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QuerySystemDropdownModel;

/**
 * @Description: 查询系统信息下拉框选择返回参数
 * @author wm
 * @date 2018-03-23
 * @version 1.0
 */
public class QuerySystemDropdownResponse extends BaseResponse {

	private static final long serialVersionUID = 175632481942277406L;
	
	private List<QuerySystemDropdownModel> list;

	public List<QuerySystemDropdownModel> getList() {
		return list;
	}

	public void setList(List<QuerySystemDropdownModel> list) {
		this.list = list;
	}
}