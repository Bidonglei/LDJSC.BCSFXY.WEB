package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryRoleMenuInfoModel;

/**
 * @Description:查询角色授权的菜单信息返回参数
 * @author wm
 * @date 2018-04-08
 * @version 1.0
 */
public class QueryRoleMenuInfoResponse extends BaseResponse{

	
	private static final long serialVersionUID = -5403188988077949098L;
	
	private List<QueryRoleMenuInfoModel> list;

	public List<QueryRoleMenuInfoModel> getList() {
		return list;
	}

	public void setList(List<QueryRoleMenuInfoModel> list) {
		this.list = list;
	}
	
	
}
