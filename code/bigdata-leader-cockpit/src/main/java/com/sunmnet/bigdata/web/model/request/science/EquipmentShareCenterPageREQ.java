/**
* RMonograph.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.request.science;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="EquipmentShareCenterPageREQ")
public class EquipmentShareCenterPageREQ extends BasePageRequest {

    @ApiModelProperty(value="共享中心名称")
    private String shareCenterName;

    @ApiModelProperty(value="年份")
    private String annual;

    @ApiModelProperty(value="共享类型")
    private String type;

	public String getShareCenterName() {
		return shareCenterName;
	}

	public void setShareCenterName(String shareCenterName) {
		this.shareCenterName = shareCenterName;
	}

	public String getAnnual() {
		return annual;
	}

	public void setAnnual(String annual) {
		this.annual = annual;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}