package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import com.sunmnet.bigdata.systemManage.base.support.request.BasePageRequest;

/**
 * 分页查询数据字典列表
 * @param queryDictPageRequest
 * @author zfb
 * @create 2018-09-17
 * @return
 */
public class QueryDictPageRequest extends BasePageRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8577891631913846548L;
	
	//字典类型
    private String dictType;
    //字典名称
    private String dictName;
	public String getDictType() {
		return dictType;
	}
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
    
    

}
