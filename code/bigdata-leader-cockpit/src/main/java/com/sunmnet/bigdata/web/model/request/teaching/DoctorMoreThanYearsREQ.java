/**
* RMonograph.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.request.teaching;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="DoctorMoreThanYearsREQ")
public class DoctorMoreThanYearsREQ extends BasePageRequest {

    @ApiModelProperty(value="学院代码")
    private String academyCode;

    @ApiModelProperty(value="学号或姓名")
    private String studentName;

    @ApiModelProperty(value="教工号或姓名")
    private String teacherName;

	public String getAcademyCode() {
		return academyCode;
	}

	public void setAcademyCode(String academyCode) {
		this.academyCode = academyCode;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
}