package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;

/**
 * @Description:查询用户权限菜单编号返回参数
 * @author wm
 * @date 2018-05-27
 * @version 1.0
 */
public class QueryUserRoleMenuAllResponse extends BaseResponse{

	private static final long serialVersionUID = 805788326242941167L;
	
	private List<String> menuNoList;

	public List<String> getMenuNoList() {
		return menuNoList;
	}

	public void setMenuNoList(List<String> menuNoList) {
		this.menuNoList = menuNoList;
	}
	
}
