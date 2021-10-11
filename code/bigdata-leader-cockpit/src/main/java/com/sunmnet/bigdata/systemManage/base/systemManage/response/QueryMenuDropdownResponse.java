package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryMenuDropdownModel;

/**
 * @Description: 菜单信息下拉框选择返回参数
 * @author zfb
 * @date 2018-04-08
 * @version 1.0
 */
public class QueryMenuDropdownResponse  extends BaseResponse {

	private static final long serialVersionUID = -1874697384122516534L;
	
	private List<QueryMenuDropdownModel> list;

	public List<QueryMenuDropdownModel> getList() {
		return list;
	}

	public void setList(List<QueryMenuDropdownModel> list) {
		this.list = list;
	}
}
