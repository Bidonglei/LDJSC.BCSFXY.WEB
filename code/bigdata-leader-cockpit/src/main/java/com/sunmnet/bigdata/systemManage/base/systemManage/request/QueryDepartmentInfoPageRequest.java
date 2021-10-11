package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import com.sunmnet.bigdata.systemManage.base.support.request.BasePageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.DepartmentStatusEnum;
/**
 * @Description: 查询部门信息分页请求参数
 * @author wth
 * @date 2018-03-27
 * @version 1.0
 */
public class QueryDepartmentInfoPageRequest extends BasePageRequest{

	
	private static final long serialVersionUID = -196119967297091165L;
	
	
	//部门编号唯一标识
    private String departmentNo;    

    //创建时间  格式：YYYYMMDDHHmmss
    private String beginTime;

    //最后修改时间  格式：YYYYMMDDHHmmss
    private String endTime;
    
    //部门状态    正常 NORMAL,  锁定 LOCK
    private DepartmentStatusEnum departmentStatus;
	
    
    public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public DepartmentStatusEnum getDepartmentStatus() {
		return departmentStatus;
	}
	public void setDepartmentStatus(DepartmentStatusEnum departmentStatus) {
		this.departmentStatus = departmentStatus;
	}
	
	

    
    
    
    
	

}
