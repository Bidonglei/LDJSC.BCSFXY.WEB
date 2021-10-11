package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.MenuLevelEnum;

/**
 * @Description: 查询角色授权的菜单信息model
 * @author wm
 * @date 2018-04-08
 * @version 1.0
 */
public class RoleMenuInfoModelInfo  extends BaseModel {

	
	private static final long serialVersionUID = 6860528577866931773L;
	
	//菜单编号唯一标识
    private String menuNo;
    //菜单名称
    private String menuName;
    //菜单级别  等级  ONE 主菜单 TWO 子菜单  THREE 级为功能按钮
    private MenuLevelEnum menuLevel;
    //上级菜单编号
    private String parentMenuNo;
    //菜单所属系统编号
    private String systemNo;
	// 角色编号
    private String roleNo;
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
	public MenuLevelEnum getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(MenuLevelEnum menuLevel) {
		this.menuLevel = menuLevel;
	}
	public String getSystemNo() {
		return systemNo;
	}
	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
	public String getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}
	public String getParentMenuNo() {
		return parentMenuNo;
	}
	public void setParentMenuNo(String parentMenuNo) {
		this.parentMenuNo = parentMenuNo;
	}
}
