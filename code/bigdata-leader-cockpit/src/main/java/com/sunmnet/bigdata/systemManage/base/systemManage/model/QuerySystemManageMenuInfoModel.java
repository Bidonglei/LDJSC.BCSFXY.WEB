package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.RoleMenuStatusEnum;
/**
 * @Description: 查询管理系统菜单返回参数model
 * @author wm
 * @date 2018-04-06
 * @version 1.0
 */
public class QuerySystemManageMenuInfoModel extends BaseModel {

	private static final long serialVersionUID = 6463268215029165092L;
	
	//菜单编号唯一标识
    private String menuNo;
    //菜单名称
    private String menuName;
    private RoleMenuStatusEnum menuStatus;
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
	public RoleMenuStatusEnum getMenuStatus() {
		return menuStatus;
	}
	public void setMenuStatus(RoleMenuStatusEnum menuStatus) {
		this.menuStatus = menuStatus;
	}
	
	
	
}
