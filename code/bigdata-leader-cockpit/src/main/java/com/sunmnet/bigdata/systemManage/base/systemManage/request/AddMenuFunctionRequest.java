package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.MenuLevelEnum;

/**
 * @Description: 添加功能点请求参数
 * @author wm
 * @date 2018-04-08
 * @version 1.0
 */
public class AddMenuFunctionRequest extends BaseRequest {

	private static final long serialVersionUID = -6084980921752256515L;
	
	@NotBlank(message = "功能点所属系统编号不能为空")
    private String systemNo;//功能点所属系统编号
	@NotBlank(message = "功能点名称不能为空")
    private String menuName;//功能点名称
	@NotNull(message = "菜单级别不能为空")
    private MenuLevelEnum menuLevel; //菜单级别  等级  ONE 主菜单 TWO 子菜单  
	private String firstMenuNo;//一级菜单编号 ，只有菜单级别为TWO是有值
    private String secondMenuNo;//二级菜单编号
    private String parentMenuNo;//上级菜单编号
    private String menuNo;//菜单编号唯一标识
	public String getSystemNo() {
		return systemNo;
	}
	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public MenuLevelEnum getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(MenuLevelEnum menuLevel) {
		this.menuLevel = menuLevel;
	}
	public String getFirstMenuNo() {
		return firstMenuNo;
	}
	public void setFirstMenuNo(String firstMenuNo) {
		this.firstMenuNo = firstMenuNo;
	}
	public String getSecondMenuNo() {
		return secondMenuNo;
	}
	public void setSecondMenuNo(String secondMenuNo) {
		this.secondMenuNo = secondMenuNo;
	}
	public String getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
	public String getParentMenuNo() {
		return parentMenuNo;
	}
	public void setParentMenuNo(String parentMenuNo) {
		this.parentMenuNo = parentMenuNo;
	}
}
