package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import com.sunmnet.bigdata.systemManage.base.support.entity.BaseEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsWarnEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemStatusEnum;

/**
 * @ClassName SunmnetSystemInfoEntity
 * @Description 系统表
 * @author wm
 * @date 2018-04-03 18:32:51
 * @version 1.0 
 */
public class SunmnetSystemInfoEntity extends BaseEntity{

	private static final long serialVersionUID = 6858286809691182065L;
	// 主键ID
    private Long id;
    //系统编号  唯一标识
    private String systemNo;
    //系统名称
    private String systemName;
    //系统状态    正常 NORMAL,  锁定 LOCK
    private SystemStatusEnum systemStatus;
    //是否设置预警  YES是 NO否
    private IsWarnEnum isWarn;
    //系统描述
    private String systemDescribe;
    //系统url
    private String systemUrl;
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
    public String getSystemNo() {
        return systemNo;
    }
    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo == null ? null : systemNo.trim();
    }
    public String getSystemName() {
        return systemName;
    }
    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }
    
    public SystemStatusEnum getSystemStatus() {
		return systemStatus;
	}
	public void setSystemStatus(SystemStatusEnum systemStatus) {
		this.systemStatus = systemStatus;
	}
	public IsWarnEnum getIsWarn() {
		return isWarn;
	}
	public void setIsWarn(IsWarnEnum isWarn) {
		this.isWarn = isWarn;
	}
	public String getSystemDescribe() {
        return systemDescribe;
    }
    public void setSystemDescribe(String systemDescribe) {
        this.systemDescribe = systemDescribe == null ? null : systemDescribe.trim();
    }
    public String getSystemUrl() {
		return systemUrl;
	}
	public void setSystemUrl(String systemUrl) {
		this.systemUrl = systemUrl;
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