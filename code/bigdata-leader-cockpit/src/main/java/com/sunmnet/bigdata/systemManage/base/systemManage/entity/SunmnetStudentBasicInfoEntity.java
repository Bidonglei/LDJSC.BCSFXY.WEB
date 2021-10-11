package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import com.sunmnet.bigdata.systemManage.base.support.entity.BaseEntity;



/**
 * @ClassName SunmnetStudentBasicInfoEntity
 * @Description 学生信息表
 * @author wm
 * @date 2018-04-20 14:02:27
 * @version 1.0 
 */
public class SunmnetStudentBasicInfoEntity extends BaseEntity{

	private static final long serialVersionUID = 2183260410041881535L;
	//ID
    private Long id;
    //学生编号  唯一标识
    private String studentNo;
    //学生姓名
    private String studentName;
    //性别
    private String sex;
    //出生日期
    private String birthday;
    //民族
    private String nation;
    //籍贯
    private String nativePlace;
    //学校
    private String school;
    //学生所属的系编号
    private String departmentNo;
    //学生所属的系名称
    private String departmentName;
    //学生所属的专业编号
    private String majorNo;
    //学生所属的专业名称
    private String majorName;
    //学生所属的班级编号
    private String classNo;
    //学生所属的班级名称
    private String className;
    //入学时间
    private String enrollmentTime;
    //身份证号
    private String idCard;
    //住址
    private String address;
    //电话
    private String telephone;
    //微信
    private String wechat;
    //QQ
    private String qqNumber;
    //父亲姓名
    private String fatherName;
    //父亲电话
    private String fatherPhone;
    //创建时间 格式：YYYYMMDDHHmmssSSS
    private String createTime;
    //学生所属的年级名称
    private String gradeName;
    //学年制 如 3 或 5
    private String educationalSystem;
    //政治面貌
    private String politicalOutlook;
    //照片信息
    private String photoUrl;
    //生源地
    private String originName;
    private String child;
    //孤儿非孤儿
    private String orphans;
    //烈士优抚子女
    private String specialChild;
    //是否在校
    private Integer inschool;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStudentNo() {
        return studentNo;
    }
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }
    public String getNation() {
        return nation;
    }
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }
    public String getNativePlace() {
        return nativePlace;
    }
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }
    public String getDepartmentNo() {
        return departmentNo;
    }
    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo == null ? null : departmentNo.trim();
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }
    public String getMajorNo() {
        return majorNo;
    }
    public void setMajorNo(String majorNo) {
        this.majorNo = majorNo == null ? null : majorNo.trim();
    }
    public String getMajorName() {
        return majorName;
    }
    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }
    public String getClassNo() {
        return classNo;
    }
    public void setClassNo(String classNo) {
        this.classNo = classNo == null ? null : classNo.trim();
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }
    public String getEnrollmentTime() {
        return enrollmentTime;
    }
    public void setEnrollmentTime(String enrollmentTime) {
        this.enrollmentTime = enrollmentTime == null ? null : enrollmentTime.trim();
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }
    public String getWechat() {
        return wechat;
    }
    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }
    public String getQqNumber() {
        return qqNumber;
    }
    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber == null ? null : qqNumber.trim();
    }
    public String getFatherName() {
        return fatherName;
    }
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName == null ? null : fatherName.trim();
    }
    public String getFatherPhone() {
        return fatherPhone;
    }
    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone == null ? null : fatherPhone.trim();
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
    public String getGradeName() {
        return gradeName;
    }
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }
    public String getEducationalSystem() {
        return educationalSystem;
    }
    public void setEducationalSystem(String educationalSystem) {
        this.educationalSystem = educationalSystem == null ? null : educationalSystem.trim();
    }
    public String getPoliticalOutlook() {
        return politicalOutlook;
    }
    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook == null ? null : politicalOutlook.trim();
    }
    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }
    public String getOriginName() {
        return originName;
    }
    public void setOriginName(String originName) {
        this.originName = originName == null ? null : originName.trim();
    }
    public String getChild() {
        return child;
    }
    public void setChild(String child) {
        this.child = child == null ? null : child.trim();
    }
    public String getOrphans() {
        return orphans;
    }
    public void setOrphans(String orphans) {
        this.orphans = orphans == null ? null : orphans.trim();
    }
    public String getSpecialChild() {
        return specialChild;
    }
    public void setSpecialChild(String specialChild) {
        this.specialChild = specialChild == null ? null : specialChild.trim();
    }
	public Integer getInschool() {
		return inschool;
	}
	public void setInschool(Integer inschool) {
		this.inschool = inschool;
	}

}