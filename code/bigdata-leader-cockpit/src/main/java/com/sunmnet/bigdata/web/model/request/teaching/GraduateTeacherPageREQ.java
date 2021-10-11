/**
* RMonograph.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.request.teaching;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SciencePlatformPageREQ")
public class GraduateTeacherPageREQ extends BasePageRequest {

    @ApiModelProperty(value="学院编号")
    private String academyCode;

    @ApiModelProperty(value="工号或姓名")
    private String noOrName;

    /*@ApiModelProperty(value="排序字段")
    private String sortField;

    @ApiModelProperty(value="排序方式")
    private String sortNumber;*/

	public String getAcademyCode() {
		return academyCode;
	}

	public void setAcademyCode(String academyCode) {
		this.academyCode = academyCode;
	}

	public String getNoOrName() {
		return noOrName;
	}

	public void setNoOrName(String noOrName) {
		this.noOrName = noOrName;
	}

}