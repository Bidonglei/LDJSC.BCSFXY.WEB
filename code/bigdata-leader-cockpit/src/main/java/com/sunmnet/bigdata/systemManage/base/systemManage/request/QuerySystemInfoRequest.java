package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * @Description: 查询具体系统信息请求参数
 * @author wm
 * @date 2018-03-23
 * @version 1.0
 */
public class QuerySystemInfoRequest extends BaseRequest {

	private static final long serialVersionUID = 8351649838436920471L;
	@NotBlank(message = "系统编号不能为空")
    private String systemNo;//系统编号  唯一标识
	public String getSystemNo() {
		return systemNo;
	}
	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
}
