package com.sunmnet.bigdata.web.model.request.common;

import com.sunmnet.bigdata.web.model.request.student.PageREQ;

import io.swagger.annotations.ApiModel;
@ApiModel(value="ScrapyOpinionREQ")
public class ScrapyOpinionREQ extends PageREQ{
    
    //舆情类型(毕业生,科研,教学)
    private String opinionType;

    public String getOpinionType() {
        return opinionType;
    }

    public void setOpinionType(String opinionType) {
        this.opinionType = opinionType;
    }

}
