package com.sunmnet.bigdata.web.enums;

public enum SearchEnum {

    //搜索框文字对应
    YEAR("年","year"),
    SCHOOL_YEAR("学年","schoolyear"),
    GRADUATE_YEAR("届","graduateYear"),
    ACADEMY("academy",""),
    DEGREE_FOUR("","degreeFour"),
    DEGREE_THREE("","degreeThree"),
    DEGREE_TWO("","degreeTwo"),
    GENDER("","gender"),
    APPOINTMENT_TYPE("教师类别","appointment_type"),
    MAJOR_CATEGORY("专业类别","major_category"),
    TALENT("高端人才","talent"),
    //搜索框取值
    UNDERGRADUATE("本科","01"),
    MASTER("硕士","02"),
    DOCTOR("博士","03"),
    ABROAD("留学生","10"),
    GENDER_A("男","1"),
    GENDER_B("女","2"),
    TEACHER_FULLTIME("专任教师","01"),
    TEACHER_EXTERNAL("外聘教师","02"),
    MAJOR_PROVINCIAL("省部级优势专业","01"),
    MAJOR_NATIONAL_SPECIALTY("国家特色专业","02"),
    MAJOR_NATIONAL_REFORM("国家综合改革试点专业","03"),
    //高端人才搜索框
    TALENT_A("长江学者","长江学者"),
    TALENT_B("院士","院士"),

    //---------------------------------------------------------------------------
    //字典
    //学院部门字典信息
    DEPARTMENT_TYPE_A("学院","academy"),
    DEPARTMENT_TYPE_B("职能部门","functional"),
    DEPARTMENT_TYPE_C("教学及学术支撑单位","support"),
    DEPARTMENT_TYPE_D("科研及产学研单位","institutes"),
    DEPARTMENT_TYPE_E("服务保障单位","guarantee"),
    DEPARTMENT_TYPE_F("部门","department"),
	ACADEMY_NAME("学院名称","academyName"),
    //国际交流下拉框字典
    INTERNATIONAL_BOX_A("国际交流类型","abroadType"),
    INTERNATIONAL_BOX_B("年份选择","recentYear"),
    //人员列表下拉框
    PERSONNEL_A("部门","departmentName"),
    PERSONNEL_B("学历","education"),
    PERSONNEL_C("职称等级","jobTitle"),
    PERSONNEL_D("职务","job"),
    PERSONNEL_E("政治面貌","politicalStatus"),
    PERSONNEL_F("人才称号","topTalentsName"),
	ASSESSMENT_DATE("考核年度","assessmentDate"),
	ASSESSMENT_CONTINUE("连续考核判断","assessmentContinue"),
	EDUCATE_GRADATION("培养层次","educateGradation"),
	PROJECT_TYPE("项目类型","projectType"),
	FOUR_YEAR("项目类型","fourYear"),
    //资产
	MANAGEMENT_STATUS("经营状态","managementStatus"),
	ASSET_TYPE("资产类型","assetType"),
    //新进人员
    TEACHER_TYPE_SMALL("入职类型","teacherTypeSmall"),
    NEWCOMERS("新进人员近几年","newcomers"),
	//科研
	SCIENCE_PROJECT_TYPE("项目类型","scienceProjectType"),
	AMOUNT_LEVEL("金额","amountLevel"),
	SCIENCE_STATUS("科研状态","scienceStatus"),
	THREE_YEAR("近三年","threeYear"),
	SOURCE("纵向项目来源","source"),
	SCIENCE_COMPANY("科研单位","scienceCompany"),
	PROJECT_TIME("立项时间","projectTime"),

	EXPERT_TYPE("专家类别","expertType"),
	TEAM_TYPE("团队类别","teamType"),
	REGION("领域","region"),
	PLATFORM_LEVEL("科研平台级别","platformLevel"),
	SUBJECT("学科","subject"),
	COOPERATION_COUNTRY("合作国别","cooperationCountry"),

	MAJOR_DIRECTION("专业方向","majorDirection"),
	RESEARCH_DIRECTION("研究方向","researchDirection"),
	COOPERATION_CONTINENT("合作洲别","cooperationContinent"),

    //科研-成果绩效-获奖
    KYAWARD_YEAR("国家奖列表年","kyAwardYear"),
    KYAWARD_RANK("获奖等级","kyAwardRank"),
    KYAWARD_TYPE("获奖类型","kyAwardType"),
    KYFIVE_YEAR("五年规划年","kyFiveYear"),

    //财务域
    TRANSACTION_AMOUNT("交易金额","transactionAmount"),

    THESIS_TYPE("论文类型","thesisType"),
    ONE_SUBJECT_TYPE("一级学科类型类型","oneSubjectType"),
	EVALUATE_SEMESTER_YEAR("本科生评教学年","evaluateSemesterYear"),
	STUDENT_YEAR("招生,就业下拉框","studentYear"),
	XS_GRADUATION_YEAR(" 就业分析静态页面下拉框","xsGraduationYear"),
	XS_SCHOLARSHIP_YEAR("奖助学柱图下拉框","xsScholarshipYear"),

//	科研项目分页下拉框
	PROJECT_SECOND_TYPE("项目类型2","projectSecondType"),
	PROJECT_RESEARCH_CATEGORY("项目研究类别","projectResearchCategory"),
	PROJECT_CHANNEL_TYPE("项目研究类别","projectChannelType"),
	PROJECT_DEPARTMENT("项目来源所属部门","projectDepartment"),
	PROJECT_COMPANY_NAME("所属单位","projectCompanyName"),
	STATUS("状态","status"),
	WARN_SEMESTER_YEAR("本科生学业年度","warnSemesterYear"),

    //教学域
    JX_SCHOOL_YEAR("教学域学年","schoolYear"),
    MASTER_COURSE("研究生课程结构","masterCourse"),
    POSTGRADUATE_DEGREE_AWARD("研究生学位授予","postgraduateDegreeAward"),
    THESIS_DEFENSE_QUALITY("研究生论文答辩","thesisDefenseQuality"),

	//高校经费分页 相关下拉框
	UNIVERSITY("高校名称","university"),
	UNIVERSITY_CHANNEL("高校项目来源渠道","universityChannel"),
	UNIVERSITY_ANNUAL("高校项目年份","universityAnnual"),
	UNIVERSITY_STATUS("高校项目状态","universityStatus"),
	//科研项目人员分页 相关下拉框
	PERSON_RESEARCH_DIRECTION("人员研究方向","personResearchDirection"),
	ONE_SUBJECT("一级学科","oneSubject"),
	COMPANY("所在单位","company"),
	//科研仪器共享中心 相关下拉框
	SHARE_CENTER_NAME("共享中心名称","shareCenterName"),
	SHARE_ANNUAL("共享年份","shareAnnual"),
	SHARE_TYPE("共享类型","shareType"),

    ;
    
    private SearchEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
