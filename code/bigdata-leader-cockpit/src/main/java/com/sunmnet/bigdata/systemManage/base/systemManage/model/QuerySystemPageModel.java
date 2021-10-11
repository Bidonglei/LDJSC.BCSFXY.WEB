package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsWarnEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemStatusEnum;
/**
 * @Description: 查询系统信息返回参数model
 * @author wm
 * @date 2018-03-27
 * @version 1.0
 */
public class QuerySystemPageModel extends BaseModel {

	private static final long serialVersionUID = 9120066040045554390L;

	
	 //系统编号  唯一标识
    private String systemNo;
    //系统名称
    private String systemName;
    //系统状态    正常 NORMAL,  锁定 LOCK
    private SystemStatusEnum systemStatus;
    //系统状态    正常 NORMAL,  锁定 LOCK
    private String systemStatusStr;
    //是否设置预警  YES是 NO否
    private IsWarnEnum isWarn;
    //是否设置预警  YES是 NO否
    private String isWarnStr;
    //系统描述
    private String systemDescribe;
    //系统url
    private String systemUrl;
    //创建时间  格式：YYYYMMDDHHmmssSSS
    private String createTime;
    //最后修改时间  格式：YYYYMMDDHHmmssSSS
    private String lastModifyTime;
	public String getSystemNo() {
		return systemNo;
	}
	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public SystemStatusEnum getSystemStatus() {
		return systemStatus;
	}
	public void setSystemStatus(SystemStatusEnum systemStatus) {
		this.systemStatus = systemStatus;
	}
	public String getSystemStatusStr() {
		return systemStatusStr;
	}
	public void setSystemStatusStr(String systemStatusStr) {
		this.systemStatusStr = systemStatusStr;
	}
	public String getSystemDescribe() {
		return systemDescribe;
	}
	public void setSystemDescribe(String systemDescribe) {
		this.systemDescribe = systemDescribe;
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
	public String getSystemUrl() {
		return systemUrl;
	}
	public void setSystemUrl(String systemUrl) {
		this.systemUrl = systemUrl;
	}
	public IsWarnEnum getIsWarn() {
		return isWarn;
	}
	public void setIsWarn(IsWarnEnum isWarn) {
		this.isWarn = isWarn;
	}
	public String getIsWarnStr() {
		return isWarnStr;
	}
	public void setIsWarnStr(String isWarnStr) {
		this.isWarnStr = isWarnStr;
	}
}
