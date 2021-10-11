package com.sunmnet.bigdata.web.model.request.student;

import org.apache.commons.lang3.StringUtils;

import com.sunmnet.bigdata.web.util.CommonUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SchoolyearREQ")
public class SchoolyearREQ {

    @ApiModelProperty(value="学年")
    private String schoolyear;

    //sql用判断类型
    private String activitiesType;
    
    public String getSchoolyear() {
        if(StringUtils.isBlank(schoolyear)) {
            String year = CommonUtils.getNowYear();
            return year+"-"+(Integer.parseInt(year)+1);
        }
        return schoolyear;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear;
    }

    public String getActivitiesType() {
        return activitiesType;
    }

    public void setActivitiesType(String activitiesType) {
        this.activitiesType = activitiesType;
    }
    
    
}
