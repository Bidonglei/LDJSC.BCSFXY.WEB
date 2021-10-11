package com.sunmnet.bigdata.web.model.response.personnel;

import com.sunmnet.bigdata.common.response.BaseResponse;
import com.sunmnet.bigdata.web.model.StaffStructureModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;


@ApiModel(value="QueryAcademyAndSubjectResponse")
public class QueryAcademyAndSubjectResponse extends BaseResponse{

	private static final long serialVersionUID = -8234734116380760781L;
	@ApiModelProperty(value="学院名称")
	private String academyName;
	@ApiModelProperty(value="人员数量")
	private String num;

	private List<Map> list;

	public String getAcademyName() {
		return academyName;
	}

	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public List<Map> getList() {
		return list;
	}

	public void setList(List<Map> list) {
		this.list = list;
	}
}
