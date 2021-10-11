package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import com.sunmnet.bigdata.systemManage.base.support.request.BasePageRequest;
/**
 * @author fr
 *
 */
public class QueryRemoteStudentListRequest extends BasePageRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1075736291399526321L;
	
	//学生所属的系编号
    private String departmentNo;
    //学生所属的专业编号
    private String majorNo;
    //学生所属的班级编号
    private String classNo;
    //学号或姓名
    private String student;
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
    
    

}
