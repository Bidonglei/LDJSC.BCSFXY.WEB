package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;


/**
 * @Description: 根据菜单编号查询菜单下级菜单下拉框返回参数model
 * @author wm
 * @date 2018-04-12
 * @version 1.0
 */
public class QueryMenuDownDropdownModel  extends BaseModel {

	private static final long serialVersionUID = 4929309860228606999L;
	//菜单编号唯一标识
    private String menuNo;
    //菜单名称
    private String menuName;
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

}
