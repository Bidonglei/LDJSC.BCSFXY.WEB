package com.sunmnet.bigdata.web.enums;

/**  
* @ClassName: RadarindicatorEnum  
* @Description: 雷达图轴映射关系
* @author lenovo  
* @date 2018年9月1日    
*/
public enum RadarIndicatorEnum
{
    // 教学资源-课程-课程门数
    RESOURCE_COURSE_NUMBER("课程门数", "course_number", "0"),
    // 教学资源-课程-课程门次数
    RESOURCE_COURSE_FREQUENCY("课程门次数", "course_frequency", "0"),
    // 教学资源-课程-双语课程门数
    RESOURCE_BILINGUAL_COURSE("双语课程门数", "bilingual_course", "0"),
    // 教学资源-课程-平均学时数
    RESOURCE_AVG_SCHOOL_HOUR("平均学时数", "avg_school_hour", "0"),
    // 教学资源-课程-平均班规模
    RESOURCE_AVG_CLASS_SIZE("平均班规模", "avg_class_size", "0"),
    /**
     * 教学经费收入
     */
    // 教学资源-教学经费-经常性预算内教育事业费收入
    INCOME_EDUCATION_FEE_INCOME("经常性预算内教育事业费收入", "education_fee_income", "0"),
    // 教学资源-教学经费-教改专项拨款
    INCOME_SPECIAL_EARMARKS("教改专项拨款", "special_earmarks", "0"),
    // 教学资源-教学经费-学费收入
    INCOME_FEES_INCOME("学费收入", "fees_income", "0"),
    // 教学资源-教学经费-生均拨款总额
    INCOME_AVG_APPROPRIATION_TOTAL("生均拨款总额", "avg_appropriation_total", "0"),
    
    /**
     *  教学经费支出
     */
    // 教学资源-教学经费-教学日常运行支出
    EXPEND_TEACHING_DAILY("教学日常运行支出", "teaching_daily_expend", "0"),
    // 教学资源-教学经费-教师培训进修专项
    EXPEND_TEA_TRAINING("教师培训进修专项", "tea_training_expend", "0"),
    // 教学资源-教学经费-学生活动经费支出
    EXPEND_STU_ACTIVITY("学生活动经费支出", "stu_activity_expend", "0"),
    // 教学资源-教学经费-其他教学专项支出
    EXPEND_OTHER_SPECIAL("其他教学专项支出", "other_special_expend", "0"),
    // 教学资源-教学经费-实践教学支出
    EXPEND_PRACTICAL_TEACHING("实践教学支出", "practical_teaching_expend", "0"),
    // 教学资源-教学经费-专业建设支出
    EXPEND_SPECIAL_CONSTRUCTION("专业建设支出", "special_construction", "0"),
    // 教学资源-教学经费-教学改革支出
    EXPEND_TEACHING_REFORM("教学改革支出", "teaching_reform_expend", "0"),
    
    //科研投入
    INPUT_MONEY("投入科研费用","input_money","0"),
    ACREAGE("科研场地","acreage","0"),
    UTILITIES("科研场地水电暖费用","utilities","0"),
    HUMAN_RESOURCES_COST("人力资源费用","human_resources_cost","0"),
    STUDYING_NUMBER("在读硕士和博士生","studying_number","0"),
    //科研产出
    OFTEN_REFERENCE_THESIS("论文","often_reference_thesis","0"),
    AWARD_NUMBER("获奖","award_number","0"),
    PATENTS_NUMBER("专利及软件著作权","patents_number","0"),
    MONOGRAPH_NUMBER("专著","monograph_number","0"),
    TALENT_TRAINING("年度硕士、博士人才培养","talent_training","0"),
    SCIENCE_PROCEEDS("年度结算科研收益","science_proceeds","0"),
    EQUIPMENT_NUMBER("自主研发新型仪器设备","equipment_number","0"),
    
    //教师管理队伍-年龄分布
    AGE_A("35岁及以下","age1","0"),
    AGE_B("36岁-45岁","age2","0"),
    AGE_C("46岁-55岁","age3","0"),
    AGE_D("56岁及以上","age4","0");
    
    private String name;
    
    private String column;
    
    private String max;
    
    private RadarIndicatorEnum(String name, String column, String max)
    {
        this.name = name;
        this.column = column;
        this.max = max;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getColumn()
    {
        return column;
    }
    
    public void setColumn(String column)
    {
        this.column = column;
    }
    
    public String getMax()
    {
        return max;
    }
    
    public void setMax(String max)
    {
        this.max = max;
    }
    
}
