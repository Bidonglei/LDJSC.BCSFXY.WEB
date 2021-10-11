package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import com.sunmnet.bigdata.systemManage.base.support.entity.BaseEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.AdminStatusEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.AdminTypeEnum;

/**
 * @ClassName SunmnetSystemAdminInfoEntity
 * @Description 管理员信息表
 * @author wm
 * @date 2018-04-03 18:32:51
 * @version 1.0 
 */
public class SunmnetSystemAdminInfoEntity extends BaseEntity{

	private static final long serialVersionUID = 2167451580933977208L;
	//主键ID
    private Long id;
    //管理员编号  唯一约束
    private String adminNo;
    //管理员姓名
    private String adminName;
    // 管理员昵称
    private String adminNickname;
    //管理员手机号
    private String adminMobile;
    //管理员邮箱
    private String adminMail;
    // 管理员类型  SUPERADMIN 超级管理员    ADMIN 管理员
    private AdminTypeEnum adminType;
    //管理员状态  初始化INIT， 正常 NORMAL,  锁定 LOCK 
    private AdminStatusEnum adminStatus;
    //管理员密码	（密文）
    private String adminPassword;
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
    public String getAdminNo() {
        return adminNo;
    }
    public void setAdminNo(String adminNo) {
        this.adminNo = adminNo == null ? null : adminNo.trim();
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }
    public String getAdminNickname() {
        return adminNickname;
    }
    public void setAdminNickname(String adminNickname) {
        this.adminNickname = adminNickname == null ? null : adminNickname.trim();
    }
    public String getAdminMobile() {
        return adminMobile;
    }
    public void setAdminMobile(String adminMobile) {
        this.adminMobile = adminMobile == null ? null : adminMobile.trim();
    }
    public String getAdminMail() {
        return adminMail;
    }
    public void setAdminMail(String adminMail) {
        this.adminMail = adminMail == null ? null : adminMail.trim();
    }
    public AdminTypeEnum getAdminType() {
		return adminType;
	}
	public void setAdminType(AdminTypeEnum adminType) {
		this.adminType = adminType;
	}
	public AdminStatusEnum getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(AdminStatusEnum adminStatus) {
		this.adminStatus = adminStatus;
	}
	public String getAdminPassword() {
        return adminPassword;
    }
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
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