package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;
/**
 * 查看字典详情
 * @param 
 * @author fr
 * @create 2018-09-17
 * @return
 */
public class DictKeyValueModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2962367896480890709L;
	//字典键
    private String dictKey;
    //字典值
    private String dictValue;
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
    
    
}
