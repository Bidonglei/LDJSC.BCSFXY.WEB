package com.sunmnet.bigdata.web.model.response.science;

import com.sunmnet.bigdata.common.response.BaseResponse;

import java.util.List;
import java.util.Map;

/**
 * @Description: 各单位纵向/横向项项目类别统计返回实体
 * @Auther: lkg
 * @Date: 2019/5/8 10:05
 */
public class ProjectTypeResponse extends BaseResponse {

	private String projectCompany;//项目所属科研单位

	private List<Map> list;//项目类别

	public String getProjectCompany() {
		return projectCompany;
	}

	public void setProjectCompany(String projectCompany) {
		this.projectCompany = projectCompany;
	}

	public List<Map> getList() {
		return list;
	}

	public void setList(List<Map> list) {
		this.list = list;
	}
}
