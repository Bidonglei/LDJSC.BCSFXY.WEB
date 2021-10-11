package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import org.hibernate.validator.constraints.NotBlank;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;

/**
 * 请求参数必须加isPublic固定值YES
 *（此字段为后台权限验证使用，值为YES为公共接口不进行权限校验）
 * @author tkk
 * 2018-06-25
 *
 */
public class IsPublicRequest extends BaseRequest{
	private static final long serialVersionUID = 4935282751188585753L;
	@NotBlank(message = "isPublic为固定值YES,不能为空，用于后台权限验证使用")
	private String isPublic;

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	
}
