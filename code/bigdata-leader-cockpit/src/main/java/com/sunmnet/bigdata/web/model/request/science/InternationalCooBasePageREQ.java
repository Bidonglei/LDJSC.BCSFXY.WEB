/**
* RMonograph.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.request.science;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="InternationalCooBasePageREQ")
public class InternationalCooBasePageREQ extends BasePageRequest {

    @ApiModelProperty(value="基地名称")
    private String baseName;

    @ApiModelProperty(value="所属学院")
    private String academyName;

    @ApiModelProperty(value="合作国别")
    private String cooperationCountry;

    @ApiModelProperty(value="合作洲别")
    private String cooperationContinent;


	public String getBaseName() {
		return baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	public String getAcademyName() {
		return academyName;
	}

	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}

	public String getCooperationCountry() {
		return cooperationCountry;
	}

	public void setCooperationCountry(String cooperationCountry) {
		this.cooperationCountry = cooperationCountry;
	}

	public String getCooperationContinent() {
		return cooperationContinent;
	}

	public void setCooperationContinent(String cooperationContinent) {
		this.cooperationContinent = cooperationContinent;
	}
}