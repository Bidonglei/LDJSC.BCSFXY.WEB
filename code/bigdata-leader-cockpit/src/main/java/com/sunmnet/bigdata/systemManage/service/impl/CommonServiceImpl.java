package com.sunmnet.bigdata.systemManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemManageResultEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.dao.systemManage.CommonMapper;
import com.sunmnet.bigdata.systemManage.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description 公共接口
 * @author linjl
 * @date 2019/8/21
 */
@Service
public class CommonServiceImpl implements CommonService {

    private Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Autowired
    private CommonMapper commonMapper;

    @Override
    public SystemManageResponseInfo<Object> listManageSearchBox() {
        SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
        Map<String, List<Map>> result = new HashMap<>();
        List<Map> list = commonMapper.listManageSearchBox();
        List<Map> mapList = null;
        String judge = "";
        for (Map map : list) {
            //获取key对应值
            String type = (String) map.get("type");
            //判断key第一次出现
            if (judge.equals(type)) {
                map.remove("type");
                //将map装入list
                mapList.add(map);
                result.put(type,mapList);
            } else {
                //第一次不存在或第二个类型出现赋值
                judge = type;
                mapList = new ArrayList<>();
                map.remove("type");
                //将map装入list
                mapList.add(map);
                result.put(type,mapList);
            }
        }
//        result.put("SYS_GG_MENU",commonMapper.listManageMenuBox());
//        result.put("SYS_GG_TREE_MENU",commonMapper.listManageMenuTreeBox());
        result.put("SYS_GG_MENU",commonMapper.listManageMenuTreeBox());
        try {
            responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,result);
        } catch (Exception e) {
            logger.error("获取全部搜索框--异常", e);
            responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
        }
        return responseInfo;
    }

    @Override
    public SystemManageResponseInfo<Object> listDataFieldSource(String menuOne, String menuTwo, String name, int pageNum, int pageSize) {
        SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = commonMapper.listDataFieldSource(menuOne,menuTwo,name,pageNum,pageSize);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        try {
            responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,pageInfo);
        } catch (Exception e) {
            logger.error("数据配置下拉菜单--异常", e);
            responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
        }
        return responseInfo;
    }

    @Override
    public SystemManageResponseInfo<Object> getUserLoginInfo(String userNo,String userPassword) {
        SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
        Map list = commonMapper.getUserLoginInfo(userNo);
        try {
            if(null == list){
                responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_USER);
            }else if(!list.get("userStatus").equals("NORMAL")){
                responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.USER_LOCK);
            }else if(list.get("userPassword").equals(userPassword)){
                list.remove("userPassword");
                responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,list);
            }else{
                responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.ERROR_PASSWORD);
            }
        } catch (Exception e) {
            logger.error("用户登入接口--异常", e);
            responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
        }
        return responseInfo;
    }
}
