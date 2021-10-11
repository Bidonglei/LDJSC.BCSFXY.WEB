/**
* InternationalConference.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.personnel;

import io.swagger.annotations.ApiModelProperty;

public class InternationalConference {
    @ApiModelProperty(value="交流日期")
    private String internationalDate;

    @ApiModelProperty(value="交流地点")
    private String internationalSite;

    @ApiModelProperty(value="交流地点对应英文-前端扎点用")
    private String internationalSiteEnglish;

    @ApiModelProperty(value="会议类型(参加国际会议人次 合作交流 举办国际会议)")
    private String internationalType;

    @ApiModelProperty(value="参会人数")
    private String personNumber;

    public String getInternationalDate() {
        return internationalDate;
    }

    public void setInternationalDate(String internationalDate) {
        this.internationalDate = internationalDate;
    }

    public String getInternationalSite() {
        return internationalSite;
    }

    public void setInternationalSite(String internationalSite) {
        this.internationalSite = internationalSite;
    }

    public String getInternationalType() {
        return internationalType;
    }

    public void setInternationalType(String internationalType) {
        this.internationalType = internationalType;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public String getInternationalSiteEnglish() {
        return internationalSiteEnglish;
    }

    public void setInternationalSiteEnglish(String internationalSiteEnglish) {
        this.internationalSiteEnglish = internationalSiteEnglish;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }
}