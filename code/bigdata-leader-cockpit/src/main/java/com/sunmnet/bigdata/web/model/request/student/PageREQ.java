package com.sunmnet.bigdata.web.model.request.student;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="PageREQ")
public class PageREQ {

    @ApiModelProperty(value="第几页")
    @NotNull(message="不能为空")
    int pageNum;
    @ApiModelProperty(value="每页几条")
    @NotNull(message="不能为空")
    int pageSize;
    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    
}
