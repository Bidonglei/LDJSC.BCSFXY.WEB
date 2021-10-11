package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryTeacherDropDownModel;

/**
 * 查询教师学历下拉框
 * @author tkk
 * @create 2018-06-22
 */
public class QueryTeacherDegreeResponse extends BaseResponse{

	private static final long serialVersionUID = -9094436545006178406L;
	private List<QueryTeacherDropDownModel> teacherDegreeList;
	public List<QueryTeacherDropDownModel> getTeacherDegreeList() {
		return teacherDegreeList;
	}
	public void setTeacherDegreeList(
			List<QueryTeacherDropDownModel> teacherDegreeList) {
		this.teacherDegreeList = teacherDegreeList;
	}
	
}
