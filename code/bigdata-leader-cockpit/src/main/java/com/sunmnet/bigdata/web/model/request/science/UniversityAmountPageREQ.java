/**
* RMonograph.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.request.science;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UniversityAmountPageREQ")
public class UniversityAmountPageREQ extends BasePageRequest {

    @ApiModelProperty(value="高校名称")
    private String university;

    @ApiModelProperty(value="项目来源渠道")
    private String type;

    @ApiModelProperty(value="年份")
    private String annual;

    @ApiModelProperty(value="状态")
    private String status;

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnnual() {
		return annual;
	}

	public void setAnnual(String annual) {
		this.annual = annual;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}