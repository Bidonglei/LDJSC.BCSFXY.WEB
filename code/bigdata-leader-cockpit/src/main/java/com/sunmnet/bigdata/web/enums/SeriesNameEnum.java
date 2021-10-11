package com.sunmnet.bigdata.web.enums;
/**
 * 常量定义
 * <p>Title: SeriesNameEnum</p>
 * @author linjianlin  
 * @date 2018年9月6日
 */
public enum SeriesNameEnum {

    //学生就业
    //x轴横坐标
    YEAR("years"),
    COMPANY_TYPE("companyType"),
    WORKING_AREA("workingArea"),
    //本科教学质量评价-教师质量页面-X轴
    SCHOOLYEAR("schoolYear"),
    
    //其他常量
    EVALUATION_TYPE_A("01"),
    EVALUATION_TYPE_B("02"),
    TYPE_SCORE("typeScore"),
    //舆情三种类别
    OPINIONTYPE_A("01"),
    OPINIONTYPE_B("02"),
    OPINIONTYPE_C("03"),
    
    //研究生扇形三种类别
    ACTIVITIESTYPE_A("01"),
    ACTIVITIESTYPE_B("02"),
    ACTIVITIESTYPE_C("03"),
    //学生树状图获取专业的传参
    ACADEMY_NAME("name"),
    //培养层次默认传参-本科
    EDUCATE_GRADATION("01"),
    //本科生生源分析图默认传参
    STUDY_NAME("01"),
    
    //教学-质量保障-教学管理队伍-纵轴
    MANAGER_TYPE("managerType"),
    //教学-质量保障-教学管理职责
    MANAGEMENT_DUTY_A("本科教学管理职责"),
    MANAGEMENT_DUTY_B("研究生教学管理职责"),
    
    //科研政策传参
    SCHOOL("校内"),
    NATION("国家及省部级"),
    
    //雷达图最大值定义名
    NAME("name"),
    MAX("max")
    ;
    
    private SeriesNameEnum(String name) {
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
