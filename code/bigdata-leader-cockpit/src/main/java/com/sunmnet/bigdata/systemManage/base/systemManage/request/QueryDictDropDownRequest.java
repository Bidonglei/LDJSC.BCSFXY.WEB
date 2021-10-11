package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

public class QueryDictDropDownRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3738917809747412580L;
	
	
	@NotBlank(message = "字典类型不能为空")
    private String dictType; //字典类型

	//关联ID
	private String connectId;

	public String getDictType() {
		return dictType;
	}


	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getConnectId() {
		return connectId;
	}

	public void setConnectId(String connectId) {
		this.connectId = connectId;
	}
}
