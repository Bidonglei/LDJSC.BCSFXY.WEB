package com.sunmnet.bigdata.systemManage.biz;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDictPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UpdateDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDictInfoResponse;




/**
 * 字典管理
 * @author fr
 * @create 2018-09-17
 */
public interface DictInfoBiz {

	/**
     * 分页查询数据字典列表
     * @param queryDictPageRequest
     * @author zfb
     * @create 2018-09-17
     * @return
     */	
	BaseResponseInfo<PageResult> queryDictPageRequest(
			QueryDictPageRequest queryDictPageRequest);
	/**
     * 新增字典
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	BaseResponseInfo<Object> addDictInfo(AddDictInfoRequest addDictInfoRequest);
	/**
     * 修改字典
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	BaseResponseInfo<Object> updateDictInfo(
			UpdateDictInfoRequest updateDictInfoRequest);
	/**
     * 删除字典信息
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	BaseResponseInfo<Object> deleteDictInfo(
			DeleteDictInfoRequest deleteDictInfoRequest);
	
	/**
     * 查看字典详情
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	BaseResponseInfo<QueryDictInfoResponse> queryDictInfo(
			QueryDictInfoRequest queryDictInfoRequest);
}
