package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * 查询颜色设置列表
 * @param queryColorSetList
 * @author zfb
 * @create 2019-01-21
 * @return
 */
public class QueryColorSetListModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4638752364914197888L;
	
	//设置位置
    private String setPosition;
    //颜色
    private String colorName;
	public String getSetPosition() {
		return setPosition;
	}
	public void setSetPosition(String setPosition) {
		this.setPosition = setPosition;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
    
    
    

}
