package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryTeacherDropDownModel;

/**
 * 查询教师职称下拉框
 * @author tkk
 * @create 2018-06-22
 */
public class QueryProfessionalTitleResponse extends BaseResponse {

	private static final long serialVersionUID = 912984202048576359L;
	private List<QueryTeacherDropDownModel> professionalTypeList;
	public List<QueryTeacherDropDownModel> getProfessionalTypeList() {
		return professionalTypeList;
	}
	public void setProfessionalTypeList(
			List<QueryTeacherDropDownModel> professionalTypeList) {
		this.professionalTypeList = professionalTypeList;
	}
	
}
