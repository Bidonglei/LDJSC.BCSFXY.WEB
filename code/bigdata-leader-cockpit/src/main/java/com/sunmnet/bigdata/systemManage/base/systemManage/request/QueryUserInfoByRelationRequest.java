package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;


/**
 * 查询用户信息，根据教工号、学号查询
 * @author wm
 * @create 2018-04-10
 */
public class QueryUserInfoByRelationRequest extends BaseRequest  {
	
	private static final long serialVersionUID = -3169676089117315043L;

	@NotBlank(message = "教工号、学号不能为空")
	private String relationNo;// 教工号、学号

	public String getRelationNo() {
		return relationNo;
	}

	public void setRelationNo(String relationNo) {
		this.relationNo = relationNo;
	}
}
