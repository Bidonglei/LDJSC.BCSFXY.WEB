package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import com.sunmnet.bigdata.systemManage.base.support.request.BasePageRequest;


/**
 * @Description: 分页查询角色信息列表请求参数
 * @author wm
 * @date 2018-04-07
 * @version 1.0
 */
public class QueryRoleInfoPageRequest extends BasePageRequest {
	
	private static final long serialVersionUID = 5861951092425438538L;
	
    private String roleNo;//角色编号 唯一标识
    private String roleName;//角色名称
    private String startTime;//开始时间  格式：YYYYMMDDHHmmss
    private String endTime;//最后修改时间  格式：YYYYMMDDHHmmss
	public String getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
