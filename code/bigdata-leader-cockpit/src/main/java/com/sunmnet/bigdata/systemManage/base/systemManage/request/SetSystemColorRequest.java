package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * 设置颜色
 * @param setSystemColor
 * @author zfb
 * @create 2019-01-21
 */
public class SetSystemColorRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1494908605998880468L;
	
	@NotBlank(message = "系统编号不能为空")	
    private String systemNo; //系统编号  唯一标识
	
	@NotBlank(message = "设置位置不能为空")
    private String setPosition; //设置位置
	
	@NotBlank(message = "颜色不能为空")
    private String colorName;

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

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	
	

}
