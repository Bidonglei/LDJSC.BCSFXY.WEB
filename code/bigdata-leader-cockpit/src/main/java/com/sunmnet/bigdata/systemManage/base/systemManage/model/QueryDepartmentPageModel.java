package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.DepartmentStatusEnum;

/**
 * @Description: 查询部门信息返回参数model
 * @author wth
 * @date 2018-03-27
 * @version 1.0
 */
public class QueryDepartmentPageModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2131820436674821293L;

	private String departmentNo;// 部门编号唯一标识

	private String departmentName; // 部门名称
	
	private long num;//部门成员数量	
	//部门描述
    private String departmentDescribe;
    //部门状态    正常 NORMAL,  锁定 LOCK
    private DepartmentStatusEnum departmentStatus;
    private String departmentStatusStr;

	private String createTime;// 创建时间 格式：YYYYMMDDHHmmssSSS

	private String lastModifyTime;// 最后修改时间 格式：YYYYMMDDHHmmssSSS

	public String getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getDepartmentDescribe() {
		return departmentDescribe;
	}

	public void setDepartmentDescribe(String departmentDescribe) {
		this.departmentDescribe = departmentDescribe;
	}

	public DepartmentStatusEnum getDepartmentStatus() {
		return departmentStatus;
	}

	public void setDepartmentStatus(DepartmentStatusEnum departmentStatus) {
		this.departmentStatus = departmentStatus;
	}

	public String getDepartmentStatusStr() {
		return departmentStatusStr;
	}

	public void setDepartmentStatusStr(String departmentStatusStr) {
		this.departmentStatusStr = departmentStatusStr;
	}
	
	
}
