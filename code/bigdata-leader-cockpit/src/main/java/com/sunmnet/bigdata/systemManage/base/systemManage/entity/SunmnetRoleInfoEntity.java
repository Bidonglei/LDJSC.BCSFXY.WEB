package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import com.sunmnet.bigdata.systemManage.base.support.entity.BaseEntity;

/**
 * @ClassName SunmnetRoleInfoEntity
 * @Description 角色信息表
 * @author wm
 * @date 2018-04-03 18:32:51
 * @version 1.0 
 */
public class SunmnetRoleInfoEntity extends BaseEntity{

	private static final long serialVersionUID = -986919759937647970L;
	//主键ID
    private Long id;
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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRoleNo() {
        return roleNo;
    }
    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo == null ? null : roleNo.trim();
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
    public String getRoleDescribe() {
        return roleDescribe;
    }
    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe == null ? null : roleDescribe.trim();
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