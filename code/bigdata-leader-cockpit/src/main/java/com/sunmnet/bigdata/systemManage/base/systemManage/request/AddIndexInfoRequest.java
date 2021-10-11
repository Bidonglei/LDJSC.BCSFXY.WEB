package com.sunmnet.bigdata.systemManage.base.systemManage.request;

import com.sunmnet.bigdata.systemManage.base.support.request.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Administrator
 *
 */
@ApiModel(value="指标新增表")
public class AddIndexInfoRequest extends BaseRequest {
	
	private static final long serialVersionUID = -2276989691055558586L;

	@ApiModelProperty(value="指标名称")
	@NotBlank(message = "指标名称不能为空")
    private String indexName; //指标名称

	@ApiModelProperty(value="指标编号", hidden = true)
    private String indexCode; //指标编号

//	@ApiModelProperty(value="指标值", hidden = true)
    private String indexValue; //指标名称

	@ApiModelProperty(value="指标对应单位")
    private String indexUnit; //指标名称

	@ApiModelProperty(value="指标详细描述", hidden = true)
    private String indexDescription; //指标名称

	@ApiModelProperty(value="所属大类(学生,人事等)")
    private String indexType; //指标名称

	@ApiModelProperty(value="创建时间", hidden = true)
    private String createTime; //指标名称

	public String getIndexCode() {
		return indexCode;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getIndexValue() {
		return indexValue;
	}

	public void setIndexValue(String indexValue) {
		this.indexValue = indexValue;
	}

	public String getIndexUnit() {
		return indexUnit;
	}

	public void setIndexUnit(String indexUnit) {
		this.indexUnit = indexUnit;
	}

	public String getIndexDescription() {
		return indexDescription;
	}

	public void setIndexDescription(String indexDescription) {
		this.indexDescription = indexDescription;
	}

	public String getIndexType() {
		return indexType;
	}

	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
