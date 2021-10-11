package com.sunmnet.bigdata.web.service.personnel;

import com.sunmnet.bigdata.web.model.request.personnel.AssessInfoTypeREQ;
import com.sunmnet.bigdata.web.model.request.personnel.AssessInfoREQ;

import java.util.List;
import java.util.Map;

/**
 * @Description 人员考核
 * @author linjl
 * @date 2019/2/19
 */
public interface TrainingEvaluationService {

    /**
     * @Description 考核列表
     * @author linjl
     * @date 2019/2/19
     */
    List<Map> listAssessInfoByName(AssessInfoREQ req);
    /**
     * @Description 考核年度
     * @author linjl
     * @date 2019/2/19
     */
    List<Map<String, String>> getAssessmentTypeNum(AssessInfoTypeREQ req);

    /**
     * @Description 考核年度-下拉框
     * @author linjl
     * @date 2019/2/19
     */
    List<Map<String, List<String>>> getAssessmentDepartment();
}
