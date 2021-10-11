package com.sunmnet.bigdata.systemManage.controller;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddIndexInfoRequest;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;
import com.sunmnet.bigdata.systemManage.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 公共接口
 * @author linjl
 * @date 2019/8/21
 */
@Api(tags="公共接口")
@RestController
@RequestMapping("/manage/common")
public class CommonController extends BaseController{

    @Autowired
    private CommonService commonService;

    @ApiOperation(value = "管理端搜索框接口")
    @SuppressWarnings("unchecked")
    @RequestMapping("/listManageSearchBox")
    @LoggerManage(description = "管理端搜索框接口")
    public BaseResponseInfo<Object> listManageSearchBox() {
        BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
        try {
            responseInfo = commonService.listManageSearchBox();
        } catch (Exception e) {
            logger.error("管理端搜索框接口--异常",e);
            return SystemManageException.exception();
        }
        return responseInfo;
    }

    @ApiOperation(value = "数据配置接口")
    @SuppressWarnings("unchecked")
    @RequestMapping("/listDataFieldSource")
    @LoggerManage(description = "数据配置接口")
    public BaseResponseInfo<Object> listDataFieldSource(String menuOne,String menuTwo,String name, int pageNum, int pageSize) {
        BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
        try {
            responseInfo = commonService.listDataFieldSource(menuOne,menuTwo,name,pageNum,pageSize);
        } catch (Exception e) {
            logger.error("数据配置接口--异常",e);
            return SystemManageException.exception();
        }
        return responseInfo;
    }

    @ApiOperation(value = "用户登入接口")
    @SuppressWarnings("unchecked")
    @RequestMapping("/getUserLoginInfo")
    @LoggerManage(description = "用户登入接口")
    public BaseResponseInfo<Object> getUserLoginInfo(String userNo,String userPassword) {
        BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
        try {
            responseInfo = commonService.getUserLoginInfo(userNo,userPassword);
        } catch (Exception e) {
            logger.error("用户登入接口--异常",e);
            return SystemManageException.exception();
        }
        return responseInfo;
    }

    @ApiOperation(value = "用户注销")
    @SuppressWarnings("unchecked")
    @RequestMapping("/logout")
    @LoggerManage(description = "用户注销")
    public BaseResponseInfo<Object> logout() {
        BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
        try {
            responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
        } catch (Exception e) {
            logger.error("用户注销--异常",e);
            return SystemManageException.exception();
        }
        return responseInfo;
    }
}
