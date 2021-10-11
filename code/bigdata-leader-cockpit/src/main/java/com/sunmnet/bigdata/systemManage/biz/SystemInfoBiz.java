package com.sunmnet.bigdata.systemManage.biz;

import org.springframework.web.multipart.MultipartFile;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddSystemInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteImgRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteSystemInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryColorSetListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemStyleListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SetSystemColorRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UploadImgStatusRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UploadSystemImgRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryColorSetListResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemStyleListResponse;



/**
 * 系统信息校验
 * @author wm
 * @create 2018-03-21
 */
public interface SystemInfoBiz {
	
	/**
     * 新增系统
     * @param addSystemInfoRequest
     * @author wm
     * @create 2018-03-21
     * @return
     */
	public BaseResponseInfo<Object> add(AddSystemInfoRequest addSystemInfoRequest);
	/**
     * 修改系统信息
     * @param modifySystemInfoRequest
     * @author wm
     * @create 2018-03-21
     * @return
     */
	public BaseResponseInfo<Object> modify(ModifySystemInfoRequest modifySystemInfoRequest);
	/**
     * 分页查询系统信息
     * @param queryUserInfoPageRequest
     * @author wm
     * @create 2018-03-21
     * @return
     */
	public BaseResponseInfo<PageResult> query(QuerySystemInfoPageRequest queryUserInfoPageRequest);
	/**
     * 查询系统信息下拉框选择
     * @author wm
     * @create 2018-03-23
     * @return
     */
	public BaseResponseInfo<QuerySystemDropdownResponse> querySystemDropdown();
	/**
     * 查询具体系统信息
     * @author wm
     * @create 2018-03-23
     * @return
     */
	public BaseResponseInfo<QuerySystemInfoResponse> querySystemInfo(QuerySystemInfoRequest querySystemInfoRequest);
	/**
     * 删除系统信息
     * @param deleteSystemInfoRequest
     * @author wm
     * @create 2018-03-30
     * @return
     */
	public BaseResponseInfo<Object> deleteSystemInfo(DeleteSystemInfoRequest deleteSystemInfoRequest);
	/**
     * 系统风格图片上传
     * @param uploadTargetStandardFile
     * @author zfb
     * @create 2019-01-21
     */
	public BaseResponseInfo<Object> uploadSystemImg(
			UploadSystemImgRequest uploadSystemImgRequest, MultipartFile file);
	/**
     * 图片应用修改图片状态
     * @param uploadImgStatus
     * @author zfb
     * @create 2019-01-21
     */
	public BaseResponseInfo<Object> uploadImgStatus(
			UploadImgStatusRequest uploadImgStatusRequest);
	
	/**
     * 删除图片
     * @param deleteImg
     * @author zfb
     * @create 2019-01-21
     */
	public BaseResponseInfo<Object> deleteImg(DeleteImgRequest deleteImgRequest);
	
	/**
     * 查询系统风格设置列表
     * @param querySystemStyleList
     * @author zfb
     * @create 2019-01-21
     * @return
     */
	public BaseResponseInfo<QuerySystemStyleListResponse> querySystemStyleList(
			QuerySystemStyleListRequest querySystemStyleListRequest);
	/**
     * 设置颜色
     * @param setSystemColor
     * @author zfb
     * @create 2019-01-21
     */
	public BaseResponseInfo<Object> setSystemColor(
			SetSystemColorRequest setSystemColorRequest);
	/**
     * 查询颜色设置列表
     * @param queryColorSetList
     * @author zfb
     * @create 2019-01-21
     * @return
     */
	public BaseResponseInfo<QueryColorSetListResponse> queryColorSetList(
			QueryColorSetListRequest queryColorSetListRequest);
	
}
