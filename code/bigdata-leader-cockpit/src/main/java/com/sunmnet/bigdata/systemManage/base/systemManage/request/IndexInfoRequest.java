package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.RelationTypeEnum;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author Administrator
 *
 */
public class IndexInfoRequest extends BaseRequest {
	
	private static final long serialVersionUID = -2276989691055558586L;
	@NotBlank(message = "页面组件唯一标识")
    private String pageCode; //系统编号  唯一标识

    private String indexDate;//日期

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getIndexDate() {
		return indexDate;
	}

	public void setIndexDate(String indexDate) {
		this.indexDate = indexDate;
	}
}
