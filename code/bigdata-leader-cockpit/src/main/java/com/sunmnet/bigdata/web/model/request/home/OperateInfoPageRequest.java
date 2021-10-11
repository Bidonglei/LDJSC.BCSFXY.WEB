package com.sunmnet.bigdata.web.model.request.home;

import com.sunmnet.bigdata.systemManage.base.support.request.BasePageRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 *功能描述 意见列表
 * @author lkg
 * @date 2019/8/20
 */
public class OperateInfoPageRequest extends BasePageRequest{

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

	//二级模块编码
	@ApiModelProperty(value="二级模块编码")
    private String twoMenu;

	//意见类型
	@ApiModelProperty(value="意见类型")
	private String opinionType;

	@ApiModelProperty("状态")
	private String status;

	@ApiModelProperty("重要程度")
	private String importance;

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

	public String getTwoMenu() {
		return twoMenu;
	}

	public void setTwoMenu(String twoMenu) {
		this.twoMenu = twoMenu;
	}

	public String getOpinionType() {
		return opinionType;
	}

	public void setOpinionType(String opinionType) {
		this.opinionType = opinionType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getNameOrAccount() {
		return nameOrAccount;
	}

	public void setNameOrAccount(String nameOrAccount) {
		this.nameOrAccount = nameOrAccount;
	}
}
