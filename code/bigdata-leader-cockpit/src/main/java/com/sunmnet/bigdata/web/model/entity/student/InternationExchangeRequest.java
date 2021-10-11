package com.sunmnet.bigdata.web.model.entity.student;

import com.sunmnet.bigdata.common.request.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 *功能描述
 * @author lkg
 * @date 2019/4/9
 */
public class InternationExchangeRequest extends BaseRequest {

	private static final long serialVersionUID = 450081163829947512L;

//    @NotBlank(message = "年度不能为空")
	@ApiModelProperty(value="年度")
    private String annual;//年度
	@ApiModelProperty(value="培养层次(本科生/硕士生/博士生)")
	private String educateGradation;//培养层次(本科生/硕士生/博士生)
	@ApiModelProperty(value="培养层次(本科生/硕士生/博士生)")
	private String projectType;//项目类型：短期项目，交换项目，学位项目

	public String getAnnual() {
		return annual;
	}

	public void setAnnual(String annual) {
		this.annual = annual;
	}

	public String getEducateGradation() {
		return educateGradation;
	}

	public void setEducateGradation(String educateGradation) {
		this.educateGradation = educateGradation;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
}
