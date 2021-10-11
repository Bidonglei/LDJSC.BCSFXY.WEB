package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * 查询颜色设置列表
 * @param queryColorSetList
 * @author zfb
 * @create 2019-01-21
 * @return
 */
public class QueryColorSetListRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8307439519827892675L;
	
	@NotBlank(message = "系统编号不能为空")	
    private String systemNo; //系统编号  唯一标识

	public String getSystemNo() {
		return systemNo;
	}

	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
	
	

}
