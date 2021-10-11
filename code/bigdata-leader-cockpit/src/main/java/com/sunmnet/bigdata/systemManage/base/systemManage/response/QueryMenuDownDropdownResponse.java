package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryMenuDownDropdownModel;

/**
 * @Description: 根据菜单编号查询菜单下级菜单下拉框返回参数
 * @author wm
 * @date 2018-04-12
 * @version 1.0
 */
public class QueryMenuDownDropdownResponse  extends BaseResponse {

	private static final long serialVersionUID = -1874697384122516534L;
	
	private List<QueryMenuDownDropdownModel> list;

	public List<QueryMenuDownDropdownModel> getList() {
		return list;
	}

	public void setList(List<QueryMenuDownDropdownModel> list) {
		this.list = list;
	}
}
