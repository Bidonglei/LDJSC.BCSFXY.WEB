/**
* TAverageFunds.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.teaching;

import io.swagger.annotations.ApiModelProperty;

public class AverageFunds {
    @ApiModelProperty(value="学年")
    private String schoolYear;

    @ApiModelProperty(value="生均本科教学日常运行支出")
    private String undergraduateDailyExpenses;

    @ApiModelProperty(value="生均研究生教学日常运行支出")
    private String postgraduateDailyExpenses;

    @ApiModelProperty(value="生均本科实习经费")
    private String undergraduatePracticeFunds;

    @ApiModelProperty(value="生均研究生实习经费")
    private String postgraduatePracticeFunds;

    @ApiModelProperty(value="生均本科实验经费")
    private String undergraduateExperimentalFunds;

    @ApiModelProperty(value="生均研究生实验经费")
    private String postgraduateExperimentalFunds;

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getUndergraduateDailyExpenses() {
        return undergraduateDailyExpenses;
    }

    public void setUndergraduateDailyExpenses(String undergraduateDailyExpenses) {
        this.undergraduateDailyExpenses = undergraduateDailyExpenses;
    }

    public String getPostgraduateDailyExpenses() {
        return postgraduateDailyExpenses;
    }

    public void setPostgraduateDailyExpenses(String postgraduateDailyExpenses) {
        this.postgraduateDailyExpenses = postgraduateDailyExpenses;
    }

    public String getUndergraduatePracticeFunds() {
        return undergraduatePracticeFunds;
    }

    public void setUndergraduatePracticeFunds(String undergraduatePracticeFunds) {
        this.undergraduatePracticeFunds = undergraduatePracticeFunds;
    }

    public String getPostgraduatePracticeFunds() {
        return postgraduatePracticeFunds;
    }

    public void setPostgraduatePracticeFunds(String postgraduatePracticeFunds) {
        this.postgraduatePracticeFunds = postgraduatePracticeFunds;
    }

    public String getUndergraduateExperimentalFunds() {
        return undergraduateExperimentalFunds;
    }

    public void setUndergraduateExperimentalFunds(String undergraduateExperimentalFunds) {
        this.undergraduateExperimentalFunds = undergraduateExperimentalFunds;
    }

    public String getPostgraduateExperimentalFunds() {
        return postgraduateExperimentalFunds;
    }

    public void setPostgraduateExperimentalFunds(String postgraduateExperimentalFunds) {
        this.postgraduateExperimentalFunds = postgraduateExperimentalFunds;
    }
}