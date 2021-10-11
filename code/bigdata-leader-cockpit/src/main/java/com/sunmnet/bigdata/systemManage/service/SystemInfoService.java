package com.sunmnet.bigdata.systemManage.service;

import org.springframework.web.multipart.MultipartFile;

import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemStyleEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddSystemInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryColorSetListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemStyleListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SetSystemColorRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UploadSystemImgRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryColorSetListResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemStyleListResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;



/**
 * 系统信息
 * @author wm
 * @create 2018-03-21
 */
public interface SystemInfoService {
	/**
     * 新增系统
     * @param addSystemInfoRequest
     * @author wm
     * @create 2018-03-21
     * @return
     */
	public SystemManageResponseInfo<Object> add(AddSystemInfoRequest addSystemInfoRequest);
	/**
     * 修改系统信息
     * @param modifySystemInfoRequest
     * @param sunmnetSystemInfoEntity
     * @author wm
     * @create 2018-03-21
     * @return
     */
	public SystemManageResponseInfo<Object> modify(ModifySystemInfoRequest modifySystemInfoRequest,
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity);
	/**
     * 分页查询系统信息
     * @param queryUserInfoPageRequest
     * @author wm
     * @create 2018-03-21
     * @return
     */
	public SystemManageResponseInfo<PageResult> query(QuerySystemInfoPageRequest queryUserInfoPageRequest);
	/**
     * 查询系统信息下拉框选择
     * @author wm
     * @create 2018-03-23
     * @return
     */
	public SystemManageResponseInfo<QuerySystemDropdownResponse> querySystemDropdown();
	/**
     * 查询具体系统信息
     * @author wm
     * @create 2018-03-23
     * @return
     */
	public SystemManageResponseInfo<QuerySystemInfoResponse> querySystemInfo(SunmnetSystemInfoEntity sunmnetSystemInfoEntity);
	/**
     * 删除系统信息
     * @param deleteSystemInfoRequest
     * @author wm
     * @create 2018-03-30
     * @return
     */
	public SystemManageResponseInfo<Object> deleteSystemInfo(String systemNo);
	/**
     * 系统风格图片上传
     * @param uploadTargetStandardFile
     * @author zfb
     * @create 2019-01-21
     */
	public SystemManageResponseInfo<Object> uploadSystemImg(
			UploadSystemImgRequest uploadSystemImgRequest, MultipartFile file);
	/**
     * 图片应用修改图片状态
     * @param uploadImgStatus
     * @author zfb
     * @create 2019-01-21
     */
	public SystemManageResponseInfo<Object> uploadImgStatus(
			SunmnetSystemStyleEntity styleEntity);
	/**
     * 删除图片
     * @param deleteImg
     * @author zfb
     * @create 2019-01-21
     */
	public SystemManageResponseInfo<Object> deleteImg(
			SunmnetSystemStyleEntity styleEntity);
	
	/**
     * 查询系统风格设置列表
     * @param querySystemStyleList
     * @author zfb
     * @create 2019-01-21
     * @return
     */
	public SystemManageResponseInfo<QuerySystemStyleListResponse> querySystemStyleList(
			QuerySystemStyleListRequest querySystemStyleListRequest);
	/**
     * 设置颜色
     * @param setSystemColor
     * @author zfb
     * @create 2019-01-21
     */
	public SystemManageResponseInfo<Object> setSystemColor(
			SetSystemColorRequest setSystemColorRequest);
	/**
     * 查询颜色设置列表
     * @param queryColorSetList
     * @author zfb
     * @create 2019-01-21
     * @return
     */
	public SystemManageResponseInfo<QueryColorSetListResponse> queryColorSetList(
			QueryColorSetListRequest queryColorSetListRequest);
	
}
