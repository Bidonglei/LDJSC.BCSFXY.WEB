package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 *功能描述
 * @author lkg
 * @date 2019/8/29
 */
public class UpdateDataSourceRequest extends BaseRequest {
	
	private static final long serialVersionUID = -2276989691055558586L;

	@NotNull(message = "主键ID不能为空")
	@ApiModelProperty("主键ID")
    private Long id; //系统编号  唯一标识

	@NotBlank(message = "统计图名称不能为空")
	@ApiModelProperty("统计图名称")
	private String chartName;

	@NotBlank(message = "数据类型不能为空")
	@ApiModelProperty("数据类型")
	private String dataType;

	@NotBlank(message = "数据同步时间不能为空")
	@ApiModelProperty("数据同步时间")
	private String dataSynchronize;

	@ApiModelProperty("数据问题")
	private String dataQuestion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataSynchronize() {
		return dataSynchronize;
	}

	public void setDataSynchronize(String dataSynchronize) {
		this.dataSynchronize = dataSynchronize;
	}

	public String getDataQuestion() {
		return dataQuestion;
	}

	public void setDataQuestion(String dataQuestion) {
		this.dataQuestion = dataQuestion;
	}
}
