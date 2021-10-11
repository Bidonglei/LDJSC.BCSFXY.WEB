package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.AdminMenuInfoRoleModel;

/**
 * @Description: 管理员登录返回参数
 * @author wm
 * @date 2018-02-07
 * @version 1.0
 */
public class SystemAdminLoginResponse extends BaseResponse {

	private static final long serialVersionUID = 8351649838436920471L;
	private String adminNo;//管理员编号
    private String adminName; //管理员姓名
    private List<AdminMenuInfoRoleModel> menuUrls;
	public String getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public List<AdminMenuInfoRoleModel> getMenuUrls() {
		return menuUrls;
	}
	public void setMenuUrls(List<AdminMenuInfoRoleModel> menuUrls) {
		this.menuUrls = menuUrls;
	}
	
}