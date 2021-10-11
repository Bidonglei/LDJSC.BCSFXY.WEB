package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.MenuLevelEnum;

/**
 * @Description: 修改菜信息请求参数
 * @author wm
 * @date 2018-04-08
 * @version 1.0
 */
public class ModifyMenuInfoRequest extends BaseRequest {

	
	private static final long serialVersionUID = 3235273056490443943L;
	
	@NotBlank(message = "菜单所属系统编号不能为空")
    private String systemNo;//菜单所属系统编号
	@NotBlank(message = "菜单名称不能为空")
    private String menuName;//菜单名称
	@NotNull(message = "菜单级别不能为空")
    private MenuLevelEnum menuLevel; //菜单级别  等级  ONE 主菜单 TWO 子菜单  THREE 级为功能按钮
    private String parentMenuNo;//上级菜单编号
    private String menuUrl;//菜单URL地址
    @NotBlank(message = "菜单编号不能为空")
    private String menuNo;//菜单编号唯一标识
    
    
	public String getSystemNo() {
		return systemNo;
	}
	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
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
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
}
