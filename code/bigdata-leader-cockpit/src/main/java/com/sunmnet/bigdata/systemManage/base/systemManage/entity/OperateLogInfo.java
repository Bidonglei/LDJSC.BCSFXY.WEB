package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

public class OperateLogInfo {
    private Integer id;

    private String name;//名字

    private String account;//账号

    private String type;//操作类型：login（登录系统），look（查看分析），opinion（提交反馈）

	private String oneMenuCode;//一级菜单编码

	private String oneMenu;//一级菜单名称

	private String twoMenuCode;//二级菜单编码

	private String twoMenu;//二级菜单名称

	private String threeMenuCode;//三级菜单编码

	private String threeMenu;//三级菜单名称

	private String operateDescribe;//操作描述（如 查看分析：查看人事->人事学院分析->各类人员结构）

	private String operateTime;//操作时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOneMenuCode() {
		return oneMenuCode;
	}

	public void setOneMenuCode(String oneMenuCode) {
		this.oneMenuCode = oneMenuCode;
	}

	public String getOneMenu() {
		return oneMenu;
	}

	public void setOneMenu(String oneMenu) {
		this.oneMenu = oneMenu;
	}

	public String getTwoMenuCode() {
		return twoMenuCode;
	}

	public void setTwoMenuCode(String twoMenuCode) {
		this.twoMenuCode = twoMenuCode;
	}

	public String getTwoMenu() {
		return twoMenu;
	}

	public void setTwoMenu(String twoMenu) {
		this.twoMenu = twoMenu;
	}

	public String getThreeMenuCode() {
		return threeMenuCode;
	}

	public void setThreeMenuCode(String threeMenuCode) {
		this.threeMenuCode = threeMenuCode;
	}

	public String getThreeMenu() {
		return threeMenu;
	}

	public void setThreeMenu(String threeMenu) {
		this.threeMenu = threeMenu;
	}

	public String getOperateDescribe() {
		return operateDescribe;
	}

	public void setOperateDescribe(String operateDescribe) {
		this.operateDescribe = operateDescribe;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
}