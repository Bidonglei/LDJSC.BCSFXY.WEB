package com.sunmnet.bigdata.web.mapper.home;

import java.util.List;
import java.util.Map;

public interface HomeMapper {
    /**
     * @Description 首页大屏指标接口
     * @author linjl
     * @date 2019/8/2
     */
    List<Map<String, Object>> listIndexHomePage();
}
