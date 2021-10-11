package com.sunmnet.bigdata.systemManage.base.systemManage.model;

import com.sunmnet.bigdata.systemManage.base.support.model.BaseModel;

/**
 * 查询系统风格设置列表
 * @param querySystemStyleList
 * @author zfb
 * @create 2019-01-21
 * @return
 */
public class SystemImgModel extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4712105242052160102L;
	
	//图片编号
    private String imgNo;
    //图片名称
    private String imgName;
    //  图片存储地址
    private String imgUrl;
    //应用状态 WYY未应用 YYY已应用
    private String applyStatus;
    //设置位置
    private String setPosition;
	public String getImgNo() {
		return imgNo;
	}
	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	public String getSetPosition() {
		return setPosition;
	}
	public void setSetPosition(String setPosition) {
		this.setPosition = setPosition;
	}
	
    
    
}
