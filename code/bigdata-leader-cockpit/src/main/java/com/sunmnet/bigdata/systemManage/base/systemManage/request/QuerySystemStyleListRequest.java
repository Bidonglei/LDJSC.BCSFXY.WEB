package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;


/**
 * 查询系统风格设置列表
 * @param querySystemStyleList
 * @author zfb
 * @create 2019-01-21
 * @return
 */
public class QuerySystemStyleListRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 969787836891178211L;
	
	
	@NotBlank(message = " 系统编号不能为空")
	private String systemNo; //系统编号


	public String getSystemNo() {
		return systemNo;
	}


	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
	
	

}
