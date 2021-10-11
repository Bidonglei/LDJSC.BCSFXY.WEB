package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;


/**
 * @Description: 菜单信息下拉框选择返回参数model
 * @author zfb
 * @date 2018-04-08
 * @version 1.0
 */
public class QueryMenuDropdownModel  extends BaseModel {

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
