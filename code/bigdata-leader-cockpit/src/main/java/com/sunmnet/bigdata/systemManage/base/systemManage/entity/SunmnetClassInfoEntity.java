package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import com.sunmnet.bigdata.systemManage.base.support.entity.BaseEntity;


/**
 * @ClassName SunmnetClassInfoEntity
 * @Description 班级信息表
 * @author wm
 * @date 2018-04-20 21:32:48
 * @version 1.0 
 */
public class SunmnetClassInfoEntity  extends BaseEntity{

	private static final long serialVersionUID = -6060821818137489045L;
	//主键自增
    private Long id;
    //班级编号
    private String code;
    //班级名称
    private String name;
    //年级
    private String grade;
    //专业编号
    private String majorCode;
    //院系编码
    private String academyCode;
    //书院编号
    private String collegeCode;
    //3年制还是5年制
    private String year;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }
    public String getMajorCode() {
        return majorCode;
    }
    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode == null ? null : majorCode.trim();
    }
    public String getAcademyCode() {
        return academyCode;
    }
    public void setAcademyCode(String academyCode) {
        this.academyCode = academyCode == null ? null : academyCode.trim();
    }
    public String getCollegeCode() {
        return collegeCode;
    }
    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode == null ? null : collegeCode.trim();
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

}