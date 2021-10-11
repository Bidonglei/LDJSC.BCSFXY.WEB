package com.sunmnet.bigdata.systemManage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddMenuFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddMenuRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteMenuInfoOrFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.MenuSortRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyMenuFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyMenuInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryAdminRoleMenuRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMenuDownDropdownRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMenuDropdownRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMenuInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRoleMenuInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMenuDownDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMenuDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMenuInfoByMenuNoResonse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMenuInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRoleMenuInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemMenuInfoResponse;
import com.sunmnet.bigdata.systemManage.biz.MenuInfoBiz;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;

/**
 * 菜单信息
 * @author wm
 * @create 2018-03-30
 */
@Api(tags="菜单管理")
@RestController
@RequestMapping("/manage/menu")
public class MenuInfoController extends BaseController{
	
	@Autowired
	private MenuInfoBiz menuInfoBiz;
	
	/**
     * 查询管理系统菜单列表，管理员有的角色标注
     * @param querySystemMenuInfoRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/querySystemMenuInfo")
    @LoggerManage(description = "查询管理系统菜单列表")
    public BaseResponseInfo<QuerySystemMenuInfoResponse> querySystemMenuInfo(@Validated QueryAdminRoleMenuRequest queryAdminRoleMenuRequest,BindingResult bindingResult) {
		BaseResponseInfo<QuerySystemMenuInfoResponse> responseInfo = new BaseResponseInfo<QuerySystemMenuInfoResponse>();
		try {
			responseInfo = menuInfoBiz.querySystemMenuInfo(queryAdminRoleMenuRequest);
		} catch (Exception e) {
			logger.error("查询管理系统菜单列表--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	
	/**
     * 新增菜单
     * @param addMenuRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "新增菜单")
	@RequestMapping("/addMenu")
    @LoggerManage(description = "新增菜单")
    public BaseResponseInfo<Object> addMenu(@Validated  AddMenuRequest addMenuRequest ,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = menuInfoBiz.addMenu(addMenuRequest);
		} catch (Exception e) {
			logger.error("新增菜单--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 修改菜单信息
     * @param modifyMenuInfoRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "修改菜单信息")
	@RequestMapping("/modifyMenuInfo")
    @LoggerManage(description = "修改菜单信息")
    public BaseResponseInfo<Object> modifyMenuInfo(@Validated  ModifyMenuInfoRequest modifyMenuInfoRequest ,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = menuInfoBiz.modifyMenuInfo(modifyMenuInfoRequest);
		} catch (Exception e) {
			logger.error("修改菜单信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	
	/**
     * 删除菜单，功能点信息
     * @param deleteMenuInfoRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "删除菜单，功能点信息")
	@RequestMapping("/deleteMenuInfoOrFunction")
    @LoggerManage(description = "删除菜单，功能点信息")
    public BaseResponseInfo<Object> deleteMenuInfoOrFunction(@Validated  DeleteMenuInfoOrFunctionRequest deleteMenuInfoOrFunctionRequest ,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = menuInfoBiz.deleteMenuInfoOrFunction(deleteMenuInfoOrFunctionRequest);
		} catch (Exception e) {
			logger.error("删除菜单，功能点信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 菜单信息下拉框
     * @author zfb
     * @create 2018-04-08
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryMenuDropdown")
    @LoggerManage(description = "查询菜单信息下拉框")
    public BaseResponseInfo<QueryMenuDropdownResponse> queryMenuDropdown(@Validated  QueryMenuDropdownRequest queryMenuDropdownRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<QueryMenuDropdownResponse> responseInfo = new BaseResponseInfo<QueryMenuDropdownResponse>();
		try {
			responseInfo = menuInfoBiz.queryMenuDropdown(queryMenuDropdownRequest);
		} catch (Exception e) {
			logger.error("查询菜单信息下拉框选择框--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	
	/**
     * 添加功能点
     * @param addMenuFunctionRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/addMenuFunction")
    @LoggerManage(description = "添加功能点")
    public BaseResponseInfo<Object> addMenuFunction(@Validated  AddMenuFunctionRequest addMenuFunctionRequest ,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = menuInfoBiz.addMenuFunction(addMenuFunctionRequest);
		} catch (Exception e) {
			logger.error("添加功能点--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 修改功能点信息
     * @param modifyMenuFunctionRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/modifyMenuFunction")
    @LoggerManage(description = "修改功能点信息")
    public BaseResponseInfo<Object> modifyMenuFunction(@Validated  ModifyMenuFunctionRequest modifyMenuFunctionRequest ,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = menuInfoBiz.modifyMenuFunction(modifyMenuFunctionRequest);
		} catch (Exception e) {
			logger.error("修改功能点信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 查询角色授权的菜单信息
     * @param queryRoleMenuInfoRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "查询角色授权的菜单")
	@RequestMapping("/queryRoleMenuInfo")
    @LoggerManage(description = "查询角色授权的菜单")
    public BaseResponseInfo<QueryRoleMenuInfoResponse> queryRoleMenuInfo(@Validated  QueryRoleMenuInfoRequest queryRoleMenuInfoRequest ,BindingResult bindingResult) {
		BaseResponseInfo<QueryRoleMenuInfoResponse> responseInfo = new BaseResponseInfo<QueryRoleMenuInfoResponse>();
		try {
			responseInfo = menuInfoBiz.queryRoleMenuInfo(queryRoleMenuInfoRequest);
		} catch (Exception e) {
			logger.error("查询角色授权的菜单--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 查询所有菜单信息     
     * @author zfb
     * @create 2018-04-12
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryMenuInfo")
    @LoggerManage(description = "查询菜单信息")
    public BaseResponseInfo<QueryMenuInfoResponse> queryRoleMenuInfo() {
		BaseResponseInfo<QueryMenuInfoResponse> responseInfo = new BaseResponseInfo<QueryMenuInfoResponse>();
		try {
			responseInfo = menuInfoBiz.queryMenuInfo();
		} catch (Exception e) {
			logger.error("查询菜单信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	/**
     * 根据菜单编号查询菜单下级菜单下拉框
     * @author wm
     * @create 2018-04-12
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryMenuDownDropdown")
    @LoggerManage(description = "根据菜单编号查询菜单下级菜单下拉框")
    public BaseResponseInfo<QueryMenuDownDropdownResponse> queryMenuDownDropdown(@Validated  QueryMenuDownDropdownRequest queryMenuDownDropdownRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<QueryMenuDownDropdownResponse> responseInfo = new BaseResponseInfo<QueryMenuDownDropdownResponse>();
		try {
			responseInfo = menuInfoBiz.queryMenuDownDropdown(queryMenuDownDropdownRequest);
		} catch (Exception e) {
			logger.error("根据菜单编号查询菜单下级菜单下拉框--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 通过菜单编号查询菜单信息
     * @param queryMenuInfoRequest
     * @author zfb
     * @create 2018-04-13
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryMenuInfoByMenuNo")
    @LoggerManage(description = "通过菜单编号查询菜单信息")
    public BaseResponseInfo<QueryMenuInfoByMenuNoResonse> queryUserInfo(@Validated  QueryMenuInfoRequest queryMenuInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<QueryMenuInfoByMenuNoResonse> responseInfo = new BaseResponseInfo<QueryMenuInfoByMenuNoResonse>();
		try {
			responseInfo = menuInfoBiz.queryMenuInfoByMenuNo(queryMenuInfoRequest);
		} catch (Exception e) {
			logger.error("通过菜单编号查询菜单信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 菜单排序
     * @param menuSort
     * @author zfb
     * @create 2018-09-17
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/menuSort")
    @LoggerManage(description = "菜单排序")
    public BaseResponseInfo<Object> menuSort(@Validated  MenuSortRequest menuSortRequest ,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = menuInfoBiz.menuSort(menuSortRequest);
		} catch (Exception e) {
			logger.error("菜单排序--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
}
