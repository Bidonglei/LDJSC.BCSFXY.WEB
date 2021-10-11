package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import com.sunmnet.bigdata.systemManage.base.support.entity.BaseEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.DepartmentStatusEnum;

/**
 * @ClassName SunmnetDepartmentInfoEntity
 * @Description 部门信息表
 * @author sum
 * @date 2018-04-04 17:27:47
 * @version 1.0 
 */
public class SunmnetDepartmentInfoEntity extends BaseEntity{

	private static final long serialVersionUID = -6692794163162184066L;
	
	//主键ID
    private Long id;
    //部门编号唯一标识
    private String departmentNo;
    //部门名称
    private String departmentName;
    //部门描述
    private String departmentDescribe;
    //部门状态    正常 NORMAL,  锁定 LOCK
    private DepartmentStatusEnum departmentStatus;
    //创建时间  格式：YYYYMMDDHHmmssSSS
    private String createTime;
    //最后修改时间  格式：YYYYMMDDHHmmssSSS
    private String lastModifyTime;

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
    public String getDepartmentDescribe() {
        return departmentDescribe;
    }
    public void setDepartmentDescribe(String departmentDescribe) {
        this.departmentDescribe = departmentDescribe == null ? null : departmentDescribe.trim();
    }   
    public DepartmentStatusEnum getDepartmentStatus() {
		return departmentStatus;
	}
	public void setDepartmentStatus(DepartmentStatusEnum departmentStatus) {
		this.departmentStatus = departmentStatus;
	}
	public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
    public String getLastModifyTime() {
        return lastModifyTime;
    }
    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime == null ? null : lastModifyTime.trim();
    }

}