package com.sunmnet.bigdata.systemManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDictPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UpdateDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDictInfoResponse;
import com.sunmnet.bigdata.systemManage.biz.DictInfoBiz;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;

/**
 * 字典管理
 * @author fr
 * @create 2018-09-17
 */
@RestController
@RequestMapping("/manage/dictInfo")
public class DictInfoController extends BaseController {
	@Autowired
	private DictInfoBiz dictInfoBiz;
	
	/**
     * 分页查询数据字典列表
     * @param queryDictPageRequest
     * @author zfb
     * @create 2018-09-17
     * @return
     */	
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryDictPageRequest")
	@LoggerManage(description = "分页查询数据字典列表")
	public BaseResponseInfo<PageResult> queryDictPageRequest(@Validated  QueryDictPageRequest queryDictPageRequest ,BindingResult bindingResult){
		
		BaseResponseInfo<PageResult> responseInfo = new BaseResponseInfo<>();
		try {
			responseInfo = dictInfoBiz.queryDictPageRequest(queryDictPageRequest);
		} catch (Exception e) {
			logger.error("分页查询数据字典列表--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}
	/**
     * 新增字典
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/addDictInfo")
    @LoggerManage(description = "新增字典")
    public BaseResponseInfo<Object> addDictInfo(@Validated  AddDictInfoRequest addDictInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = dictInfoBiz.addDictInfo(addDictInfoRequest);
		} catch (Exception e) {
			logger.error("新增字典--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 修改字典
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/updateDictInfo")
    @LoggerManage(description = "修改字典")
    public BaseResponseInfo<Object> updateDictInfo(@Validated  UpdateDictInfoRequest updateDictInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = dictInfoBiz.updateDictInfo(updateDictInfoRequest);
		} catch (Exception e) {
			logger.error("修改字典--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	/**
     * 删除字典信息
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteDictInfo")
    @LoggerManage(description = "删除字典信息")
    public BaseResponseInfo<Object> deleteDictInfo(@Validated  DeleteDictInfoRequest deleteDictInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = dictInfoBiz.deleteDictInfo(deleteDictInfoRequest);
		} catch (Exception e) {
			logger.error("删除字典信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 查看字典详情
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryDictInfo")
    @LoggerManage(description = "查看字典详情")
    public BaseResponseInfo<QueryDictInfoResponse> queryDictInfo(@Validated  QueryDictInfoRequest queryDictInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<QueryDictInfoResponse> responseInfo = new BaseResponseInfo<QueryDictInfoResponse>();
		try {
			responseInfo = dictInfoBiz.queryDictInfo(queryDictInfoRequest);
		} catch (Exception e) {
			logger.error("查看字典详情--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
}
