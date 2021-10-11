package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * 查询系统风格设置列表
 * @param querySystemStyleList
 * @author zfb
 * @create 2019-01-21
 * @return
 */
public class QuerySystemStyleListModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4287290161575489834L;
	
	//设置位置
    private String setPosition;
    
    private List<SystemImgModel> list;

	public String getSetPosition() {
		return setPosition;
	}

	public void setSetPosition(String setPosition) {
		this.setPosition = setPosition;
	}

	public List<SystemImgModel> getList() {
		return list;
	}

	public void setList(List<SystemImgModel> list) {
		this.list = list;
	}
    
    
    

}
