package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.NotNull;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SynchroTypeEnum;

/**
 * @Description:生成学院学生登录用户请求参数
 * @author wm
 * @date 2018-06-26
 */
public class GenerationStudentUserRequest extends BaseRequest {
	
	private static final long serialVersionUID = 8299175280238107539L;
	
	//学生所属的系编号
    private String departmentNo;
    //学生所属的专业编号
    private String majorNo;
    //学生所属的班级编号
    private String classNo;
    //学号或姓名
    private String student;
    @NotNull(message = "同步方式不能为空")
	private SynchroTypeEnum synchroType;
    
    //姓名,学号,手机号码,邮箱|姓名,学号,手机号码,邮箱|姓名,学号,手机号码,邮箱
    private String studentInfo;//同步学生信息集合
    
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getMajorNo() {
		return majorNo;
	}
	public void setMajorNo(String majorNo) {
		this.majorNo = majorNo;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public SynchroTypeEnum getSynchroType() {
		return synchroType;
	}
	public void setSynchroType(SynchroTypeEnum synchroType) {
		this.synchroType = synchroType;
	}
	public String getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(String studentInfo) {
		this.studentInfo = studentInfo;
	}
}
