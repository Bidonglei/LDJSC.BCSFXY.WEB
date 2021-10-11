package com.sunmnet.bigdata.web.model.request.finance;

import com.sunmnet.bigdata.web.util.CommonUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

@ApiModel(value="财务域FinanceREQ")
public class FinanceREQ {

    @ApiModelProperty(value="年份")
    private String year;

    @ApiModelProperty(value="执行项目类型")
    private String projectType;

    public String getYear() {
        if(StringUtils.isBlank(year)) {
            return CommonUtils.getCurrentYear();
        }
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
}
