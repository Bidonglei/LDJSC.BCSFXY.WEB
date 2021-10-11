package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.MenuLevelEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.RoleMenuStatusEnum;

/**
 * @Description: 存放主菜单及第二级别列表
 * @author zfb
 * @date 2018-04-13
 * @version 1.0
 */
public class FirstRoleMenuInfoModel extends BaseModel {

	private static final long serialVersionUID = -3653102275109125671L;

	//菜单级别  等级  ONE 主菜单 TWO 子菜单  THREE 级为功能按钮
    private MenuLevelEnum menuLevel;
	//菜单编号唯一标识
    private String menuNo;
    //菜单名称
    private String menuName;
    //角色是否拥有菜单、功能点授权状态   YES 有 NO没有
    private RoleMenuStatusEnum roleMenuStatus;
    //上级菜单编号
    private String parentMenuNo;
    
    //二级菜单列表
    private List<SecondRoleMenuInfoModel> menuList;
    
    
	public MenuLevelEnum getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(MenuLevelEnum menuLevel) {
		this.menuLevel = menuLevel;
	}
	public String getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public RoleMenuStatusEnum getRoleMenuStatus() {
		return roleMenuStatus;
	}
	public void setRoleMenuStatus(RoleMenuStatusEnum roleMenuStatus) {
		this.roleMenuStatus = roleMenuStatus;
	}
	public String getParentMenuNo() {
		return parentMenuNo;
	}
	public void setParentMenuNo(String parentMenuNo) {
		this.parentMenuNo = parentMenuNo;
	}
	public List<SecondRoleMenuInfoModel> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<SecondRoleMenuInfoModel> menuList) {
		this.menuList = menuList;
	}
}
