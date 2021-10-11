package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

public class SunmnetPageDataSource {
    /**
     * 主键ID
     * 表字段： sunmnet_page_data_source.id
     */
    private Long id;

    /**
     * 页面组件前端使用值
     * 表字段： sunmnet_page_data_source.page_code
     */
    private String pageCode;

    /**
     * 页面组件文字名称
     * 表字段： sunmnet_page_data_source.page_name
     */
    private String pageName;

    /**
     * 数据源相关部门(可多个)
     * 表字段： sunmnet_page_data_source.data_department
     */
    private String dataDepartment;

    /**
     * 统计图名称
     * 表字段： sunmnet_page_data_source.chart_name
     */
    private String chartName;

    /**
     * 数据类型
     * 表字段： sunmnet_page_data_source.data_type
     */
    private String dataType;

    /**
     * 数据同步时间 格式：yyyy-MM-dd
     * 表字段： sunmnet_page_data_source.data_synchronize
     */
    private String dataSynchronize;

    /**
     * 数据状态(有无、不完善、不准确等)
     * 表字段： sunmnet_page_data_source.data_status
     */
    private String dataStatus;

    /**
     * 数据问题
     * 表字段： sunmnet_page_data_source.data_question
     */
    private String dataQuestion;

    /**
     * 排序
     * 表字段： sunmnet_page_data_source.data_sort
     */
    private Integer dataSort;

    /**
     * 判断数据情况(1,全部测试数据,2,真实数据)
     * 表字段： sunmnet_page_data_source.data_judge
     */
    private Integer dataJudge;

    /**
     * 创建时间  格式：yyyy-MM-dd
     * 表字段： sunmnet_page_data_source.create_time
     */
    private String createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode == null ? null : pageCode.trim();
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName == null ? null : pageName.trim();
    }

    public String getDataDepartment() {
        return dataDepartment;
    }

    public void setDataDepartment(String dataDepartment) {
        this.dataDepartment = dataDepartment == null ? null : dataDepartment.trim();
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName == null ? null : chartName.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getDataSynchronize() {
        return dataSynchronize;
    }

    public void setDataSynchronize(String dataSynchronize) {
        this.dataSynchronize = dataSynchronize == null ? null : dataSynchronize.trim();
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus == null ? null : dataStatus.trim();
    }

    public String getDataQuestion() {
        return dataQuestion;
    }

    public void setDataQuestion(String dataQuestion) {
        this.dataQuestion = dataQuestion == null ? null : dataQuestion.trim();
    }

    public Integer getDataSort() {
        return dataSort;
    }

    public void setDataSort(Integer dataSort) {
        this.dataSort = dataSort;
    }

    public Integer getDataJudge() {
        return dataJudge;
    }

    public void setDataJudge(Integer dataJudge) {
        this.dataJudge = dataJudge;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}