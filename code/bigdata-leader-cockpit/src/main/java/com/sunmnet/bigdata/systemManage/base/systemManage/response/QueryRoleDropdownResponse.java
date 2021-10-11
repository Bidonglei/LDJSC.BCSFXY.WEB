package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryRoleDropdownModel;

/**
 * @Description: 角色信息下拉框选择返回参数
 * @author zfb
 * @date 2018-04-11
 * @version 1.0
 */
public class QueryRoleDropdownResponse  extends BaseResponse {
	
	private static final long serialVersionUID = -7795777347354861635L;
	
	private List<QueryRoleDropdownModel> list;

	public List<QueryRoleDropdownModel> getList() {
		return list;
	}

	public void setList(List<QueryRoleDropdownModel> list) {
		this.list = list;
	}

}
