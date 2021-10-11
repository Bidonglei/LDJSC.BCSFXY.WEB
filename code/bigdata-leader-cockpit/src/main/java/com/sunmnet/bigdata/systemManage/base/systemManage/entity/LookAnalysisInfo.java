package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import org.hibernate.validator.constraints.NotBlank;

public class LookAnalysisInfo {
    private Integer id;

	@NotBlank(message = "名字不能为空")
    private String name;//名字

	@NotBlank(message = "账号不能为空")
    private String account;//账号

	@NotBlank(message = "一级菜单编码不能为空")
    private String oneMenuCode;//一级菜单编码

	@NotBlank(message = "一级菜单名称不能为空")
	private String oneMenu;//一级菜单名称

	@NotBlank(message = "二级菜单编码不能为空")
    private String twoMenuCode;//二级菜单编码

	@NotBlank(message = "二级菜单名称不能为空")
	private String twoMenu;//二级菜单名称

	@NotBlank(message = "三级菜单编码不能为空")
    private String threeMenuCode;//三级菜单编码

	@NotBlank(message = "三级菜单名称不能为空")
	private String threeMenu;//三级菜单名称

    private String time;//时间

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}