package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;


public class QueryDictDropDownModel extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1618505025752098552L;
	// 字典KEY
    private String id;    
    //字典值
    private String dictName;
    //关联ID
    private String connectId;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getConnectId() {
		return connectId;
	}

	public void setConnectId(String connectId) {
		this.connectId = connectId;
	}
}
