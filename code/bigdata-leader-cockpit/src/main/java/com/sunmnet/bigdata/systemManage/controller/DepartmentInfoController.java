package com.sunmnet.bigdata.systemManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddDepartmentInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteDepartmentInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyDepartmentInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyDepartmentStatusRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDepartmentInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDepartmentInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDepartmentDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDepartmentInfoResponse;
import com.sunmnet.bigdata.systemManage.biz.DepartmentInfoBiz;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;

/**
 * 部门信息
 * @author wm
 * @create 2018-03-23
 */
@RestController
@RequestMapping("/manage/department")
public class DepartmentInfoController extends BaseController {
	@Autowired
	private DepartmentInfoBiz departmentInfoBiz;
	
	
	/**
     * 部门信息下拉框选择
     * @author wm
     * @create 2018-03-23
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryDepartmentDropdown")
    @LoggerManage(description = "查询部门信息下拉框选择")
    public BaseResponseInfo<QueryDepartmentDropdownResponse> queryDepartmentDropdown() {
		
		BaseResponseInfo<QueryDepartmentDropdownResponse> responseInfo = new BaseResponseInfo<QueryDepartmentDropdownResponse>();
		try {
			responseInfo = departmentInfoBiz.queryDepartmentDropdown();
		} catch (Exception e) {
			logger.error("查询部门信息下拉框选择--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 分页查询部门信息
     * @param queryDepartmentInfoPageRequest
     * @author wth
     * @create 2018-03-27
     * @return
     */
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/query")
	@LoggerManage(description = "分页查询部门信息")
	public BaseResponseInfo<PageResult> query(@Validated  QueryDepartmentInfoPageRequest queryDepartmentInfoPageRequest ,BindingResult bindingResult){
		
		BaseResponseInfo<PageResult> responseInfo = new BaseResponseInfo<>();
		try {
			responseInfo = departmentInfoBiz.query(queryDepartmentInfoPageRequest);
		} catch (Exception e) {
			logger.error("分页查询部门信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}
	
	/**
     * 新增部门
     * @param addDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/addDepartment")
    @LoggerManage(description = "新增部门")
    public BaseResponseInfo<Object> add(@Validated  AddDepartmentInfoRequest addDepartmentInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = departmentInfoBiz.add(addDepartmentInfoRequest);
		} catch (Exception e) {
			logger.error("新增部门--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 删除部门信息
     * @param deleteDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteDepartmentInfo")
    @LoggerManage(description = "删除部门信息")
    public BaseResponseInfo<Object> deleteDepartmentInfo(@Validated  DeleteDepartmentInfoRequest deleteDepartmentInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = departmentInfoBiz.deleteDepartmentInfo(deleteDepartmentInfoRequest);
		} catch (Exception e) {
			logger.error("删除部门信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 修改部门状态
     * @param modifyDepartmentStatusRequest
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/modifyDepartmentStatus")
    @LoggerManage(description = "修改部门状态")
    public BaseResponseInfo<Object> modifyDepartmentStatus(@Validated  ModifyDepartmentStatusRequest modifyDepartmentStatusRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = departmentInfoBiz.modifyDepartmentStatus(modifyDepartmentStatusRequest);
		} catch (Exception e) {
			logger.error("修改部门状态--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 查看部门详情
     * @param queryDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryDepartmentInfo")
    @LoggerManage(description = "查看部门详情")
    public BaseResponseInfo<QueryDepartmentInfoResponse> queryUserInfo(@Validated  QueryDepartmentInfoRequest queryDepartmentInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<QueryDepartmentInfoResponse> responseInfo = new BaseResponseInfo<QueryDepartmentInfoResponse>();
		try {
			responseInfo = departmentInfoBiz.queryDepartmentInfo(queryDepartmentInfoRequest);
		} catch (Exception e) {
			logger.error("查看部门详情--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 修改部门信息
     * @param modifyDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-09
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/modifyDepartmentInfo")
    @LoggerManage(description = "修改部门信息")
    public BaseResponseInfo<Object> modifyDepartmentInfo(@Validated  ModifyDepartmentInfoRequest modifyDepartmentInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = departmentInfoBiz.modifyDepartmentInfo(modifyDepartmentInfoRequest);
		} catch (Exception e) {
			logger.error("修改部门信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 同步教职工部门信息
     * @param 
     * @author wm
     * @create 2018-06-28
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/generationDepartmentInfoTeacher")
    @LoggerManage(description = "同步教职工部门信息")
    public BaseResponseInfo<Object> generationDepartmentInfoTeacher() {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = departmentInfoBiz.generationDepartmentInfoTeacher();
		} catch (Exception e) {
			logger.error("同步教职工部门信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	
	
}
