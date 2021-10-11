package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * @Description: 查询菜单信息返回参数model
 * @author zfb
 * @date 2018-04-12
 * @version 1.0
 */
public class MenuInfoModel   extends BaseModel {

	private static final long serialVersionUID = 8403364133587742065L;
	
	//系统编号  唯一标识
    private String systemNo;
    private String systemName;//系统名称
    private String isLogin;//能否登陆管理系统标志：1 能，0 否
    private List<FirstMenuInfoModel> menuList;
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

	public String getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(String isLogin) {
		this.isLogin = isLogin;
	}

	public List<FirstMenuInfoModel> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<FirstMenuInfoModel> menuList) {
		this.menuList = menuList;
	}
	
	
}
