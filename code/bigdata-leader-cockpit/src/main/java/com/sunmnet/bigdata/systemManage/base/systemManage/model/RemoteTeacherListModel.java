package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.EducationEnums;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsCollegeCertificateEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsCoreTeacherEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsDoubleProfessionallyEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsJobCertificateEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsMajorLeaderEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsQuitEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.ManagerTypeEnums;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.ProfessionalTitleEnum;

/**
 * 根据筛选条件查询教职工信息
 * @author fr
 * @create 2018-06-23
 * @return
 */
public class RemoteTeacherListModel extends BaseModel{
	
	private static final long serialVersionUID = 2133732205958706833L;
	//教师编号
    private String teacherNo;
    //教师姓名
    private String teacherName;
    //性别 
    private String sex;
    //身份证号 
    private String idCardNo;
    //出生日期
    private String birthdate;
    //政治面貌
    private String politicsStatus;
    //民族
    private String nation;
    //籍贯
    private String nativePlace;
    //地源
    private String originPlace;
    //学历 大专及以下 DZJYX 本科 BK 硕士 SS  博士 BS  博士以上  BSYS 
    private EducationEnums education;
    private String educationStr;
    
    //学位  大专及以下 DZJYX 本科 BK 硕士 SS  博士 BS  博士以上  BSYS
    private EducationEnums degree;
    private String degreeStr;
    //一级部门名称
    private String firstDeptName;
    //一级部门编号
    private String firstDeptCode;
    //二级部门名称
    private String secondDeptName;
    //二级部门编号
    private String secondDeptCode;
    //职称：教授 JS 教授级高级工程师 JSGJGCS 副教授 FJS 高级工程师 GJGCS  讲师 JIANGSHI 工程师 GCS  助教 ZJ 助理工程师 ZLGCS 高级技师 GJJS 技师 JISHI 其他 QT
    private ProfessionalTitleEnum professionalTitle;
    private String professionalTitleStr;
    //毕业院校
    private String graduateSchool;
    //毕业专业
    private String graduateMajor;
    //毕业时间
    private String graduateDate;
    //入职时间
    private String hiredate;
    //联系电话
    private String phone;
    //是否为双师素质教师 ( YES 是  NO 否)
    private IsDoubleProfessionallyEnum isDoubleProfessionally;
    private String isDoubleProfessionallyStr;
    //是否为骨干教师( YES 是  NO 否)
    private IsCoreTeacherEnum isCoreTeacher;
    private String isCoreTeacherStr;
    // 是否为专业带头人( YES 是  NO 否)
    private IsMajorLeaderEnum isMajorLeader;
    private String isMajorLeaderStr;
    //是否具备高校教师资格证( YES 是  NO 否)
    private IsCollegeCertificateEnum isCollegeCertificate;
    private String isCollegeCertificateStr;
    //是否具备职业（执业）资格证( YES 是  NO 否)
    private IsJobCertificateEnum isJobCertificate;
    private String isJobCertificateStr;
    //管理人员类型：领导班子 LEADER、处职干部DIVISIONCHIEFS、科职干部SECTIONCHIEFS、其他管理人员OTHERMANAGERS
    private ManagerTypeEnums managerType;
    private String managerTypeStr;
    //是否离职退休  YES 是  NO 否
    private IsQuitEnum isQuit;
    private String isQuitStr;
    private String mail;//邮箱
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getPoliticsStatus() {
		return politicsStatus;
	}
	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getOriginPlace() {
		return originPlace;
	}
	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
	}
	public EducationEnums getEducation() {
		return education;
	}
	public void setEducation(EducationEnums education) {
		this.education = education;
	}
	public String getEducationStr() {
		return educationStr;
	}
	public void setEducationStr(String educationStr) {
		this.educationStr = educationStr;
	}
	public EducationEnums getDegree() {
		return degree;
	}
	public void setDegree(EducationEnums degree) {
		this.degree = degree;
	}
	public String getDegreeStr() {
		return degreeStr;
	}
	public void setDegreeStr(String degreeStr) {
		this.degreeStr = degreeStr;
	}
	public String getFirstDeptName() {
		return firstDeptName;
	}
	public void setFirstDeptName(String firstDeptName) {
		this.firstDeptName = firstDeptName;
	}
	public String getFirstDeptCode() {
		return firstDeptCode;
	}
	public void setFirstDeptCode(String firstDeptCode) {
		this.firstDeptCode = firstDeptCode;
	}
	public String getSecondDeptName() {
		return secondDeptName;
	}
	public void setSecondDeptName(String secondDeptName) {
		this.secondDeptName = secondDeptName;
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
	public String getProfessionalTitleStr() {
		return professionalTitleStr;
	}
	public void setProfessionalTitleStr(String professionalTitleStr) {
		this.professionalTitleStr = professionalTitleStr;
	}
	public String getGraduateSchool() {
		return graduateSchool;
	}
	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}
	public String getGraduateMajor() {
		return graduateMajor;
	}
	public void setGraduateMajor(String graduateMajor) {
		this.graduateMajor = graduateMajor;
	}
	public String getGraduateDate() {
		return graduateDate;
	}
	public void setGraduateDate(String graduateDate) {
		this.graduateDate = graduateDate;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public IsDoubleProfessionallyEnum getIsDoubleProfessionally() {
		return isDoubleProfessionally;
	}
	public void setIsDoubleProfessionally(
			IsDoubleProfessionallyEnum isDoubleProfessionally) {
		this.isDoubleProfessionally = isDoubleProfessionally;
	}
	public String getIsDoubleProfessionallyStr() {
		return isDoubleProfessionallyStr;
	}
	public void setIsDoubleProfessionallyStr(String isDoubleProfessionallyStr) {
		this.isDoubleProfessionallyStr = isDoubleProfessionallyStr;
	}
	public IsCoreTeacherEnum getIsCoreTeacher() {
		return isCoreTeacher;
	}
	public void setIsCoreTeacher(IsCoreTeacherEnum isCoreTeacher) {
		this.isCoreTeacher = isCoreTeacher;
	}
	public String getIsCoreTeacherStr() {
		return isCoreTeacherStr;
	}
	public void setIsCoreTeacherStr(String isCoreTeacherStr) {
		this.isCoreTeacherStr = isCoreTeacherStr;
	}
	public IsMajorLeaderEnum getIsMajorLeader() {
		return isMajorLeader;
	}
	public void setIsMajorLeader(IsMajorLeaderEnum isMajorLeader) {
		this.isMajorLeader = isMajorLeader;
	}
	public String getIsMajorLeaderStr() {
		return isMajorLeaderStr;
	}
	public void setIsMajorLeaderStr(String isMajorLeaderStr) {
		this.isMajorLeaderStr = isMajorLeaderStr;
	}
	public IsCollegeCertificateEnum getIsCollegeCertificate() {
		return isCollegeCertificate;
	}
	public void setIsCollegeCertificate(
			IsCollegeCertificateEnum isCollegeCertificate) {
		this.isCollegeCertificate = isCollegeCertificate;
	}
	public String getIsCollegeCertificateStr() {
		return isCollegeCertificateStr;
	}
	public void setIsCollegeCertificateStr(String isCollegeCertificateStr) {
		this.isCollegeCertificateStr = isCollegeCertificateStr;
	}
	public IsJobCertificateEnum getIsJobCertificate() {
		return isJobCertificate;
	}
	public void setIsJobCertificate(IsJobCertificateEnum isJobCertificate) {
		this.isJobCertificate = isJobCertificate;
	}
	public String getIsJobCertificateStr() {
		return isJobCertificateStr;
	}
	public void setIsJobCertificateStr(String isJobCertificateStr) {
		this.isJobCertificateStr = isJobCertificateStr;
	}
	public ManagerTypeEnums getManagerType() {
		return managerType;
	}
	public void setManagerType(ManagerTypeEnums managerType) {
		this.managerType = managerType;
	}
	public String getManagerTypeStr() {
		return managerTypeStr;
	}
	public void setManagerTypeStr(String managerTypeStr) {
		this.managerTypeStr = managerTypeStr;
	}
	public IsQuitEnum getIsQuit() {
		return isQuit;
	}
	public void setIsQuit(IsQuitEnum isQuit) {
		this.isQuit = isQuit;
	}
	public String getIsQuitStr() {
		return isQuitStr;
	}
	public void setIsQuitStr(String isQuitStr) {
		this.isQuitStr = isQuitStr;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}
