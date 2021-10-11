package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * 查询教务角色教师下拉框
 * @author zfb
 * @create 2018-05-21
 * @return
 */
public class QueryTeacherDropDownModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1754297886863112828L;

	private String modelKey;
	private String modelName;
	public String getModelKey() {
		return modelKey;
	}
	public void setModelKey(String modelKey) {
		this.modelKey = modelKey;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	
	
	
}
