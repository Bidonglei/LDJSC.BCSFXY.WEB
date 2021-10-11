package com.sunmnet.bigdata.web.model.request.science;

import org.apache.commons.lang3.StringUtils;

import com.sunmnet.bigdata.web.util.CommonUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="ScienceYearREQ")
public class ScienceYearREQ {

    @ApiModelProperty(value="投入年份")
    private String scienceYear;

    public String getScienceYear() {
        if(StringUtils.isBlank(scienceYear)) {
            return CommonUtils.getNowYear();
        }
        return scienceYear;
    }

    public void setScienceYear(String scienceYear) {
        this.scienceYear = scienceYear;
    }
    
}
