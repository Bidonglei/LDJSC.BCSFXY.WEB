package com.sunmnet.bigdata.web.mapper.home;

import java.util.List;

import com.sunmnet.bigdata.web.model.request.home.SearchREQ;
import com.sunmnet.bigdata.web.model.response.home.CommonRES;

public interface SearchMapper {

    /**
     * 搜索框信息-学院
     * <p>Title: listSearchBoxAcademy</p>
     * @return
     */
    List<CommonRES> listSearchBoxAcademy();
    /**
     * 搜索框信息-学年
     * <p>Title: listSearchBoxYear</p>
     * @return
     */
    List<CommonRES> listSearchBoxYear();
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
