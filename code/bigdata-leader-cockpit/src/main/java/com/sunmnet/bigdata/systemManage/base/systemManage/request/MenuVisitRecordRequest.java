package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import com.sunmnet.bigdata.systemManage.base.support.request.BasePageRequest;
import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 *功能描述 个模块访问记录
 * @author lkg
 * @date 2019/8/7
 */
public class MenuVisitRecordRequest extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8577891631913846548L;
	
	//开始时间
	@ApiModelProperty(value="开始时间")
    private String startTime;

	//结束时间
	@ApiModelProperty(value="结束时间")
    private String endTime;

	//一级模块编码
	@ApiModelProperty(value="一级模块编码")
    private String oneMenu;

	//名字或者账号
	@ApiModelProperty(value="名字或者账号")
    private String nameOrAccount;

	public static long getSerialVersionUID() {
		return serialVersionUID;
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

	public String getOneMenu() {
		return oneMenu;
	}

	public void setOneMenu(String oneMenu) {
		this.oneMenu = oneMenu;
	}

	public String getNameOrAccount() {
		return nameOrAccount;
	}

	public void setNameOrAccount(String nameOrAccount) {
		this.nameOrAccount = nameOrAccount;
	}
}
