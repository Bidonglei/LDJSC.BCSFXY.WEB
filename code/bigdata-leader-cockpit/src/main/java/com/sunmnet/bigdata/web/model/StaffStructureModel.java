package com.sunmnet.bigdata.web.model;

import com.sunmnet.bigdata.common.model.BaseModel;

/**
 * @Description
 * @author
 * @date
 * @version
 */
public class StaffStructureModel extends BaseModel {

	private static final long serialVersionUID = 6463268215029165092L;

	//编制小类型
    private String name;
	//人数
    private String num;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
}
