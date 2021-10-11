package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 修改功能点请求参数
 * @author wm
 * @date 2018-04-08
 * @version 1.0
 */
public class ModifyMenuFunctionRequest extends BaseRequest {

	
	private static final long serialVersionUID = -320147772600321801L;
	
	
	@NotBlank(message = "功能点所属系统编号不能为空")
    private String systemNo;//功能点所属系统编号
	@NotBlank(message = "功能点名称不能为空")
    private String menuName;//功能点名称
	@NotBlank(message = "功能点上级菜单编号不能为空")
    private String parentMenuNo;//上级菜单编号
    @NotBlank(message = "功能点编号不能为空")
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
	public String getParentMenuNo() {
		return parentMenuNo;
	}
	public void setParentMenuNo(String parentMenuNo) {
		this.parentMenuNo = parentMenuNo;
	}
	public String getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
    
}
