package com.sunmnet.bigdata.systemManage.dao.systemManage;

import com.sunmnet.bigdata.systemManage.base.support.request.PageDataSourceREQ;

/**
 * @Description 数据报告增加数据
 * @author linjl
 * @date 2019/5/24
 */
public interface PageDataSourceDao {

    /**
     * @Description 数据报告增加数据
     * @author linjl
     * @date 2019/5/24
     */
    int savePageDataSource(PageDataSourceREQ req);

    /**
     * @Description 数据报告排序
     * @author linjl
     * @date 2019/5/27
     */
    int getDataSortByName(PageDataSourceREQ req);
}
