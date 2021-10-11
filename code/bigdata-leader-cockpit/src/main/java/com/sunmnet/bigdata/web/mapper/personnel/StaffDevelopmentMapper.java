package com.sunmnet.bigdata.web.mapper.personnel;

import com.sunmnet.bigdata.web.model.request.personnel.AssessInfoREQ;
import com.sunmnet.bigdata.web.model.request.personnel.AssessInfoTypeREQ;
import com.sunmnet.bigdata.web.model.request.personnel.StaffDevelopmentREQ;

import java.util.List;
import java.util.Map;

/**
 * @Description 人员发展
 * @author linjl
 * @date 2019/2/19
 */
public interface StaffDevelopmentMapper {

    /**
     * @Description 国际交流地图
     * @author linjl
     * @date 2019/2/21
     */
    List<Map<String, String>> listInternationalCountry(StaffDevelopmentREQ req);

    /**
     * @Description 国际交流-4个数据
     * @author linjl
     * @date 2019/2/21
     */
    Map<String, String> getInternationalFourNum(StaffDevelopmentREQ req);
    /**
     * @Description 国际交流-下拉框
     * @author linjl
     * @date 2019/2/21
     */
    List<Map<String, String>> getInternationalBox(String dictType);
    /**
     * @Description 学术交流目的国家
     * @author linjl
     * @date 2019/2/20
     */
    List<Map<String, String>> listCountryNameNumber(String abroadYear);

    /**
     * @Description 学术交流学院参与人数
     * @author linjl
     * @date 2019/2/20
     */
    List<Map<String, String>> listAcademyNameNumber(String abroadYear);

}
