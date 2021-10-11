package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.MenuLevelEnum;

/**
 * @Description: 存放第二级别列表与权限无关
 * @author zfb
 * @date 2018-04-13
 * @version 1.0
 */
public class SecondMenuInfoModel extends BaseModel {

	private static final long serialVersionUID = -7657432544458766330L;

	//菜单级别  等级  ONE 主菜单 TWO 子菜单  THREE 级为功能按钮
    private MenuLevelEnum menuLevel;
    //上级菜单级别  等级  ONE 主菜单 TWO 子菜单  THREE 级为功能按钮
    private MenuLevelEnum parentMenuLevel;
	//菜单编号唯一标识
    private String menuNo;
    //菜单名称
    private String menuName;    
    //上级菜单编号
    private String parentMenuNo;
    private String menuUrl;
    //二级菜单列表
    private List<ThreeMenuInfoModel> menuList;
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
	public String getParentMenuNo() {
		return parentMenuNo;
	}
	public void setParentMenuNo(String parentMenuNo) {
		this.parentMenuNo = parentMenuNo;
	}
	public List<ThreeMenuInfoModel> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<ThreeMenuInfoModel> menuList) {
		this.menuList = menuList;
	}
	public MenuLevelEnum getParentMenuLevel() {
		return parentMenuLevel;
	}
	public void setParentMenuLevel(MenuLevelEnum parentMenuLevel) {
		this.parentMenuLevel = parentMenuLevel;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
}
