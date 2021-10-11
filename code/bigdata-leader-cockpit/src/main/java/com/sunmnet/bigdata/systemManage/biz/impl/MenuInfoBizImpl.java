package com.sunmnet.bigdata.systemManage.biz.impl;


import java.util.List;

import com.github.pagehelper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.util.DateUtil;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetMenuInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetNumberGeneratorEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetRoleInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemAdminInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetUserInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.MenuLevelEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemManageResultEnum;
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
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserRoleMenuAllRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserRoleMenuInfoRemoteRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserSystemNoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMenuDownDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMenuDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMenuInfoByMenuNoResonse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMenuInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRoleMenuInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemMenuInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserRoleMenuAllResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserRoleMenuInfoRemoteResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserSystemNoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.biz.MenuInfoBiz;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetMenuInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetNumberGeneratorDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetRoleInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetRoleMenuInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemAdminInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetUserInfoDao;
import com.sunmnet.bigdata.systemManage.service.MenuInfoService;
import com.sunmnet.bigdata.systemManage.util.SystemManageConstants;
/**
 * 菜单信息实现
 * @author wm
 * @create 2018-03-30
 */
@Service
public class MenuInfoBizImpl implements MenuInfoBiz {
	
	private Logger logger = LoggerFactory.getLogger(MenuInfoBizImpl.class);
	
	
	@Autowired
	private MenuInfoService menuInfoService;
	@Autowired
	private SunmnetMenuInfoDao sunmnetMenuInfoDao;
	@Autowired
	private SunmnetRoleMenuInfoDao sunmnetRoleMenuInfoDao;
	@Autowired
	private SunmnetRoleInfoDao sunmnetRoleInfoDao;
	@Autowired
	private SunmnetUserInfoDao sunmnetUserInfoDao;
	@Autowired
	private SunmnetSystemInfoDao sunmnetSystemInfoDao;
	@Autowired
	private SunmnetSystemAdminInfoDao sunmnetSystemAdminInfoDao;
	@Autowired
	private SunmnetNumberGeneratorDao sunmnetNumberGeneratorDao;
	
	
	/**
     * 查询管理系统菜单列表
     * @param
     * @author wm
     * @create 2018-04-06
     * @return
     */
	@Override
	public BaseResponseInfo<QuerySystemMenuInfoResponse> querySystemMenuInfo(QueryAdminRoleMenuRequest queryAdminRoleMenuRequest) {
		SystemManageResponseInfo<QuerySystemMenuInfoResponse> responseInfo = new SystemManageResponseInfo<QuerySystemMenuInfoResponse>();
		try {
			//1、判断管理员是否存在
			String adminNo = queryAdminRoleMenuRequest.getAdminNo();
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = sunmnetSystemAdminInfoDao.getSystemAdminInfoByAdminNo(adminNo);
			if(sunmnetSystemAdminInfoEntity==null){
				logger.info("查询管理系统菜单列表--管理员不存在;管理员编号："+adminNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_AMDIN);
				return responseInfo;
			}
			responseInfo = menuInfoService.querySystemMenuInfo(queryAdminRoleMenuRequest);
		} catch (Exception e) {
			logger.error("查询管理系统菜单列表--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
	 * 添加菜单
	 * @param addMenuRequest
	 * @author wm
	 * @create 2018-04-07
	 */
	@Override
	public BaseResponseInfo<Object> addMenu(AddMenuRequest addMenuRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、组合菜单编号
			MenuLevelEnum menuLevel = addMenuRequest.getMenuLevel();
			String systemNo = addMenuRequest.getSystemNo();
			String menuNo = systemNo;//菜单编号=系统编号+菜单编号（一级,二级）+功能点编号
			String number = getNumberGenerator();
			if(number==null){
				logger.info("添加菜单--生成菜单编号失败,详情："+addMenuRequest.toString());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.CREATE_MENU_NO_FAIL);
				return responseInfo;
			}
			if(MenuLevelEnum.ONE==menuLevel){
				menuNo = menuNo+SystemManageConstants.FIRST_MENO_NO+number;
			}else if(MenuLevelEnum.TWO==menuLevel){
				String parentMenuNo = addMenuRequest.getParentMenuNo();//上级菜单编号
				if(parentMenuNo==null||"".equals(parentMenuNo)){
					logger.info("添加菜单--二级菜单必须要有一级菜单,详情："+addMenuRequest.toString());
					responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.TWO_MENU_NO_ONE_MENU);
					return responseInfo;
				}
				menuNo = parentMenuNo+SystemManageConstants.SECOND_MENO_NO+number;
			}else if(MenuLevelEnum.THREE==menuLevel){
				String parentMenuNo = addMenuRequest.getParentMenuNo();//上级菜单编号
				if(parentMenuNo==null||"".equals(parentMenuNo)){
					logger.info("添加菜单--三级菜单必须要有二级菜单,详情："+addMenuRequest.toString());
					responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.THREE_MENU_NO_TWO_MENU);
					return responseInfo;
				}
				menuNo = parentMenuNo+SystemManageConstants.THIRD_MENO_NO+number;
			}else{
				logger.info("添加菜单--不支持的菜单等级,详情："+addMenuRequest.toString());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_THIS_MENU_TYPE);
				return responseInfo;
			}
			//2、查询菜单编号是否存在
			SunmnetMenuInfoEntity sunmnetMenuInfoEntity  = sunmnetMenuInfoDao.getMenuInfoByMeno(menuNo);
			if(sunmnetMenuInfoEntity!=null){
				logger.info("添加菜单--菜单编号已存在;菜单编号："+menuNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.MENU_NO_EXIST);
				return responseInfo;
			}
			addMenuRequest.setMenuNo(menuNo);
			responseInfo = menuInfoService.addMenu(addMenuRequest);
		} catch (Exception e) {
			logger.error("添加菜单--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
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
	@Override
	public BaseResponseInfo<Object> modifyMenuInfo(ModifyMenuInfoRequest modifyMenuInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、查询菜单编号是否存在
			String menuNo = modifyMenuInfoRequest.getMenuNo();
			SunmnetMenuInfoEntity sunmnetMenuInfoEntity  = sunmnetMenuInfoDao.getMenuInfoByMeno(menuNo);
			if(sunmnetMenuInfoEntity==null){
				logger.info("修改菜单信息--菜单编号不存在;菜单编号："+menuNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_MENU);
				return responseInfo;
			}
			responseInfo = menuInfoService.modifyMenuInfo(modifyMenuInfoRequest);
		} catch (Exception e) {
			logger.error("修改菜单信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 删除菜单,功能点信息
     * @param deleteMenuInfoOrFunctionRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	@Override
	public BaseResponseInfo<Object> deleteMenuInfoOrFunction(DeleteMenuInfoOrFunctionRequest deleteMenuInfoOrFunctionRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、查询菜单编号是否存在
			String menuNo = deleteMenuInfoOrFunctionRequest.getMenuNo();
			SunmnetMenuInfoEntity sunmnetMenuInfoEntity  = sunmnetMenuInfoDao.getMenuInfoByMeno(menuNo);
			if(sunmnetMenuInfoEntity==null){
				logger.info("删除菜单,功能点--菜单,功能点不存在;菜单,功能点编号："+menuNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_MENU);
				return responseInfo;
			}
			//2、判断菜单有没有分配给角色
			long count = sunmnetRoleMenuInfoDao.getRoleMenuCountByMenuNo(menuNo);
			if(count>0){
				logger.info("删除菜单,功能点--菜单,功能点已经授权给角色;菜单编号："+menuNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.MENU_SET_ROLE_OR_FUNTION_SET_ROLE);
				return responseInfo;
			}
			//3、有子菜单的情况下不允许删除
			List<SunmnetMenuInfoEntity> entityList  = sunmnetMenuInfoDao.getChildMenuInfoByMeno(menuNo);
			if(null!=entityList && entityList.size()>0){
				logger.info("删除菜单,功能点--菜单有子菜单或者子功能点不允许删除;菜单,功能点编号："+menuNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.MENU_HAVE_CHILD_MENU);
				return responseInfo;
			}
			
			responseInfo = menuInfoService.deleteMenuInfo(sunmnetMenuInfoEntity);
		} catch (Exception e) {
			logger.error("删除菜单,功能点--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
	 * 查询菜单下拉框
	 * @param queryMenuDorpdownRequest
	 * @author zfb
	 * @create 2018-04-08
	 */
	@Override
	public BaseResponseInfo<QueryMenuDropdownResponse> queryMenuDropdown(
			QueryMenuDropdownRequest queryMenuDorpdownRequest) {
		SystemManageResponseInfo<QueryMenuDropdownResponse> responseInfo = new SystemManageResponseInfo<QueryMenuDropdownResponse>();
		try {
			MenuLevelEnum menuLevel = queryMenuDorpdownRequest.getMenuLevel();
			if(MenuLevelEnum.TWO==menuLevel && StringUtil.isEmpty(queryMenuDorpdownRequest.getParentMenuNo())){
				logger.info("获取二级菜单，必须传一级菜单编号"+queryMenuDorpdownRequest.toString());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.TWO_MENU_NO_ONE_MENU);
				return responseInfo;
			}else if(MenuLevelEnum.THREE==menuLevel && StringUtil.isEmpty(queryMenuDorpdownRequest.getParentMenuNo())){
				logger.info("获取三级菜单，必须传二级菜单编号"+queryMenuDorpdownRequest.toString());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.THREE_MENU_NO_TWO_MENU);
				return responseInfo;
				}
			responseInfo = menuInfoService.queryDepartmentDropdown(queryMenuDorpdownRequest);
		} catch (Exception e) {
			logger.error("查询菜单信息下拉框选择校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
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
	@Override
	public BaseResponseInfo<Object> addMenuFunction(AddMenuFunctionRequest addMenuFunctionRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String parentMenuNo = null;//上级菜单编号
			//1、组合菜单编号
			MenuLevelEnum menuLevel = addMenuFunctionRequest.getMenuLevel();
			String systemNo = addMenuFunctionRequest.getSystemNo();
			String menuNo = systemNo;//功能点编号=系统编号+菜单编号（一级,二级）+功能点编号
			String number = getNumberGenerator();
			if(number==null){
				logger.info("添加功能点--生成功能点编号失败,详情："+addMenuFunctionRequest.toString());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.CREATE_MENU_NO_FAIL);
				return responseInfo;
			}
			String firstMenuNo = addMenuFunctionRequest.getFirstMenuNo();
			if(MenuLevelEnum.ONE==menuLevel){
				if(firstMenuNo==null||"".equals(firstMenuNo)){
					logger.info("添加功能点--一级菜单添加功能点必须要有一级菜单编号,详情："+addMenuFunctionRequest.toString());
					responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.ONE_FUNTION_NO_FIRST_MENO_NO);
					return responseInfo;
				}
				parentMenuNo = firstMenuNo;
				menuNo = firstMenuNo+SystemManageConstants.THIRD_MENO_NO+number;
			}else if(MenuLevelEnum.TWO==menuLevel){
				if(firstMenuNo==null||"".equals(firstMenuNo)){
					logger.info("添加功能点--二级菜单添加功能点必须要有一级菜单编号,详情："+addMenuFunctionRequest.toString());
					responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.TWO_FUNTION_NO_FIRST_MENO_NO);
					return responseInfo;
				}
				String secondMenuNo = addMenuFunctionRequest.getSecondMenuNo();
				if(secondMenuNo==null||"".equals(secondMenuNo)){
					logger.info("添加功能点--二级菜单添加功能点必须要有二级菜单编号,详情："+addMenuFunctionRequest.toString());
					responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.TWO_FUNTION_NO_SECOND_MENO_NO);
					return responseInfo;
				}
				parentMenuNo = secondMenuNo;
				menuNo = secondMenuNo+SystemManageConstants.THIRD_MENO_NO+number;
			}else{
				logger.info("添加功能点--不支持的菜单等级,详情："+addMenuFunctionRequest.toString());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_THIS_MENU_TYPE);
				return responseInfo;
			}
			//2、查询功能点编号是否存在
			SunmnetMenuInfoEntity sunmnetMenuInfoEntity  = sunmnetMenuInfoDao.getMenuInfoByMeno(menuNo);
			if(sunmnetMenuInfoEntity!=null){
				logger.info("添加功能点--功能点编号已存在;功能点编号："+menuNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.FUNTION_EXIST);
				return responseInfo;
			}
			addMenuFunctionRequest.setMenuNo(menuNo);
			addMenuFunctionRequest.setParentMenuNo(parentMenuNo);
			responseInfo = menuInfoService.addMenuFunction(addMenuFunctionRequest);
		} catch (Exception e) {
			logger.error("添加功能点--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
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
	@Override
	public BaseResponseInfo<Object> modifyMenuFunction(ModifyMenuFunctionRequest modifyMenuFunctionRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、查询功能点是否存在
			String menuNo = modifyMenuFunctionRequest.getMenuNo();
			SunmnetMenuInfoEntity sunmnetMenuInfoEntity  = sunmnetMenuInfoDao.getMenuInfoByMeno(menuNo);
			if(sunmnetMenuInfoEntity==null){
				logger.info("修改功能点信息--功能点不已存在;功能点编号："+menuNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_FUNTION);
				return responseInfo;
			}
			responseInfo = menuInfoService.modifyMenuFunction(modifyMenuFunctionRequest);
		} catch (Exception e) {
			logger.error("修改功能点信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
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
	@Override
	public BaseResponseInfo<QueryRoleMenuInfoResponse> queryRoleMenuInfo(QueryRoleMenuInfoRequest queryRoleMenuInfoRequest) {
		SystemManageResponseInfo<QueryRoleMenuInfoResponse> responseInfo = new SystemManageResponseInfo<QueryRoleMenuInfoResponse>();
		try {
			//1、判断角色是否存在
			String roleNo = queryRoleMenuInfoRequest.getRoleNo();
			SunmnetRoleInfoEntity sunmnetRoleInfoEntity = sunmnetRoleInfoDao.getRoleInfoByRoleNo(roleNo);
			if(sunmnetRoleInfoEntity==null){
				logger.info("查询角色授权的菜单信息--角色不存在;角色员编号："+roleNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_ROLE);
				return responseInfo;
			}
			responseInfo = menuInfoService.queryRoleMenuInfo(queryRoleMenuInfoRequest);
		} catch (Exception e) {
			logger.error("查询角色授权的菜单信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 查询菜单信息     
     * @author zfb
     * @create 2018-04-12
     * @return
     */
	@Override
	public BaseResponseInfo<QueryMenuInfoResponse> queryMenuInfo() {
		SystemManageResponseInfo<QueryMenuInfoResponse> responseInfo = new SystemManageResponseInfo<QueryMenuInfoResponse>();
		try {
			
			responseInfo = menuInfoService.queryMenuInfo();
		} catch (Exception e) {
			logger.error("查询菜单信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 查询用户登录的权限菜单信息服务间调用根据用户编号和系统编号
     * @param queryUserRoleMenuInfoRemoteRequest
     * @author wm
     * @create 2018-04-12
     * @return
     */
	@Override
	public BaseResponseInfo<QueryUserRoleMenuInfoRemoteResponse> queryUserRoleMenuInfoRemote(QueryUserRoleMenuInfoRemoteRequest queryUserRoleMenuInfoRemoteRequest) {
		SystemManageResponseInfo<QueryUserRoleMenuInfoRemoteResponse> responseInfo = new SystemManageResponseInfo<QueryUserRoleMenuInfoRemoteResponse>();
		try {
			String userNo = queryUserRoleMenuInfoRemoteRequest.getUserNo();
			String systemNo = queryUserRoleMenuInfoRemoteRequest.getSystemNo();
			//1、判断用户是否存在
			SunmnetUserInfoEntity sunmnetUserInfoEntity = sunmnetUserInfoDao.getUserInfoByUserNo(userNo);
			if(sunmnetUserInfoEntity==null){
				logger.info("查询用户登录的权限菜单信息服务间调用根据用户编号和系统编号--用户信息不存在;详情："+queryUserRoleMenuInfoRemoteRequest.toString());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_USER);
				return responseInfo;
			}
			if("LOCK".equals(sunmnetUserInfoEntity.getUserStatus().getCode())){
				logger.info("查询用户登录的权限菜单信息服务间调用根据用户编号和系统编号--用户已经被锁定;详情："+queryUserRoleMenuInfoRemoteRequest.toString());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.USER_LOCK);
				return responseInfo;
			}
			queryUserRoleMenuInfoRemoteRequest.setUserNo(sunmnetUserInfoEntity.getUserNo());
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = sunmnetSystemInfoDao.getSystemInfoBySystemNo(systemNo);
			if(sunmnetSystemInfoEntity==null){
				logger.info("查询用户登录的权限菜单信息服务间调用根据用户编号和系统编号--系统不存在;详情："+queryUserRoleMenuInfoRemoteRequest.toString());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.SYSTEM_NO_EXIST);
				return responseInfo;
			}
			responseInfo = menuInfoService.queryUserRoleMenuInfoRemote(queryUserRoleMenuInfoRemoteRequest,sunmnetSystemInfoEntity.getSystemName());
		} catch (Exception e) {
			logger.error("查询用户登录的权限菜单信息服务间调用根据用户编号和系统编号--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 根据菜单编号查询菜单下级菜单下拉框
     * @author wm
     * @create 2018-04-12
     * @return
     */
	@Override
	public BaseResponseInfo<QueryMenuDownDropdownResponse> queryMenuDownDropdown(QueryMenuDownDropdownRequest queryMenuDownDropdownRequest) {
		SystemManageResponseInfo<QueryMenuDownDropdownResponse> responseInfo = new SystemManageResponseInfo<QueryMenuDownDropdownResponse>();
		try {
			//1、查询菜单编号是否存在
			String menuNo = queryMenuDownDropdownRequest.getMenuNo();
			
			String systemNo = queryMenuDownDropdownRequest.getSystemNo();
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = sunmnetSystemInfoDao.getSystemInfoBySystemNo(systemNo);
			if(sunmnetSystemInfoEntity==null){
				logger.info("根据菜单编号查询菜单下级菜单下拉框--系统信息不存在;系统编号："+systemNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_NO);
				return responseInfo;
			}
			SunmnetMenuInfoEntity sunmnetMenuInfoEntity  = sunmnetMenuInfoDao.getMenuInfoByMeno(menuNo);
			if(sunmnetMenuInfoEntity==null){
				logger.info("根据菜单编号查询菜单下级菜单下拉框--菜单不号已存在;功能点编号："+menuNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_MENU);
				return responseInfo;
			}
			responseInfo = menuInfoService.queryMenuDownDropdown(queryMenuDownDropdownRequest);
		} catch (Exception e) {
			logger.error("根据菜单编号查询菜单下级菜单下拉框--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 根据菜单编号查询菜单详细信息
     * @param queryMenuInfoRequest
     * @author zfb
     * @create 2018-04-13
     * @return
     */
	@Override
	public BaseResponseInfo<QueryMenuInfoByMenuNoResonse> queryMenuInfoByMenuNo(
			QueryMenuInfoRequest queryMenuInfoRequest) {
		SystemManageResponseInfo<QueryMenuInfoByMenuNoResonse> responseInfo = new SystemManageResponseInfo<QueryMenuInfoByMenuNoResonse>();
		try {
			String menuNo = queryMenuInfoRequest.getMenuNo();
			//1、判断菜单是否存在
			SunmnetMenuInfoEntity sunmnetMenuInfoEntity = sunmnetMenuInfoDao.getMenuInfoByMenuNo(menuNo);
			if(sunmnetMenuInfoEntity==null){
				logger.info("根据菜单编号查询菜单详细信息--菜单不存在;菜单编号："+menuNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_MENU);
				return responseInfo;
			}
			responseInfo = menuInfoService.queryMenuInfoByMenuNo(sunmnetMenuInfoEntity);
		} catch (Exception e) {
			logger.error("根据菜单编号查询菜单详细信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 获取菜单编号信息
     * @author wm
     * @create 2018-05-20
     * @return
     */
	public synchronized String getNumberGenerator(){
		String number = null;
		SunmnetNumberGeneratorEntity numberGenerator = sunmnetNumberGeneratorDao.getNumberGenerator();
		if(numberGenerator!=null){
			number = numberGenerator.getNumber()+"";
		}
		numberGenerator.setLastModifyTime(DateUtil.getDateAndTimes());
		if(sunmnetNumberGeneratorDao.updateNumberGenerator(numberGenerator)!=1){
			number = null;
		}
		return number;
	}
	/**
     * 查询用户权限菜单编号服务间调用
     * @param
     * @author wm
     * @create 2018-05-27
     * @return
     */
	@Override
	public BaseResponseInfo<QueryUserRoleMenuAllResponse> queryUserRoleMenuAll(
			QueryUserRoleMenuAllRequest queryUserRoleMenuAllRequest) {
		SystemManageResponseInfo<QueryUserRoleMenuAllResponse> responseInfo = new SystemManageResponseInfo<QueryUserRoleMenuAllResponse>();
		try {
			String userNo = queryUserRoleMenuAllRequest.getUserNo();
			//1、判断用户是否存在
			SunmnetUserInfoEntity sunmnetUserInfoEntity = sunmnetUserInfoDao.getUserInfoByUserNo(userNo);
			if(sunmnetUserInfoEntity==null){
				logger.info("查询用户权限菜单编号服务间调用--用户信息不存在;详情："+queryUserRoleMenuAllRequest.toString());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_USER);
				return responseInfo;
			}
			responseInfo = menuInfoService.queryUserRoleMenuAll(queryUserRoleMenuAllRequest);
		} catch (Exception e) {
			logger.error("查询用户权限菜单编号服务间调用--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 查询用户拥有的系统权限
     * @param queryUserSystemNoRequest
     * @author wm
     * @create 2018-07-31
     * @return
     */
	@Override
	public BaseResponseInfo<QueryUserSystemNoResponse> queryUserSystemNo(
			QueryUserSystemNoRequest queryUserSystemNoRequest) {
		SystemManageResponseInfo<QueryUserSystemNoResponse> responseInfo = new SystemManageResponseInfo<QueryUserSystemNoResponse>();
		try {
			String userNo = queryUserSystemNoRequest.getUserNo();
			//1、判断用户是否存在
			SunmnetUserInfoEntity sunmnetUserInfoEntity = sunmnetUserInfoDao.getUserInfoByUserNo(userNo);
			if(sunmnetUserInfoEntity==null){
				logger.info("查询用户拥有的系统权限--用户信息不存在;详情："+queryUserSystemNoRequest.toString());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_USER);
				return responseInfo;
			}
			responseInfo = menuInfoService.queryUserSystemNo(queryUserSystemNoRequest);
		} catch (Exception e) {
			logger.error("查询用户拥有的系统权限--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 菜单排序
     * @param
     * @author zfb
     * @create 2018-09-17
     * @return
     */
	@Override
	public BaseResponseInfo<Object> menuSort(MenuSortRequest menuSortRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {			
			responseInfo = menuInfoService.menuSort(menuSortRequest);
		} catch (Exception e) {
			logger.error("菜单排序--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
}
