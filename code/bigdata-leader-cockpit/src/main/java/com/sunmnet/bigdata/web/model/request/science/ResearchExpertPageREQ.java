/**
* RMonograph.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.request.science;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ResearchExpertPageREQ")
public class ResearchExpertPageREQ extends BasePageRequest {

    @ApiModelProperty(value="姓名")
    private String name;

    @ApiModelProperty(value="类别：规划论证专家、指南编制专家、评审专家")
    private String type;

    @ApiModelProperty(value="工作单位")
    private String company;

    @ApiModelProperty(value="专业方向")
    private String majorDirection;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMajorDirection() {
		return majorDirection;
	}

	public void setMajorDirection(String majorDirection) {
		this.majorDirection = majorDirection;
	}
}