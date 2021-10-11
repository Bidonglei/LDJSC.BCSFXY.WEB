/**
* RMonograph.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.request.science;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ProjectPersonPageREQ")
public class ProjectPersonPageREQ extends BasePageRequest {

    @ApiModelProperty(value="科研人员姓名")
    private String personName;

    @ApiModelProperty(value="研究方向")
    private String researchDirection;

    @ApiModelProperty(value="一级学科")
    private String oneSubject;

    @ApiModelProperty(value="所在单位")
    private String company;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getResearchDirection() {
		return researchDirection;
	}

	public void setResearchDirection(String researchDirection) {
		this.researchDirection = researchDirection;
	}

	public String getOneSubject() {
		return oneSubject;
	}

	public void setOneSubject(String oneSubject) {
		this.oneSubject = oneSubject;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}