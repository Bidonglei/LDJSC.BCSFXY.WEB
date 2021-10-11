package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryDictDropDownModel;

/**
 * 查询数据字典下拉框
 * @author zfb
 * @create 2018-09-17
 */
public class QueryDictDropDownResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7948670500210085126L;
	
	private List<QueryDictDropDownModel> list;

	public List<QueryDictDropDownModel> getList() {
		return list;
	}

	public void setList(List<QueryDictDropDownModel> list) {
		this.list = list;
	}
	
	
    
    

}
