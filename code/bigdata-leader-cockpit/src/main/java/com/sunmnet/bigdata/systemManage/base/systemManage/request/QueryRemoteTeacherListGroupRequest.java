package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.EducationEnums;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.ProfessionalTitleEnum;

public class QueryRemoteTeacherListGroupRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5945280146801941011L;
	//教工号或姓名
    private String teacher;
    //一级部门编号
    private String firstDeptCode;
    //二级部门编号
    private String secondDeptCode;
    
    //职称类型
    private ProfessionalTitleEnum professionalTitle;
    //学历类型
    private EducationEnums education;
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getFirstDeptCode() {
		return firstDeptCode;
	}
	public void setFirstDeptCode(String firstDeptCode) {
		this.firstDeptCode = firstDeptCode;
	}
	public String getSecondDeptCode() {
		return secondDeptCode;
	}
	public void setSecondDeptCode(String secondDeptCode) {
		this.secondDeptCode = secondDeptCode;
	}
	public ProfessionalTitleEnum getProfessionalTitle() {
		return professionalTitle;
	}
	public void setProfessionalTitle(ProfessionalTitleEnum professionalTitle) {
		this.professionalTitle = professionalTitle;
	}
	public EducationEnums getEducation() {
		return education;
	}
	public void setEducation(EducationEnums education) {
		this.education = education;
	}
	
	
    
    
}
