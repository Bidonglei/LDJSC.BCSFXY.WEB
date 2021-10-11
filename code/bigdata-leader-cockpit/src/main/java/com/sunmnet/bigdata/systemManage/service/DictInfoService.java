package com.sunmnet.bigdata.systemManage.service;

import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDictPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UpdateDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDictInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.web.model.request.home.OpinionInfoREQ;


/**
 * 字典管理
 * @author fr
 * @create 2018-09-17
 */
public interface DictInfoService {

	/**
     * 分页查询数据字典列表
     * @param queryDictPageRequest
     * @author zfb
     * @create 2018-09-17
     * @return
     */	
	SystemManageResponseInfo<PageResult> queryDictPageRequest(
			QueryDictPageRequest queryDictPageRequest);
	
	/**
     * 新增字典
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	SystemManageResponseInfo<Object> addDictInfo(
			AddDictInfoRequest addDictInfoRequest);
	
	/**
     * 修改字典
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	SystemManageResponseInfo<Object> updateDictInfo(
			UpdateDictInfoRequest updateDictInfoRequest);
	/**
     * 删除字典信息
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	SystemManageResponseInfo<Object> deleteDictInfo(
			DeleteDictInfoRequest deleteDictInfoRequest);
	/**
     * 查看字典详情
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	SystemManageResponseInfo<QueryDictInfoResponse> queryDictInfo(
			QueryDictInfoRequest queryDictInfoRequest);

	/**
	 * @Description 数据报告增加数据
	 * @author linjl
	 * @date 2019/5/24
	 */
	int savePageDataSource(OpinionInfoREQ req);
}
