package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import com.sunmnet.bigdata.systemManage.base.support.entity.BaseEntity;

/**
 * @ClassName SunmnetAcademyMajorInfoEntity
 * @Description 系和专业对应表
 * @author Administrator
 * @date 2018-04-28 09:22:43
 * @version 1.0 
 */
public class SunmnetAcademyMajorInfoEntity extends BaseEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5944498732840304501L;
	//ID
    private Long id;
    //系编号
    private String departmentNo;
    //系名称
    private String departmentName;
    //专业编号
    private String majorNo;
    //专业名称
    private String majorName;
    private String createTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

}