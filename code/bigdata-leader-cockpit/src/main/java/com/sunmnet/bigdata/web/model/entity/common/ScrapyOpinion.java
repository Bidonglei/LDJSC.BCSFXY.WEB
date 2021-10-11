/**
* CScrapyOpinion.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="舆情信息表")
public class ScrapyOpinion {
    
    @ApiModelProperty(value="舆情唯一标示")
    private Integer opinionId;
    
    @ApiModelProperty(value="舆情类型(毕业生,科研,教学)")
    private String opinionType;

    @ApiModelProperty(value="题目")
    private String title;

    @ApiModelProperty(value="摘录")
    private String excerpt;

    @ApiModelProperty(value="来源")
    private String source;

    @ApiModelProperty(value="网址")
    private String website;

    @ApiModelProperty(value="发表时间")
    private String publicationTime;

    @ApiModelProperty(value="阅读量")
    private String pageviews;

    @ApiModelProperty(value="详细内容")
    private String detailedContent;

    public Integer getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(Integer opinionId) {
        this.opinionId = opinionId;
    }

    public String getOpinionType() {
        return opinionType;
    }

    public void setOpinionType(String opinionType) {
        this.opinionType = opinionType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(String publicationTime) {
        this.publicationTime = publicationTime;
    }

    public String getPageviews() {
        return pageviews;
    }

    public void setPageviews(String pageviews) {
        this.pageviews = pageviews;
    }

    public String getDetailedContent() {
        return detailedContent;
    }

    public void setDetailedContent(String detailedContent) {
        this.detailedContent = detailedContent;
    }

    
}