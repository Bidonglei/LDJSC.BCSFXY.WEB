package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * 图片应用修改图片状态
 * @param uploadImgStatus
 * @author zfb
 * @create 2019-01-21
 */
public class UploadImgStatusRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -491761036126353137L;
	
	//系统编号  唯一标识
	@NotBlank(message = "系统编号不能为空")
    private String systemNo;
    //设置位置
	@NotBlank(message = "设置位置不能为空")
    private String setPosition;
    //文件编号
	@NotBlank(message = "文件编号不能为空")
    private String imgNo;
	public String getSystemNo() {
		return systemNo;
	}
	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
	public String getSetPosition() {
		return setPosition;
	}
	public void setSetPosition(String setPosition) {
		this.setPosition = setPosition;
	}
	public String getImgNo() {
		return imgNo;
	}
	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}
    
    
    

}
