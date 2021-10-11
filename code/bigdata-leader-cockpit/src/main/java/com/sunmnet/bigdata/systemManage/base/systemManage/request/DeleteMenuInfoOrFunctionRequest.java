package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 删除菜信息请求参数
 * @author wm
 * @date 2018-04-08
 * @version 1.0
 */
public class DeleteMenuInfoOrFunctionRequest extends BaseRequest {

	private static final long serialVersionUID = -1856081486201693706L;
	
	@NotBlank(message = "菜单编号不能为空")
    private String menuNo;//菜单编号唯一标识
    
    
	public String getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
}
