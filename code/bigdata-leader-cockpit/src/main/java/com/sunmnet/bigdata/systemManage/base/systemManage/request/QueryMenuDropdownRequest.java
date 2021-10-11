package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.MenuLevelEnum;

/**
 * @Description: 查询菜单下拉框请求参数
 * @author zfb
 * @date 2018-04-08
 * @version 1.0
 */
public class QueryMenuDropdownRequest extends BaseRequest {

	private static final long serialVersionUID = -618365513236617221L;
	
	@NotBlank(message = "系统编号不能为空")	
    private String systemNo;// 系统编号
	
	@NotNull(message = "菜单级别不能为空")
    private MenuLevelEnum menuLevel; //菜单级别  等级  ONE 主菜单 TWO 子菜单  THREE 级为功能按钮

	private String parentMenuNo;//父级菜单编号

	public String getSystemNo() {
		return systemNo;
	}

	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}

	public MenuLevelEnum getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(MenuLevelEnum menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getParentMenuNo() {
		return parentMenuNo;
	}

	public void setParentMenuNo(String parentMenuNo) {
		this.parentMenuNo = parentMenuNo;
	}
}
