package com.sunmnet.bigdata.web.model.response.personnel;

import com.sunmnet.bigdata.common.response.BaseResponse;
import com.sunmnet.bigdata.web.model.StaffStructureModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value="QueryStaffStructureResponse")
public class QueryStaffStructureResponse extends BaseResponse{

	private static final long serialVersionUID = -8234734116380760781L;
	@ApiModelProperty(value="编制类别： 编制类型or非编制类型")
	private String name;
	@ApiModelProperty(value="人员数量")
	private String num;

	private List<StaffStructureModel> list;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public List<StaffStructureModel> getList() {
		return list;
	}

	public void setList(List<StaffStructureModel> list) {
		this.list = list;
	}
}
