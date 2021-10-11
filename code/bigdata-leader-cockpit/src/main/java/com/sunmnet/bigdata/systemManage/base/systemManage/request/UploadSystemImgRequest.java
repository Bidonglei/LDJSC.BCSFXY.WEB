package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * 系统风格图片上传
 * @param uploadTargetStandardFile
 * @author zfb
 * @create 2019-01-21
 */
public class UploadSystemImgRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8305675301710702662L;
	
	@NotBlank(message = "系统编号不能为空")
    private String systemNo;//系统编号
	
	@NotBlank(message = "设置位置不能为空")
    private String setPosition;//设置位置

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
	
	

}
