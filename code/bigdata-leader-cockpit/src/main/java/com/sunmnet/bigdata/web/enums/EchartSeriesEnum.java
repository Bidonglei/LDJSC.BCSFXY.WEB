package com.sunmnet.bigdata.web.enums;

/**  
* @ClassName: EchartSeriesEnum  
* @Description: 横表转换echarts series枚举
* @author lenovo  
* @date 2018年8月30日    
*/
public enum EchartSeriesEnum
{
    // 教师队伍-生师比
    SERIES_ACADEMY("生师比", "proportion"),
    // 教师授课-教授平均上课率
    SERIES_PRO_CLASS_RATE("教授平均上课率", "pro_class_rate"),
    // 教师授课-副教授平均上课率
    SERIES_ASSOCIATE_PRO_CLASS_RATE("副教授平均上课率", "associate_pro_class_rate"),
    // 教师授课-教授授课门次数
    SERIES_PRO_LECTURE_NUM("教授授课门次数", "pro_lecture_num"),
    // 教师授课-副教授授课门次数
    SERIES_ASSOCIATE_PRO_LECTURE_NUM("副教授授课门次数", "associate_pro_lecture_num"),
    // 教学成果奖省部级
    SERIES_AWARD_PROVINCE("教学成果奖省部级", "level_province"),
    // 教学成果奖国家级
    SERIES_AWARD_COUNTRY("教学成果奖国家级", "level_country"),
    // 教学成果-省部级项目数量
    SERIES_PROJECT_PROVINCE("省部级项目", "number_province"),
    // 教学成果-国家级项目数量
    SERIES_PROJECT_COUNTRY("国家级项目", "number_country"),
    // 教学成果-省部级项目经费
    SERIES_FUNDS_PROVINCE("省部级项目经费", "funds_province"),
    // 教学成果-国家级项目经费
    SERIES_FUNDS_COUNTRY("国家级项目经费", "funds_country"),
    // 教辅人员-专业带头人-本校
    SERIES_IN_SCHOOL("本校", "in_school_num"),
    // 教辅人员-专业带头人-外校境内
    SERIES_OUT_SCHOOL("国内其他高校", "in_school_num"),
    // 教辅人员-专业带头人-外校境外
    SERIES_FOREIGN_SCHOOL("国外其他高校", "foreign_school_num"),
    // 教辅人员-专业带头人-正高级
    SERIES_LEADER_SENIOR("正高级", "senior"),
    // 教辅人员-专业带头人-副高级
    SERIES_LEADER_SUB_SENIOR("副高级", "sub_senior"),
    // 教辅人员-专业带头人-其他
    SERIES_LEADER_OTHER("其他", "other"),
    // 教学资源-课程-学科专业课程
    SERIES_COURSE_XKZYKC("学科专业课程", "xkzykc"),
    // 教学资源-课程-综合实践课程
    SERIES_COURSE_ZHSJKC("综合实践课程", "zhsjkc"),
    // 教学资源-课程-综合素养课程
    SERIES_COURSE_ZHSYKC("综合素养课程", "zhsykc"),
    // 教学资源-课程-通识通修课程
    SERIES_COURSE_TSTXKC("通识通修课程", "tstxkc"),
    // 教学资源-教育经费-学校教育经费总额
    TEACHING_FUNDS_EDUCATION("学校教育经费总额", "education_funds_total"),
    // 教学资源-教育经费-教学经费总额
    TEACHING_FUNDS_TOTAL("教学经费总额", "teaching_funds_total"),
    // 教学资源-教育经费-教学改革与建议专项经费总额
    TEACHING_FUNDS_SPECIAL("教学改革与建议专项经费总额", "special_funds_total"),
    
    // 教学资源-专业-本科学生数
    MAJOR_STUDENT_NUMBER("本科学生数", "student_number"),
    // 教学资源-专业-本学院授课教师数
    MAJOR_INSIDE_NUMBER("本学院授课教师数", "inside_number"),
    // 教学资源-专业-外科院授课教师数
    MAJOR_FOREIGN_NUMBER("外科院授课教师数", "foreign_number"),
    // 教学资源-专业-高级职称授课教师数
    MAJOR_SENIOR_TITLE_NUMBER("高级职称授课教师数", "senior_title_number"),
    
    // 培养过程-第一学年
    CULTURE_PROCESS_ONE("第一学年", "credit1"),
    // 培养过程-第二学年
    CULTURE_PROCESS_TWO("第二学年", "credit2"),
    // 培养过程-第三学年
    CULTURE_PROCESS_THREE("第三学年", "credit3"),
    // 培养过程-第四学年
    CULTURE_PROCESS_FOUR("第四学年", "credit4"),
    //毕业生升学情况折线图
    S_UNDERGRADUATE_PERCENT("本科","uPercent"),
    S_MASTER_PERCENT("硕士","mPercent"),
    //毕业生世界五百强、国有央企及民营企业五百强就业情况
    //毕业生签约单位地域分布
    S_U_NUMBER("本科","uNumber"),
    S_M_NUMBER("硕士","mNumber"),
    S_D_NUMBER("博士","dNumber"),
    //本科教学质量评价-教师质量页面
    T_EXCELLENCE("优秀","excellence"),
    T_GOOD("良好","good"),
    T_ORDINARY("一般","ordinary"),
    T_BAD("较差","bad"),
    T_EVALUATION_COVERAGE("评教覆盖率","evaluationCoverage"),
    //教学-质量保障-教学管理队伍-职称分布
    JOB_TITLE_A("教授","pNumber"),
    JOB_TITLE_B("副教授","aNumber"),
    JOB_TITLE_C("正高级","hNumber"),
    JOB_TITLE_D("副高级","dNumber"),
    JOB_TITLE_E("无职称","nNumber"),
    //教学-质量保障-教学管理队伍-学位分布
    EDUCATION_A("本科","uNumber"),
    EDUCATION_B("硕士","mNumber"),
    EDUCATION_C("博士","dNumber"),
    EDUCATION_D("其他","nNumber"),

    //----------------------------------------------------------------------
    //就业去向
    GRADUATE_TO_A("签约","signing"),
    GRADUATE_TO_B("升学","goSchool"),
    GRADUATE_TO_C("出国（境）","goAbroad"),
    GRADUATE_TO_D("暂缓就业","postponeEmployment"),
    //GRADUATE_TO_C("国家地方项目","nationalProjects"),
    //GRADUATE_TO_D("定向委培","directionalTrain"),
    //GRADUATE_TO_E("灵活就业","flexibleEmploy"),
    //GRADUATE_TO_F("用人单位接收","receiveEmployer"),
    GRADUATE_TO_E("未知","other"),
    GRADUATE_TO_F("就业率","employmentRate"),

    //人事域-新进人员
    NEWCOMERS_A("新进总人数","newcomers"),
    NEWCOMERS_B("具有博士学位人员","doctor"),
    NEWCOMERS_C("海外学缘人员","overseas"),
    NEWCOMERS_D("本校学缘人员","inschool"),

    //教学域
    //教学过程
    //教授授课率
    PROFESSOR_CLASSRATE_A("授课教授人数","teachingProfessor"),
    PROFESSOR_CLASSRATE_B("不授课教授人数","notTeachingProfessor"),
    //PROFESSOR_CLASSRATE_E("上够32学时的教授人数","hour32Professor"),
    PROFESSOR_CLASSRATE_G("教授上课率(%)","professorClassRate"),
    //PROFESSOR_CLASSRATE_I("上够32学时的教授上课率(%)","hour32ProfessorClassRate"),
    PROFESSOR_CLASSRATE_C("授课副教授人数","teachingAssociate"),
    PROFESSOR_CLASSRATE_D("不授课副教授人数","notTeachingAssociate"),
    //PROFESSOR_CLASSRATE_F("上够32学时的副教授人数","hour32Associate"),
    PROFESSOR_CLASSRATE_H("副教授上课率(%)","associateClassRate"),
    //PROFESSOR_CLASSRATE_J("上够32学时的副教授上课率(%)","hour32AssociateClassRate"),
    //论文及答辩质量
    THESIS_DEFENSE_QUALITY_A("论文校盲审通过率(%)","schoolBlindPass"),
    THESIS_DEFENSE_QUALITY_B("论文院盲审通过率(%)","academyBlindPass"),
    THESIS_DEFENSE_QUALITY_C("答辩一次通过率(%)","onePassRatio"),
    THESIS_DEFENSE_QUALITY_D("论文送审优、良比例(%)","excellentRatio"),
    THESIS_DEFENSE_QUALITY_E("论文校盲审不通过率(%)","schoolBlindNotPass"),
    THESIS_DEFENSE_QUALITY_F("论文院盲审不通过率(%)","academyBlindNotPass"),
    THESIS_DEFENSE_QUALITY_G("二次送审比例(%)","secondTrial"),

    //教学成果
    //研究生教改-各学院教改情况
    EDUCATIONAL_PROJECT_A("校级教改项目数量","schoolNumber"),
    EDUCATIONAL_PROJECT_B("校级教改项目经费(万元)","schoolAmount"),
    //教学成果奖-各学院获奖分布
    ACHIEVEMENT_LEVEL_A("国家级一等奖","nationalOne"),
    ACHIEVEMENT_LEVEL_B("国家级二等奖","nationalTwo"),
    ACHIEVEMENT_LEVEL_C("省部级一等奖","provincialOne"),
    ACHIEVEMENT_LEVEL_D("省部级二等奖","provincialTwo"),
    ACHIEVEMENT_LEVEL_E("省部级三等奖","provincialThree"),
    ACHIEVEMENT_LEVEL_F("校级一等奖","socialOne"),
    ACHIEVEMENT_LEVEL_G("校级二等奖","socialTwo"),
    ACHIEVEMENT_LEVEL_H("校级三等奖","socialThree"),
    //研究生创新
    INNOVATION_TYPE_A("创新课程","course"),
    INNOVATION_TYPE_B("创新基地","base"),
    INNOVATION_TYPE_C("创新基金","fund"),
    INNOVATION_TYPE_D("创新竞赛获奖数","competition"),

    ;
    
    private EchartSeriesEnum(String name, String columnName)
    {
        this.name = name;
        this.columnName = columnName;
    }
    
    private String name;
    
    private String columnName;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getColumnName()
    {
        return columnName;
    }
    
    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }
    
}
