package com.sunmnet.bigdata.systemManage.service;

import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;


/**
 * @Description 公共接口
 * @author linjl
 * @date 2019/8/21
 */
public interface CommonService {

    /**
     * @Description 总搜索框接口
     * @author linjl
     * @date 2019/8/21
     */
    SystemManageResponseInfo<Object> listManageSearchBox();

    /**
     * @Description 数据配置下拉菜单
     * @author linjl
     * @date 2019/9/3
     */
    SystemManageResponseInfo<Object> listDataFieldSource(String menuOne,String menuTwo,String name, int pageNum, int pageSize);

    /**
     * @Description 用户登入接口
     * @author linjl
     * @date 2019/9/3
     */
    SystemManageResponseInfo<Object> getUserLoginInfo(String userNo,String userPassword);


}
