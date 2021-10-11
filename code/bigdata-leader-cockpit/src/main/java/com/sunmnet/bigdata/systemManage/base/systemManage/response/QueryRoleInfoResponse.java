package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;


/**
 * @Description: 查询角色信息详情返回参数
 * @author wm
 * @date 2018-04-07
 * @version 1.0
 */
public class QueryRoleInfoResponse  extends BaseResponse{

	private static final long serialVersionUID = 3168974682813422082L;
	//角色编号 唯一标识
    private String roleNo;
    //角色名称
    private String roleName;
    //角色描述
    private String roleDescribe;
    //创建时间  格式：YYYYMMDDHHmmssSSS
    private String createTime;
    //最后修改时间  格式：YYYYMMDDHHmmssSSS
    private String lastModifyTime;
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
	public String getRoleDescribe() {
		return roleDescribe;
	}
	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
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
