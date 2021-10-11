/**
* RMonograph.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.request.science;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="ProjectDetailPageREQ")
public class ProjectDetailPageREQ extends BasePageRequest {

    @ApiModelProperty(value="项目名称")
    private String projectName;

    @ApiModelProperty(value="学科方向")
    private String subject;

    @ApiModelProperty(value="科研单位")
    private String projectCompany;

    @ApiModelProperty(value="立项时间")
    private String annual;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getProjectCompany() {
		return projectCompany;
	}

	public void setProjectCompany(String projectCompany) {
		this.projectCompany = projectCompany;
	}

	public String getAnnual() {
		return annual;
	}

	public void setAnnual(String annual) {
		this.annual = annual;
	}
}