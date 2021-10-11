package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * @Description: 查询角色授权的菜单信息返回参数model
 * @author wm
 * @date 2018-04-08
 * @version 1.0
 */
public class QueryRoleMenuInfoModel  extends BaseModel {

	
	private static final long serialVersionUID = 6860528577866931773L;
	
	//系统编号  唯一标识
    private String systemNo;
    private String systemName;//系统名称
    private List<FirstRoleMenuInfoModel> menuList;    
	
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
	public List<FirstRoleMenuInfoModel> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<FirstRoleMenuInfoModel> menuList) {
		this.menuList = menuList;
	}

}
