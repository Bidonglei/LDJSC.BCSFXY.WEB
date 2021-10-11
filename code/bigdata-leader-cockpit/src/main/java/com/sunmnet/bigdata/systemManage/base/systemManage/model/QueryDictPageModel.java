package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;


/**
 * 分页查询数据字典列表
 * @param queryDictPageRequest
 * @author zfb
 * @create 2018-09-17
 * @return
 */	
public class QueryDictPageModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5017668067708762852L;
	
	// id 主键自增
    private Long id;
    //字典类型
    private String dictType;
    //字典名称
    private String dictName;
    //字典键
    private String dictKey;
    //字典值
    private String dictValue;
    //描述
    private String dictDescribe;   
    //创建时间  格式：YYYYMMDDHHmmss
    private String createTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getDictKey() {
		return dictKey;
	}
	public void setDictKey(String dictKey) {
		this.dictKey = dictKey;
	}
	public String getDictValue() {
		return dictValue;
	}
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	public String getDictDescribe() {
		return dictDescribe;
	}
	public void setDictDescribe(String dictDescribe) {
		this.dictDescribe = dictDescribe;
	}	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
    
    

}
