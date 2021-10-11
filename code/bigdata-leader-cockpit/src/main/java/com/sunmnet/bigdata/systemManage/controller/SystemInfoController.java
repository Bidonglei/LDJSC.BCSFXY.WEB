package com.sunmnet.bigdata.systemManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.sunmnet.bigdata.systemManage.biz.SystemInfoBiz;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;

/**
 * 系统信息
 * @author wm
 * @create 2018-03-21
 */
@Controller
@RequestMapping("/manage/system")
public class SystemInfoController extends BaseController {
	@Autowired
	private SystemInfoBiz systemInfoBiz;
	
	@RequestMapping("/upload")
	 public String upload() {
	    return "upload";
	 }
	
	/**
     * 新增系统
     * @param addSystemInfoRequest
     * @author wm
     * @create 2018-03-21
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/add")
    @LoggerManage(description = "新增系统")	
	@ResponseBody
    public BaseResponseInfo<Object> add(@Validated  AddSystemInfoRequest addSystemInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemInfoBiz.add(addSystemInfoRequest);
		} catch (Exception e) {
			logger.error("新增系统--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	/**
     * 修改系统信息
     * @param addSystemInfoRequest
     * @author wm
     * @create 2018-03-21
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/modify")
    @LoggerManage(description = "修改系统信息")
	@ResponseBody
    public BaseResponseInfo<Object> modify(@Validated  ModifySystemInfoRequest modifySystemInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemInfoBiz.modify(modifySystemInfoRequest);
		} catch (Exception e) {
			logger.error("修改系统信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 分页查询系统信息
     * @param queryUserInfoPageRequest
     * @author wm
     * @create 2018-03-21
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/query")
    @LoggerManage(description = "分页查询系统信息")
	@ResponseBody
    public BaseResponseInfo<PageResult> query(@Validated  QuerySystemInfoPageRequest queryUserInfoPageRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<PageResult> responseInfo = new BaseResponseInfo<PageResult>();
		try {
			responseInfo = systemInfoBiz.query(queryUserInfoPageRequest);
		} catch (Exception e) {
			logger.error("分页查询系统信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	/**
     * 查询系统信息下拉框选择
     * @author wm
     * @create 2018-03-23
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/querySystemDropdown")
    @LoggerManage(description = "查询系统信息下拉框选择")
	@ResponseBody
    public BaseResponseInfo<QuerySystemDropdownResponse> querySystemDropdown( ) {
		
		BaseResponseInfo<QuerySystemDropdownResponse> responseInfo = new BaseResponseInfo<QuerySystemDropdownResponse>();
		try {
			responseInfo = systemInfoBiz.querySystemDropdown();
		} catch (Exception e) {
			logger.error("查询系统信息下拉框选择--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	/**
     * 查询具体系统信息
     * @param querySystemInfoRequest
     * @author wm
     * @create 2018-03-23
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/querySystemInfo")
    @LoggerManage(description = "查询具体系统信息")
	@ResponseBody
    public BaseResponseInfo<QuerySystemInfoResponse> querySystemInfo(@Validated  QuerySystemInfoRequest querySystemInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<QuerySystemInfoResponse> responseInfo = new BaseResponseInfo<QuerySystemInfoResponse>();
		try {
			responseInfo = systemInfoBiz.querySystemInfo(querySystemInfoRequest);
		} catch (Exception e) {
			logger.error("查询具体系统信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 删除系统信息
     * @param deleteSystemInfoRequest
     * @author wm
     * @create 2018-03-30
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteSystemInfo")
    @LoggerManage(description = "删除系统信息")
	@ResponseBody
    public BaseResponseInfo<Object> deleteSystemInfo(@Validated  DeleteSystemInfoRequest deleteSystemInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemInfoBiz.deleteSystemInfo(deleteSystemInfoRequest);
		} catch (Exception e) {
			logger.error("删除系统信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 系统风格图片上传
     * @param uploadSystemImgRequest
     * @author zfb
     * @create 2019-01-21
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/uploadSystemImg")
    @LoggerManage(description = "系统风格图片上传")
	@ResponseBody
    public BaseResponseInfo<Object> uploadSystemImg(@Validated  UploadSystemImgRequest uploadSystemImgRequest ,BindingResult bindingResult,
    		@RequestParam("file") MultipartFile file) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemInfoBiz.uploadSystemImg(uploadSystemImgRequest, file);
		} catch (Exception e) {
			logger.error("系统风格图片上传--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 图片应用修改图片状态
     * @param uploadImgStatus
     * @author zfb
     * @create 2019-01-21
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/uploadImgStatus")
    @LoggerManage(description = "图片应用修改图片状态")
	@ResponseBody
    public BaseResponseInfo<Object> uploadImgStatus(@Validated  UploadImgStatusRequest uploadImgStatusRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemInfoBiz.uploadImgStatus(uploadImgStatusRequest);
		} catch (Exception e) {
			logger.error("图片应用修改图片状态--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 删除图片
     * @param deleteImg
     * @author zfb
     * @create 2019-01-21
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteImg")
    @LoggerManage(description = "删除图片")
	@ResponseBody
    public BaseResponseInfo<Object> deleteImg(@Validated  DeleteImgRequest deleteImgRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemInfoBiz.deleteImg(deleteImgRequest);
		} catch (Exception e) {
			logger.error("删除图片--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 查询系统风格设置列表
     * @param querySystemStyleList
     * @author zfb
     * @create 2019-01-21
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/querySystemStyleList")
    @LoggerManage(description = "查询系统风格设置列表")
	@ResponseBody
    public BaseResponseInfo<QuerySystemStyleListResponse> querySystemStyleList(@Validated  QuerySystemStyleListRequest querySystemStyleListRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<QuerySystemStyleListResponse> responseInfo = new BaseResponseInfo<QuerySystemStyleListResponse>();
		try {
			responseInfo = systemInfoBiz.querySystemStyleList(querySystemStyleListRequest);
		} catch (Exception e) {
			logger.error("查询系统风格设置列表--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 设置颜色
     * @param setSystemColor
     * @author zfb
     * @create 2019-01-21
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/setSystemColor")
    @LoggerManage(description = "设置颜色")
	@ResponseBody
    public BaseResponseInfo<Object> setSystemColor(@Validated  SetSystemColorRequest setSystemColorRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemInfoBiz.setSystemColor(setSystemColorRequest);
		} catch (Exception e) {
			logger.error("设置颜色--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 查询颜色设置列表
     * @param queryColorSetList
     * @author zfb
     * @create 2019-01-21
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryColorSetList")
    @LoggerManage(description = "查询颜色设置列表")
	@ResponseBody
    public BaseResponseInfo<QueryColorSetListResponse> queryColorSetList(@Validated  QueryColorSetListRequest queryColorSetListRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<QueryColorSetListResponse> responseInfo = new BaseResponseInfo<QueryColorSetListResponse>();
		try {
			responseInfo = systemInfoBiz.queryColorSetList(queryColorSetListRequest);
		} catch (Exception e) {
			logger.error("查询颜色设置列表--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
}
