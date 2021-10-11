package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
/**
 * 查看字典详情
 * @param 
 * @author fr
 * @create 2018-09-17
 * @return
 */
public class QueryDictInfoRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -410948988731913443L;
	@NotBlank(message = "字典标识不能为空")
	private String dictType; //字典标识
	public String getDictType() {
		return dictType;
	}
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}
	
	
}
