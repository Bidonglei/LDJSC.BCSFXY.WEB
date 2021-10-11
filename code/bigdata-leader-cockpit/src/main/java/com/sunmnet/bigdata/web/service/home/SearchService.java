package com.sunmnet.bigdata.web.service.home;

import java.util.List;
import java.util.Map;

import com.sunmnet.bigdata.web.model.request.home.SearchREQ;
import com.sunmnet.bigdata.web.model.response.home.CommonRES;
/**
 * 搜索框信息
 * <p>Title: SearchService</p>
 * @author linjianlin  
 * @date 2018年9月7日
 */
public interface SearchService {

    /**
     * 搜索框信息
     * <p>Title: listSearchBox</p>
     * @return
     */
    Map<String,Object> listSearchBox();
    /**
     * 搜索框信息-专业
     * <p>Title: listSearchBoxMajor</p>
     * @param searchREQ
     * @return
     */
    List<CommonRES> listSearchBoxMajor(SearchREQ searchREQ);
    /**
     * 搜索框信息-班级
     * <p>Title: listSearchBoxClass</p>
     * @param searchREQ
     * @return
     */
    List<CommonRES> listSearchBoxClass(SearchREQ searchREQ);
}
