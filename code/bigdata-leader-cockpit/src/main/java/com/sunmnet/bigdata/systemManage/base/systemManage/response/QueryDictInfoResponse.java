package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.DictKeyValueModel;
/**
 * 查看字典详情
 * @param 
 * @author fr
 * @create 2018-09-17
 * @return
 */
public class QueryDictInfoResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5142605993266981876L;
	 //字典类型
    private String dictType;
    //字典名称
    private String dictName;
    //描述
    private String dictDescribe;
    List<DictKeyValueModel> list;
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
	public String getDictDescribe() {
		return dictDescribe;
	}
	public void setDictDescribe(String dictDescribe) {
		this.dictDescribe = dictDescribe;
	}
	public List<DictKeyValueModel> getList() {
		return list;
	}
	public void setList(List<DictKeyValueModel> list) {
		this.list = list;
	}
    
    
}
