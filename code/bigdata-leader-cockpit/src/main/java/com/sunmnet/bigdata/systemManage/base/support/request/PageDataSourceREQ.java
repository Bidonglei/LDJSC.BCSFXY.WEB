package com.sunmnet.bigdata.systemManage.base.support.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ScrapyOpinionREQ")
public class PageDataSourceREQ {

    @ApiModelProperty("页面组件前端使用值")
    private String pageCode;

    @ApiModelProperty("页面组件文字名称")
    private String pageName;

    @ApiModelProperty("数据源相关部门(可多个)")
    private String dataDepartment;

    @ApiModelProperty("统计图名称")
    private String chartName;

    @ApiModelProperty("数据类型")
    private String dataType;

    @ApiModelProperty("数据同步时间")
    private String dataSynchronize;

    @ApiModelProperty("数据状态(有无、不完善、不准确等)")
    private String dataStatus;

    @ApiModelProperty("数据问题")
    private String dataQuestion;

    @ApiModelProperty("排序")
    private int dataSort;

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getDataDepartment() {
        return dataDepartment;
    }

    public void setDataDepartment(String dataDepartment) {
        this.dataDepartment = dataDepartment;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataSynchronize() {
        return dataSynchronize;
    }

    public void setDataSynchronize(String dataSynchronize) {
        this.dataSynchronize = dataSynchronize;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getDataQuestion() {
        return dataQuestion;
    }

    public void setDataQuestion(String dataQuestion) {
        this.dataQuestion = dataQuestion;
    }

    public int getDataSort() {
        return dataSort;
    }

    public void setDataSort(int dataSort) {
        this.dataSort = dataSort;
    }
}
