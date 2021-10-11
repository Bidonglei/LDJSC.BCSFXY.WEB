/**
* RMonograph.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.request.science;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SciencePlatformPageREQ")
public class SciencePlatformPageREQ extends BasePageRequest {

    @ApiModelProperty(value="平台名称")
    private String platformName;

    @ApiModelProperty(value="级别：国家级，省级")
    private String level;

    @ApiModelProperty(value="学科")
    private String subject;

    @ApiModelProperty(value="依托单位")
    private String dependCompany;

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDependCompany() {
		return dependCompany;
	}

	public void setDependCompany(String dependCompany) {
		this.dependCompany = dependCompany;
	}
}