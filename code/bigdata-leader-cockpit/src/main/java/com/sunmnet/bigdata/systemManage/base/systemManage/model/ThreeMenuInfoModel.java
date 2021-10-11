package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.MenuLevelEnum;

import java.util.List;

/**
 * @Description: 存放及第三级别列表与权限无关
 * @author zfb
 * @date 2018-04-13
 * @version 1.0
 */
public class ThreeMenuInfoModel  extends BaseModel{
	
	private static final long serialVersionUID = 7881797185092527163L;

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
//	//页面组件文字名称
//	private String pageName;
	//数据源相关部门(可多个)
//	private String dataDepartment;
//	//数据同步时间
//	private String dataSynchronize;
	private String menuUrl;//菜单名称
	//判断有没有数据加效果0正常1无数据(只有三次菜单有用)
	private String data;
	//判断是图还是表1图2表(只有三次菜单有用)
	private String judge;
//	private List list;
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
	public MenuLevelEnum getParentMenuLevel() {
		return parentMenuLevel;
	}
	public void setParentMenuLevel(MenuLevelEnum parentMenuLevel) {
		this.parentMenuLevel = parentMenuLevel;
	}

//	public String getPageName() {
//		return pageName;
//	}
//
//	public void setPageName(String pageName) {
//		this.pageName = pageName;
//	}

//	public String getDataDepartment() {
//		return dataDepartment;
//	}
//
//	public void setDataDepartment(String dataDepartment) {
//		this.dataDepartment = dataDepartment;
//	}

//	public String getDataSynchronize() {
//		return dataSynchronize;
//	}
//
//	public void setDataSynchronize(String dataSynchronize) {
//		this.dataSynchronize = dataSynchronize;
//	}

//	public List getList() {
//		return list;
//	}
//
//	public void setList(List list) {
//		this.list = list;
//	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
}
