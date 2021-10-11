package com.sunmnet.bigdata.web.model.request.personnel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ForeignInvestmentREQ")
public class ForeignInvestmentREQ {

    @ApiModelProperty(value="经营状态")
    private String status;

    @ApiModelProperty(value="企业名称/法定代表人")
    private String companyOrLegalRep;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompanyOrLegalRep() {
		return companyOrLegalRep;
	}

	public void setCompanyOrLegalRep(String companyOrLegalRep) {
		this.companyOrLegalRep = companyOrLegalRep;
	}
}
