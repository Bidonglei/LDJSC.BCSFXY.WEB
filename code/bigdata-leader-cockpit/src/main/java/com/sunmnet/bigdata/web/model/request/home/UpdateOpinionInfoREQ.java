package com.sunmnet.bigdata.web.model.request.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@ApiModel(value = "UpdateOpinionInfoREQ")
public class UpdateOpinionInfoREQ {


    @ApiModelProperty("主键id")
	@NotBlank(message="主键id不能为空")
    private String id;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("重要程度")
    private String importance;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}
}
