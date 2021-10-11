/**
* TCourseModule.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.teaching;

import io.swagger.annotations.ApiModelProperty;

public class CourseModule {
    @ApiModelProperty(value="学年")
    private String schoolYear;

    @ApiModelProperty(value="学历")
    private String education;

    @ApiModelProperty(value="专业")
    private String majorName;

    @ApiModelProperty(value="课程分类(1.通识通修	2.综合素养	3.学科专业	4.综合实践)")
    private String courseType;

    @ApiModelProperty(value="详细课程")
    private String courseDetail;

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(String courseDetail) {
        this.courseDetail = courseDetail;
    }
}