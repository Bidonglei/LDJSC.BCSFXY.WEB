package com.sunmnet.bigdata.web.model.entity.student;

import com.sunmnet.bigdata.common.request.BaseRequest;
import org.hibernate.validator.constraints.NotBlank;

/**
 *功能描述
 * @author lkg
 * @date 2019/4/9
 */
public class AnomalyAcademyNumRequest extends BaseRequest {

	private static final long serialVersionUID = 450081163829947512L;
    //培养层次：本科，不填表示研究生
    private String educateGradation;
    //异常类型
//    @NotBlank(message = "异常类型不能为空")
//    private String anomalyType;

	public String getEducateGradation() {
		return educateGradation;
	}

	public void setEducateGradation(String educateGradation) {
		this.educateGradation = educateGradation;
	}

//	public String getAnomalyType() {
//		return anomalyType;
//	}
//
//	public void setAnomalyType(String anomalyType) {
//		this.anomalyType = anomalyType;
//	}
}
