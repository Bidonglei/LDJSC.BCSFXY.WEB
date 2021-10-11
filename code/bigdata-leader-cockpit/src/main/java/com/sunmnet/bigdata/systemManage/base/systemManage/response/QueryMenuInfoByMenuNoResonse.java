package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.MenuLevelEnum;

/**
 * @Description: 根据菜单编号查询菜单详细信息
 * @author zfb
 * @date 2018-04-13
 * @version 1.0
 */
public class QueryMenuInfoByMenuNoResonse   extends BaseResponse{

	private static final long serialVersionUID = 6995835716360699326L;
	//菜单编号唯一标识
    private String menuNo;
    //菜单名称
    private String menuName;
    //菜单URL地址
    private String menuUrl;
    //菜单级别  等级  ONE 主菜单 TWO 子菜单  THREE 级为功能按钮
    private MenuLevelEnum menuLevel;
    private String menuLevelStr;
    //上级菜单编号
    private String parentMenuNo;
    //菜单排序序号
    private String menuSortNo;
    //菜单所属系统编号
    private String systemNo;
    //菜单所属系统名称
    private String systemName;
    //第一级别菜单编号
    private String firstMenuNo;
    //第一级别菜单名称
    private String firstMenuName;
    //第二级别菜单编号
    private String secondMenuNo;
    //第二级别菜单名称
    private String secondMenuName;
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
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public MenuLevelEnum getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(MenuLevelEnum menuLevel) {
		this.menuLevel = menuLevel;
	}
	
	public String getMenuLevelStr() {
		return menuLevelStr;
	}
	public void setMenuLevelStr(String menuLevelStr) {
		this.menuLevelStr = menuLevelStr;
	}
	public String getParentMenuNo() {
		return parentMenuNo;
	}
	public void setParentMenuNo(String parentMenuNo) {
		this.parentMenuNo = parentMenuNo;
	}
	public String getMenuSortNo() {
		return menuSortNo;
	}
	public void setMenuSortNo(String menuSortNo) {
		this.menuSortNo = menuSortNo;
	}
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
	public String getFirstMenuNo() {
		return firstMenuNo;
	}
	public void setFirstMenuNo(String firstMenuNo) {
		this.firstMenuNo = firstMenuNo;
	}
	public String getFirstMenuName() {
		return firstMenuName;
	}
	public void setFirstMenuName(String firstMenuName) {
		this.firstMenuName = firstMenuName;
	}
	public String getSecondMenuNo() {
		return secondMenuNo;
	}
	public void setSecondMenuNo(String secondMenuNo) {
		this.secondMenuNo = secondMenuNo;
	}
	public String getSecondMenuName() {
		return secondMenuName;
	}
	public void setSecondMenuName(String secondMenuName) {
		this.secondMenuName = secondMenuName;
	}
	
}
