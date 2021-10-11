package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 根据菜单编号查询菜单详细信息
 * @author zfb
 * @date 2018-04-13
 * @version 1.0
 */
public class QueryMenuInfoRequest   extends BaseRequest {

	private static final long serialVersionUID = -3853788899460707123L;
	
	@NotBlank(message = "菜单编号不能为空")
	private String menuNo;// 菜单编号 唯一约束

	public String getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}

}
