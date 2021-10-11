package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryClassByMajorNoModel;

/**
 * 服务间调用 指标管理：根据学生专业编号查询对应的班级下拉框
 * @author tkk
 * @create 2018-06-22
 * @return
 */
public class QueryClassByMajorNoResponse extends BaseResponse{

	private static final long serialVersionUID = 2463103716217611319L;
	private List<QueryClassByMajorNoModel> list;
	public List<QueryClassByMajorNoModel> getList() {
		return list;
	}
	public void setList(List<QueryClassByMajorNoModel> list) {
		this.list = list;
	}
	
}
