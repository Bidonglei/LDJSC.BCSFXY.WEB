package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * 菜单排序
 * @param menuSort
 * @author zfb
 * @create 2018-09-17
 * @return
 */
public class MenuSortRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2293990207610099618L;
	
	@NotBlank(message = "菜单编号按顺序逗号分隔不能为空")
    private String menuNoCom;//菜单编号按顺序逗号分隔

	public String getMenuNoCom() {
		return menuNoCom;
	}

	public void setMenuNoCom(String menuNoCom) {
		this.menuNoCom = menuNoCom;
	}
	
	

}
