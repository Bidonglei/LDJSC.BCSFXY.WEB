package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 根据菜单编号查询菜单下级菜单下拉框请求参数
 * @author wm
 * @date 2018-04-12
 * @version 1.0
 */
public class QueryMenuDownDropdownRequest extends BaseRequest {

	private static final long serialVersionUID = -618365513236617221L;
	
	@NotBlank(message = "系统编号不能为空")	
    private String systemNo;// 系统编号
	
	@NotNull(message = "菜单编号不能为空")
    private String menuNo; //菜单编号

	public String getSystemNo() {
		return systemNo;
	}

	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}

	public String getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}


}
