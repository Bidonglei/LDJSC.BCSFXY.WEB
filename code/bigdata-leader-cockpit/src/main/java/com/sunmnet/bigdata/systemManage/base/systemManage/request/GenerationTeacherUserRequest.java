package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.NotNull;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.EducationEnums;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.ProfessionalTitleEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.RelationTypeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SynchroTypeEnum;

/**
 * @Description:生成学院教职工登录用户请求参数
 * @author wm
 * @date 2018-06-26
 */
public class GenerationTeacherUserRequest extends BaseRequest {
	
	private static final long serialVersionUID = 8299175280238107539L;
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
    @NotNull(message = "同步方式不能为空")
	private SynchroTypeEnum synchroType;
    @NotNull(message = "关联类型不能为空")
    private RelationTypeEnum relationType;
    
    //姓名,职工号,手机号码,邮箱,二级部门编号|姓名,职工号,手机号码,邮箱,二级部门编号|姓名,职工号,手机号码,邮箱,二级部门编号
    private String teacherInfo;
    
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
	public SynchroTypeEnum getSynchroType() {
		return synchroType;
	}
	public void setSynchroType(SynchroTypeEnum synchroType) {
		this.synchroType = synchroType;
	}
	public RelationTypeEnum getRelationType() {
		return relationType;
	}
	public void setRelationType(RelationTypeEnum relationType) {
		this.relationType = relationType;
	}
	public String getTeacherInfo() {
		return teacherInfo;
	}
	public void setTeacherInfo(String teacherInfo) {
		this.teacherInfo = teacherInfo;
	}
	
}
