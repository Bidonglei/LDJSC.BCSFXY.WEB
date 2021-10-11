package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryStudentDepartmentModel;

/**
 * 查询学生八个系的下拉框
 * @author tkk
 * @create 2018-06-22
 * @return
 */
public class QueryStudentDepartmentResponse extends BaseResponse{

	private static final long serialVersionUID = 2207722783648595897L;
	private List<QueryStudentDepartmentModel> list;
	public List<QueryStudentDepartmentModel> getList() {
		return list;
	}
	public void setList(List<QueryStudentDepartmentModel> list) {
		this.list = list;
	}
	
	
}
