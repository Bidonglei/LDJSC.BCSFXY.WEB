package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
/**
 * 修改字典
 * @param 
 * @author fr
 * @create 2018-09-17
 * @return
 */
public class UpdateDictInfoRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 606954257666650376L;
    //字典类型
	@NotBlank(message = "字典类型不能为空")
    private String dictType;
    //字典名称
	@NotBlank(message = "字典名称不能为空")
    private String dictName;
    //字典键值
    @NotBlank(message = "字典键值不能为空")
    private String keyValueStr;//按照key:value,key:value...拼接
    //描述
    private String dictDescribe;
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
	public String getKeyValueStr() {
		return keyValueStr;
	}
	public void setKeyValueStr(String keyValueStr) {
		this.keyValueStr = keyValueStr;
	}
	
	
}
