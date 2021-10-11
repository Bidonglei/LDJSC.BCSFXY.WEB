package com.sunmnet.bigdata.systemManage.dao.systemManage;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommonMapper {

    /**
     * @Description 总搜索框接口
     * @author linjl
     * @date 2019/8/21
     */
    List<Map> listManageSearchBox();
    /**
     * @Description 下拉菜单一二级搜索框
     * @author linjl
     * @date 2019/8/21
     */
    List<Map> listManageMenuBox();
    /**
     *功能描述 菜单一二级树状
     * @author lkg
     * @date 2019/8/28
     */
    List<Map> listManageMenuTreeBox();
    /**
     * @Description 数据配置下拉菜单
     * @author linjl
     * @date 2019/9/3
     */
    List<Map> listDataFieldSource(@Param("menuOne") String menuOne,@Param("menuTwo") String menuTwo,@Param("name") String name, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    /**
     * @Description 用户登入接口
     * @author linjl
     * @date 2019/9/24
     */
    Map getUserLoginInfo(@Param("userNo") String userNo);
}
