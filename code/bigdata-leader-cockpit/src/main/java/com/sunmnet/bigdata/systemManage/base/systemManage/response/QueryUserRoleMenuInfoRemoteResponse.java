package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.MenuInfoModel;

/**
 * @Description:查询用户用户的权限菜单信息服务间调用返回参数
 * @author wm
 * @date 2018-04-12
 * @version 1.0
 */
public class QueryUserRoleMenuInfoRemoteResponse extends BaseResponse{
	
	private static final long serialVersionUID = -5403188988077949098L;
	
	private MenuInfoModel menuInfo;//菜单信息

	public MenuInfoModel getMenuInfo() {
		return menuInfo;
	}

	public void setMenuInfo(MenuInfoModel menuInfo) {
		this.menuInfo = menuInfo;
	}
	
}
