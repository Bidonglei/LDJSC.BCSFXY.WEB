package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.DepartmentStatusEnum;


/**
 * @Description: 查询部门详细信息返回参数
 * @author zfb
 * @date 2018-04-05
 * @version 1.0
 */
public class QueryDepartmentInfoResponse  extends BaseResponse{

	private static final long serialVersionUID = 3168974682813422082L;
	
	//部门编号唯一标识
    private String departmentNo;
    
  //部门名称
    private String departmentName;
    
    private long num;//部门成员数量
    //部门描述
    private String departmentDescribe;
    //部门状态    正常 NORMAL,  锁定 LOCK
    private DepartmentStatusEnum departmentStatus;
    private String departmentStatusStr;
    //创建时间  格式：YYYYMMDDHHmmssSSS
    private String createTime;
    //最后修改时间  格式：YYYYMMDDHHmmssSSS
    private String lastModifyTime;
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
    
    

}
