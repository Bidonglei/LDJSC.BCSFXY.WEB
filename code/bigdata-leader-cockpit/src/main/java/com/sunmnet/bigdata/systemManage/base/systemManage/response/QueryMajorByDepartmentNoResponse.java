package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryMajorByDepartmentNoModel;

/**
 * 服务间调用 指标管理：根据学生八个系的系编号查询对应的专业下拉框
 * @author tkk
 * @create 2018-06-22
 * @return
 */
public class QueryMajorByDepartmentNoResponse extends BaseResponse{

	private static final long serialVersionUID = 3603754763424910594L;
	private List<QueryMajorByDepartmentNoModel> list;
	public List<QueryMajorByDepartmentNoModel> getList() {
		return list;
	}
	public void setList(List<QueryMajorByDepartmentNoModel> list) {
		this.list = list;
	}
	
}
