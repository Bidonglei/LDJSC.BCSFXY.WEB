/**
* RMonograph.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.request.science;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ScienceProjectInfoPageREQ")
public class ScienceProjectInfoPageREQ extends BasePageRequest {

    @ApiModelProperty(value="项目类型")
    private String projectType;
    @ApiModelProperty(value="项目二级类型")
    private String projectSecondType;
    @ApiModelProperty(value="项目研究类别")
    private String researchCategory;
    @ApiModelProperty(value="项目来源渠道")
    private String channelTypeName;
    @ApiModelProperty(value="项目部门")
    private String projectDepartment;
    @ApiModelProperty(value="学科方向")
    private String subject;
    @ApiModelProperty(value="项目负责人")
    private String personCharge;
    @ApiModelProperty(value="所属单位")
    private String projectCompany;
    @ApiModelProperty(value="状态")
    private String status;

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getProjectSecondType() {
		return projectSecondType;
	}

	public void setProjectSecondType(String projectSecondType) {
		this.projectSecondType = projectSecondType;
	}

	public String getResearchCategory() {
		return researchCategory;
	}

	public void setResearchCategory(String researchCategory) {
		this.researchCategory = researchCategory;
	}

	public String getChannelTypeName() {
		return channelTypeName;
	}

	public void setChannelTypeName(String channelTypeName) {
		this.channelTypeName = channelTypeName;
	}

	public String getProjectDepartment() {
		return projectDepartment;
	}

	public void setProjectDepartment(String projectDepartment) {
		this.projectDepartment = projectDepartment;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPersonCharge() {
		return personCharge;
	}

	public void setPersonCharge(String personCharge) {
		this.personCharge = personCharge;
	}

	public String getProjectCompany() {
		return projectCompany;
	}

	public void setProjectCompany(String projectCompany) {
		this.projectCompany = projectCompany;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}