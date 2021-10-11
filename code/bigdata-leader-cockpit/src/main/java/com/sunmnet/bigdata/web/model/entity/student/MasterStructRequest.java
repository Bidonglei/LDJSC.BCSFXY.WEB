package com.sunmnet.bigdata.web.model.entity.student;

import com.sunmnet.bigdata.common.request.BaseRequest;
import org.hibernate.validator.constraints.NotBlank;

/**
 *功能描述
 * @author lkg
 * @date 2019/4/9
 */
public class MasterStructRequest extends BaseRequest {

	private static final long serialVersionUID = 450081163829947512L;
    //培养层次
    @NotBlank(message = "培养层次不能为空")
    private String educateGradation;
    //
    private String type;//类型：XK 学科结构，ZY 专业结构

	public String getEducateGradation() {
		return educateGradation;
	}

	public void setEducateGradation(String educateGradation) {
		this.educateGradation = educateGradation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
