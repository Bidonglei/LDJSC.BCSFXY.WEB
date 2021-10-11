package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * @Description: 查询管理员权限菜单信息model
 * @author 
 * @date 2018-04-12
 * @version 1.0
 */
public class AdminMenuInfoRoleModel   extends BaseModel {

	private static final long serialVersionUID = 8894226154666761109L;
	//菜单编号
	private String menuNo;
	//菜单url
    private String menuUrl;
    //菜单名称
    private String menuName;
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
	
    
}
