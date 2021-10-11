package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryDeptModel;

/**
 * 服务间调用 指标管理：查询学校的一级部门下拉框
 * @author tkk
 * @create 2018-06-22
 * @return
 */
public class QueryDeptResponse extends BaseResponse{

	private static final long serialVersionUID = -498751904432720558L;
	private List<QueryDeptModel> list;
	public List<QueryDeptModel> getList() {
		return list;
	}
	public void setList(List<QueryDeptModel> list) {
		this.list = list;
	}
	
}	
