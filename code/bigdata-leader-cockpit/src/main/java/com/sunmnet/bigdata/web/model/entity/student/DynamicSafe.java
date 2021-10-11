/**
* SDynamicSafe.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="学生安全信息表")
public class DynamicSafe {
    
    @ApiModelProperty(value="安全信息ID")
    private Integer safeId;
    
    @ApiModelProperty(value="标题")
    private String title;

    @ApiModelProperty(value="内容")
    private String detailedContent;

    @ApiModelProperty(value="发生日期")
    private String happenDate;

    @ApiModelProperty(value="坐标")
    private String coordinate;

    @ApiModelProperty(value="涉及学生")
    private String relevantPersonnel;

    @ApiModelProperty(value="标记")
    private String eventFlag;
    

    public Integer getSafeId() {
        return safeId;
    }

    public void setSafeId(Integer safeId) {
        this.safeId = safeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetailedContent() {
        return detailedContent;
    }

    public void setDetailedContent(String detailedContent) {
        this.detailedContent = detailedContent;
    }

    public String getHappenDate() {
        return happenDate;
    }

    public void setHappenDate(String happenDate) {
        this.happenDate = happenDate;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getRelevantPersonnel() {
        return relevantPersonnel;
    }

    public void setRelevantPersonnel(String relevantPersonnel) {
        this.relevantPersonnel = relevantPersonnel;
    }

    public String getEventFlag() {
        return eventFlag;
    }

    public void setEventFlag(String eventFlag) {
        this.eventFlag = eventFlag;
    }
}