package com.sunmnet.bigdata.web.model.request.personnel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description AssessInfoREQ
 * @author linjl
 * @date 2019/2/19
 */
@ApiModel(value="AssessInfoREQ")
public class AssessInfoREQ {

    @ApiModelProperty(value="近几年,数字几")
    private Integer yearNum;
    @ApiModelProperty(value="考核类别(优秀,称职,基本称职,不称职)")
    private String type ;

    public Integer getYearNum() {
        return yearNum;
    }

    public void setYearNum(Integer yearNum) {
        this.yearNum = yearNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
