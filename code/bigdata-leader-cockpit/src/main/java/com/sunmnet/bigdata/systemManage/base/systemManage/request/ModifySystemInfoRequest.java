package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsWarnEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemStatusEnum;

/**
 * @Description: 修改系统信息请求参数
 * @author wm
 * @date 2018-03-21
 * @version 1.0
 */
public class ModifySystemInfoRequest extends BaseRequest {

	private static final long serialVersionUID = 8351649838436920471L;
	@NotBlank(message = "系统编号不能为空")
    private String systemNo; //系统编号  唯一标识
    private String systemName;//系统名称
    private String systemDescribe;//系统描述
   	private String systemUrl;//系统路径URl
    private SystemStatusEnum systemStatus;//系统状态    正常 NORMAL,  锁定 LOCK
//    @NotNull(message = "是否设置预警不能为空")//是否设置预警  YES是 NO否
    private IsWarnEnum isWarn;
	
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
	public String getSystemDescribe() {
		return systemDescribe;
	}
	public void setSystemDescribe(String systemDescribe) {
		this.systemDescribe = systemDescribe;
	}
	public SystemStatusEnum getSystemStatus() {
		return systemStatus;
	}
	public void setSystemStatus(SystemStatusEnum systemStatus) {
		this.systemStatus = systemStatus;
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
}
