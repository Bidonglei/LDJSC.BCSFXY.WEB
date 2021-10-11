package com.sunmnet.bigdata.systemManage.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemAdminInfoEntity;
import com.sunmnet.bigdata.systemManage.dao.systemManage.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.util.DateUtil;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetMenuInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.MenuLevelEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.RoleMenuStatusEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemManageResultEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.AdminMenuInfoRoleModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.FirstMenuInfoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.FirstRoleMenuInfoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.MenuInfoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.MenuInfoModelInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryMenuDownDropdownModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryMenuDropdownModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryMenuInfoModelInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryMenuInfoRequestModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryRoleMenuInfoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryRoleMenuInfoModelInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryRoleMenuInfoRequestModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QuerySystemManageMenuInfoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryUserRoleMenuInfoRemoteRequestModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryUserSystemNoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.RoleMenuInfoModelInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.SecondMenuInfoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.SecondRoleMenuInfoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.ThreeMenuInfoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.ThreeRoleMenuInfoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddMenuFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddMenuRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.MenuSortRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyMenuFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyMenuInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryAdminRoleMenuRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMenuDownDropdownRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMenuDropdownRequest;
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
import com.sunmnet.bigdata.systemManage.service.MenuInfoService;
import com.sunmnet.bigdata.systemManage.util.SystemManageConstants;
/**
 * 菜单信息
 * @author wm
 * @create 2018-03-30
 */
@Service
public class MenuInfoServiceImpl implements MenuInfoService{

	private Logger logger = LoggerFactory.getLogger(MenuInfoServiceImpl.class);
	
	@Autowired
	private SunmnetMenuInfoDao sunmnetMenuInfoDao;
	@Autowired
	private SunmnetRoleMenuInfoDao sunmnetRoleMenuInfoDao;
	@Autowired
	private SunmnetSystemInfoDao sunmnetSystemInfoDao;
	@Autowired
	private SunmnetSystemAdminMenuInfoDao sunmnetSystemAdminMenuInfoDao;
	@Autowired
	private SunmnetSystemAdminInfoDao sunmnetSystemAdminInfoDao;
	
	/**
     * 查询管理系统菜单列表
     * @param querySystemMenuInfoRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	@Override
	public SystemManageResponseInfo<QuerySystemMenuInfoResponse> querySystemMenuInfo(QueryAdminRoleMenuRequest queryAdminRoleMenuRequest) {
		SystemManageResponseInfo<QuerySystemMenuInfoResponse> responseInfo = new SystemManageResponseInfo<QuerySystemMenuInfoResponse>();		
		try {
			QuerySystemMenuInfoResponse querySystemMenuInfoResponse  = new QuerySystemMenuInfoResponse();
			List<SunmnetMenuInfoEntity> list = sunmnetMenuInfoDao.findMenuInfoBySystemNo(SystemManageConstants.SYSTEM_NO);
			List<QuerySystemManageMenuInfoModel> listData = new ArrayList<QuerySystemManageMenuInfoModel>();
			//查询管理员菜单权限信息
			List<AdminMenuInfoRoleModel> menuList = sunmnetSystemAdminMenuInfoDao.findSystemAdminMenuUrlByAdminNo(queryAdminRoleMenuRequest.getAdminNo());
			for(SunmnetMenuInfoEntity sunmnetMenuInfoEntity : list){
				QuerySystemManageMenuInfoModel querySystemManageMenuInfoModel = new QuerySystemManageMenuInfoModel();
				querySystemManageMenuInfoModel.setMenuName(sunmnetMenuInfoEntity.getMenuName());
				String menuNo = sunmnetMenuInfoEntity.getMenuNo();
				querySystemManageMenuInfoModel.setMenuNo(menuNo);
				querySystemManageMenuInfoModel.setMenuStatus(RoleMenuStatusEnum.NO);
				for(AdminMenuInfoRoleModel adminMenuInfoRoleModel:menuList){
					if(menuNo.equals(adminMenuInfoRoleModel.getMenuNo())){
						querySystemManageMenuInfoModel.setMenuStatus(RoleMenuStatusEnum.YES);
						break;
					}
				}
				listData.add(querySystemManageMenuInfoModel);
			}
			querySystemMenuInfoResponse.setList(listData);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,querySystemMenuInfoResponse);
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
	public SystemManageResponseInfo<Object> addMenu(AddMenuRequest addMenuRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetMenuInfoEntity sunmnetMenuInfoEntity = new SunmnetMenuInfoEntity();
			sunmnetMenuInfoEntity.setMenuNo(addMenuRequest.getMenuNo());//菜单编号唯一标识
			sunmnetMenuInfoEntity.setMenuName(addMenuRequest.getMenuName());//菜单名称
			sunmnetMenuInfoEntity.setMenuUrl(addMenuRequest.getMenuUrl());//菜单URL地址
			sunmnetMenuInfoEntity.setMenuLevel(addMenuRequest.getMenuLevel()); //菜单级别  等级  ONE 主菜单 TWO 子菜单  THREE 级为功能按钮
			sunmnetMenuInfoEntity.setParentMenuNo(addMenuRequest.getParentMenuNo()); //上级菜单编号
			sunmnetMenuInfoEntity.setSystemNo(addMenuRequest.getSystemNo()); //菜单所属系统编号
			sunmnetMenuInfoEntity.setCreateTime(DateUtil.getDateAndTimes()); //创建时间  格式：YYYYMMDDHHmmssSSS
			int count = sunmnetMenuInfoDao.insertSelective(sunmnetMenuInfoEntity);
			if(count!=1){
				logger.info("添加菜单--保存信息失败;详情："+sunmnetMenuInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
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
	public SystemManageResponseInfo<Object> modifyMenuInfo(ModifyMenuInfoRequest modifyMenuInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetMenuInfoEntity sunmnetMenuInfoEntity = new SunmnetMenuInfoEntity();
			sunmnetMenuInfoEntity.setMenuNo(modifyMenuInfoRequest.getMenuNo());//菜单编号唯一标识
			sunmnetMenuInfoEntity.setMenuName(modifyMenuInfoRequest.getMenuName());//菜单名称
			sunmnetMenuInfoEntity.setMenuUrl(modifyMenuInfoRequest.getMenuUrl());//菜单URL地址
			sunmnetMenuInfoEntity.setMenuLevel(modifyMenuInfoRequest.getMenuLevel()); //菜单级别  等级  ONE 主菜单 TWO 子菜单  THREE 级为功能按钮
			sunmnetMenuInfoEntity.setParentMenuNo(modifyMenuInfoRequest.getParentMenuNo()); //上级菜单编号
			sunmnetMenuInfoEntity.setSystemNo(modifyMenuInfoRequest.getSystemNo()); //菜单所属系统编号
			sunmnetMenuInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes()); //最后修改时间  格式：YYYYMMDDHHmmssSSS
			int count = sunmnetMenuInfoDao.updateMenuInfoByMenuNo(sunmnetMenuInfoEntity);
			if(count!=1){
				logger.info("修改菜单信息--修改信息失败;详情："+sunmnetMenuInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("修改菜单信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 删除菜单信息
     * @param sunmnetMenuInfoEntity
     * @author wm
     * @create 2018-04-08
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> deleteMenuInfo(SunmnetMenuInfoEntity sunmnetMenuInfoEntity) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			int count = sunmnetMenuInfoDao.deleteByPrimaryKey(sunmnetMenuInfoEntity.getId());
			if(count!=1){
				logger.info("删除菜单信息--修改信息失败;详情："+sunmnetMenuInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("删除菜单信息--异常", e);
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
	public SystemManageResponseInfo<QueryMenuDropdownResponse> queryDepartmentDropdown(
			QueryMenuDropdownRequest queryMenuDropdownRequest) {
		SystemManageResponseInfo<QueryMenuDropdownResponse> responseInfo = new SystemManageResponseInfo<QueryMenuDropdownResponse>();		
		try {
			List<QueryMenuDropdownModel> list = sunmnetMenuInfoDao.queryMenuDropdown(queryMenuDropdownRequest);
			QueryMenuDropdownResponse queryMenuDropdownResponse = new QueryMenuDropdownResponse();
			queryMenuDropdownResponse.setList(list);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryMenuDropdownResponse);
		} catch (Exception e) {
			logger.error("菜单信息下拉框选择--异常", e);
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
	public SystemManageResponseInfo<Object> addMenuFunction(AddMenuFunctionRequest addMenuFunctionRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetMenuInfoEntity sunmnetMenuInfoEntity = new SunmnetMenuInfoEntity();
			sunmnetMenuInfoEntity.setMenuNo(addMenuFunctionRequest.getMenuNo());//菜单编号唯一标识
			sunmnetMenuInfoEntity.setMenuName(addMenuFunctionRequest.getMenuName());//菜单名称
			sunmnetMenuInfoEntity.setMenuLevel(MenuLevelEnum.THREE); //菜单级别  等级  ONE 主菜单 TWO 子菜单  THREE 级为功能按钮
			sunmnetMenuInfoEntity.setParentMenuNo(addMenuFunctionRequest.getParentMenuNo()); //上级菜单编号
			sunmnetMenuInfoEntity.setSystemNo(addMenuFunctionRequest.getSystemNo()); //菜单所属系统编号
			sunmnetMenuInfoEntity.setCreateTime(DateUtil.getDateAndTimes()); //创建时间  格式：YYYYMMDDHHmmssSSS
			int count = sunmnetMenuInfoDao.insertSelective(sunmnetMenuInfoEntity);
			if(count!=1){
				logger.info("添加功能点--保存信息失败;详情："+sunmnetMenuInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
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
	public SystemManageResponseInfo<Object> modifyMenuFunction(ModifyMenuFunctionRequest modifyMenuFunctionRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetMenuInfoEntity sunmnetMenuInfoEntity = new SunmnetMenuInfoEntity();
			sunmnetMenuInfoEntity.setMenuNo(modifyMenuFunctionRequest.getMenuNo());//菜单编号唯一标识
			sunmnetMenuInfoEntity.setMenuName(modifyMenuFunctionRequest.getMenuName());//菜单名称
			sunmnetMenuInfoEntity.setParentMenuNo(modifyMenuFunctionRequest.getParentMenuNo()); //上级菜单编号
			sunmnetMenuInfoEntity.setSystemNo(modifyMenuFunctionRequest.getSystemNo()); //菜单所属系统编号
			sunmnetMenuInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes()); //最后修改时间  格式：YYYYMMDDHHmmssSSS
			int count = sunmnetMenuInfoDao.updateMenuFunctionByMenuNo(sunmnetMenuInfoEntity);
			if(count!=1){
				logger.info("修改功能点信息--修改信息失败;详情："+sunmnetMenuInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
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
	public SystemManageResponseInfo<QueryRoleMenuInfoResponse> queryRoleMenuInfo(QueryRoleMenuInfoRequest queryRoleMenuInfoRequest) {
		SystemManageResponseInfo<QueryRoleMenuInfoResponse> responseInfo = new SystemManageResponseInfo<QueryRoleMenuInfoResponse>();		
		try {
			QueryRoleMenuInfoRequestModel queryRoleMenuInfoRequestModel = new QueryRoleMenuInfoRequestModel();
			queryRoleMenuInfoRequestModel.setRoleNo(queryRoleMenuInfoRequest.getRoleNo());
			queryRoleMenuInfoRequestModel.setSystemNo(SystemManageConstants.SYSTEM_NO);
			List<RoleMenuInfoModelInfo> listMenu = sunmnetMenuInfoDao.findSetRoleMenuInfo(queryRoleMenuInfoRequestModel);
			QueryRoleMenuInfoResponse queryRoleMenuInfoResponse = new QueryRoleMenuInfoResponse();
			List<QueryRoleMenuInfoModel> list = new ArrayList<QueryRoleMenuInfoModel>();
			List<SunmnetSystemInfoEntity> systemInfoList = sunmnetSystemInfoDao.findSystemInfoAll(SystemManageConstants.SYSTEM_NO);
			for(SunmnetSystemInfoEntity sunmnetSystemInfoEntity:systemInfoList){
				String systemNo = sunmnetSystemInfoEntity.getSystemNo();
				QueryRoleMenuInfoModel queryRoleMenuInfoModel = new QueryRoleMenuInfoModel();
				queryRoleMenuInfoModel.setSystemNo(systemNo);
				queryRoleMenuInfoModel.setSystemName(sunmnetSystemInfoEntity.getSystemName());
				List<QueryRoleMenuInfoModelInfo> menuList = new ArrayList<QueryRoleMenuInfoModelInfo>();
				for(RoleMenuInfoModelInfo roleMenuInfoModelInfo : listMenu){
					if(systemNo.equals(roleMenuInfoModelInfo.getSystemNo())){
						QueryRoleMenuInfoModelInfo queryRoleMenuInfoModelInfo = new QueryRoleMenuInfoModelInfo();	
						queryRoleMenuInfoModelInfo.setMenuLevel(roleMenuInfoModelInfo.getMenuLevel());
						queryRoleMenuInfoModelInfo.setMenuNo(roleMenuInfoModelInfo.getMenuNo());//菜单编号唯一标识
						queryRoleMenuInfoModelInfo.setMenuName(roleMenuInfoModelInfo.getMenuName());//菜单名称
						queryRoleMenuInfoModelInfo.setParentMenuNo(roleMenuInfoModelInfo.getParentMenuNo());
						String roleNo = roleMenuInfoModelInfo.getRoleNo();
						RoleMenuStatusEnum roleMenuStatus = RoleMenuStatusEnum.YES;
						if("".equals(roleNo)||roleNo==null){
							roleMenuStatus = RoleMenuStatusEnum.NO;
						}
						//角色是否拥有菜单、功能点授权状态   YES 有 NO没有
						queryRoleMenuInfoModelInfo.setRoleMenuStatus(roleMenuStatus);
						menuList.add(queryRoleMenuInfoModelInfo);
					}
				}
				//按菜单级别进行归纳处理第一级别主菜单
				List<FirstRoleMenuInfoModel> firstRoleMenuInfoModelList = new ArrayList<FirstRoleMenuInfoModel>();
				for(QueryRoleMenuInfoModelInfo queryRoleMenuInfoModelInfo : menuList){					
					if (MenuLevelEnum.ONE == queryRoleMenuInfoModelInfo.getMenuLevel())
					{  						
						FirstRoleMenuInfoModel firstRoleMenuInfoModel = new FirstRoleMenuInfoModel();
						firstRoleMenuInfoModel.setMenuLevel(queryRoleMenuInfoModelInfo.getMenuLevel());
						firstRoleMenuInfoModel.setMenuNo(queryRoleMenuInfoModelInfo.getMenuNo());
						firstRoleMenuInfoModel.setMenuName(queryRoleMenuInfoModelInfo.getMenuName());
						firstRoleMenuInfoModel.setParentMenuNo(queryRoleMenuInfoModelInfo.getParentMenuNo());
						firstRoleMenuInfoModel.setRoleMenuStatus(queryRoleMenuInfoModelInfo.getRoleMenuStatus());
						firstRoleMenuInfoModelList.add(firstRoleMenuInfoModel);
					}
				}
				//处理第二级别菜单
                for(FirstRoleMenuInfoModel firstRoleMenuInfoModel : firstRoleMenuInfoModelList){
                	String firstMenuNo = firstRoleMenuInfoModel.getMenuNo();                 	
                	List<SecondRoleMenuInfoModel> secondRoleMenuInfoModelList = new ArrayList<SecondRoleMenuInfoModel>();
                	for(QueryRoleMenuInfoModelInfo queryRoleMenuInfoModelInfo : menuList){
                		if (firstMenuNo.equals(queryRoleMenuInfoModelInfo.getParentMenuNo()))
                		{
                			SecondRoleMenuInfoModel secondRoleMenuInfoModel = new SecondRoleMenuInfoModel();
                			secondRoleMenuInfoModel.setMenuLevel(queryRoleMenuInfoModelInfo.getMenuLevel());
                			secondRoleMenuInfoModel.setMenuNo(queryRoleMenuInfoModelInfo.getMenuNo());
                			secondRoleMenuInfoModel.setMenuName(queryRoleMenuInfoModelInfo.getMenuName());
                			secondRoleMenuInfoModel.setParentMenuNo(queryRoleMenuInfoModelInfo.getParentMenuNo());
                			secondRoleMenuInfoModel.setRoleMenuStatus(queryRoleMenuInfoModelInfo.getRoleMenuStatus());
                			secondRoleMenuInfoModel.setParentMenuLevel(firstRoleMenuInfoModel.getMenuLevel());
                			secondRoleMenuInfoModelList.add(secondRoleMenuInfoModel);
                		}
                	}
                	firstRoleMenuInfoModel.setMenuList(secondRoleMenuInfoModelList);
                	
                	//处理第三级别菜单
                	 for(SecondRoleMenuInfoModel secondRoleMenuInfoModel : secondRoleMenuInfoModelList){
                     	String secondMenuNo = secondRoleMenuInfoModel.getMenuNo();
                     	List<ThreeRoleMenuInfoModel> threeRoleMenuInfoModelList = new ArrayList<ThreeRoleMenuInfoModel>();
                     	for(QueryRoleMenuInfoModelInfo queryRoleMenuInfoModelInfo : menuList){
                     		if (secondMenuNo.equals(queryRoleMenuInfoModelInfo.getParentMenuNo()))
                     		{
                     			ThreeRoleMenuInfoModel threeRoleMenuInfoModel = new ThreeRoleMenuInfoModel();
                     			threeRoleMenuInfoModel.setMenuLevel(queryRoleMenuInfoModelInfo.getMenuLevel());
                     			threeRoleMenuInfoModel.setMenuNo(queryRoleMenuInfoModelInfo.getMenuNo());
                     			threeRoleMenuInfoModel.setMenuName(queryRoleMenuInfoModelInfo.getMenuName());
                     			threeRoleMenuInfoModel.setParentMenuNo(queryRoleMenuInfoModelInfo.getParentMenuNo());
                     			threeRoleMenuInfoModel.setRoleMenuStatus(queryRoleMenuInfoModelInfo.getRoleMenuStatus());
                     			threeRoleMenuInfoModel.setParentMenuLevel(secondRoleMenuInfoModel.getMenuLevel());
                     			threeRoleMenuInfoModelList.add(threeRoleMenuInfoModel);
                     		}
                     	}
                     	secondRoleMenuInfoModel.setMenuList(threeRoleMenuInfoModelList);
     				}
				}
				
				queryRoleMenuInfoModel.setMenuList(firstRoleMenuInfoModelList);
				list.add(queryRoleMenuInfoModel);
			}
			queryRoleMenuInfoResponse.setList(list);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryRoleMenuInfoResponse);
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
	public SystemManageResponseInfo<QueryMenuInfoResponse> queryMenuInfo() {
		SystemManageResponseInfo<QueryMenuInfoResponse> responseInfo = new SystemManageResponseInfo<QueryMenuInfoResponse>();		
		try {
			QueryMenuInfoRequestModel queryMenuInfoRequestModel = new QueryMenuInfoRequestModel();			
			queryMenuInfoRequestModel.setSystemNo(SystemManageConstants.SYSTEM_NO);
			List<MenuInfoModelInfo> listMenu = sunmnetMenuInfoDao.findSetMenuInfo(queryMenuInfoRequestModel);
			QueryMenuInfoResponse queryMenuInfoResponse = new QueryMenuInfoResponse();
			queryMenuInfoResponse.setList(assembleMenuInfo(listMenu));
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryMenuInfoResponse);
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
	public SystemManageResponseInfo<QueryUserRoleMenuInfoRemoteResponse> queryUserRoleMenuInfoRemote(QueryUserRoleMenuInfoRemoteRequest queryUserRoleMenuInfoRemoteRequest,String systemName) {
		SystemManageResponseInfo<QueryUserRoleMenuInfoRemoteResponse> responseInfo = new SystemManageResponseInfo<QueryUserRoleMenuInfoRemoteResponse>();		
		try {
			String systemNo = queryUserRoleMenuInfoRemoteRequest.getSystemNo();
			QueryUserRoleMenuInfoRemoteResponse queryUserRoleMenuInfoRemoteResponse = new QueryUserRoleMenuInfoRemoteResponse();
			QueryUserRoleMenuInfoRemoteRequestModel queryUserRoleMenuInfoRemoteRequestModel = new QueryUserRoleMenuInfoRemoteRequestModel();
			queryUserRoleMenuInfoRemoteRequestModel.setSystemNo(systemNo);
			queryUserRoleMenuInfoRemoteRequestModel.setUserNo(queryUserRoleMenuInfoRemoteRequest.getUserNo());
			List<MenuInfoModelInfo> listMenu = sunmnetMenuInfoDao.findUserRoleMenuInfo(queryUserRoleMenuInfoRemoteRequestModel);
			//判断是否能登陆菜单管理系统，能为1，否为0
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = sunmnetSystemAdminInfoDao.getSystemAdminInfoByAdminNo(queryUserRoleMenuInfoRemoteRequest.getUserNo());
			MenuInfoModel menuInfo = new MenuInfoModel();
			if(null != sunmnetSystemAdminInfoEntity){
				menuInfo.setIsLogin("1");
			}else {
				menuInfo.setIsLogin("0");
			}
			menuInfo.setSystemNo(systemNo);
			menuInfo.setSystemName(systemName);
			//按菜单级别进行归纳处理第一级别主菜单
			List<FirstMenuInfoModel> firstMenuInfoModelList = new ArrayList<FirstMenuInfoModel>();
			for(MenuInfoModelInfo menuInfoModelInfo : listMenu){					
				if (MenuLevelEnum.ONE == menuInfoModelInfo.getMenuLevel())
				{  						
					FirstMenuInfoModel firstMenuInfoModel = new FirstMenuInfoModel();
					firstMenuInfoModel.setMenuLevel(menuInfoModelInfo.getMenuLevel());
					firstMenuInfoModel.setMenuNo(menuInfoModelInfo.getMenuNo());
					firstMenuInfoModel.setMenuName(menuInfoModelInfo.getMenuName());
					firstMenuInfoModel.setParentMenuNo(menuInfoModelInfo.getParentMenuNo());
					firstMenuInfoModel.setMenuUrl(menuInfoModelInfo.getMenuUrl());
					firstMenuInfoModelList.add(firstMenuInfoModel);
				}
			}
			//处理第二级别菜单
            for(FirstMenuInfoModel firstMenuInfoModel : firstMenuInfoModelList){
            	String firstMenuNo = firstMenuInfoModel.getMenuNo(); 
            	List<SecondMenuInfoModel> secondMenuInfoModelList = new ArrayList<SecondMenuInfoModel>();
            	for(MenuInfoModelInfo menuInfoModelInfo : listMenu){
            		if (firstMenuNo.equals(menuInfoModelInfo.getParentMenuNo())){
            			SecondMenuInfoModel secondMenuInfoModel = new SecondMenuInfoModel();
            			secondMenuInfoModel.setMenuLevel(menuInfoModelInfo.getMenuLevel());
            			secondMenuInfoModel.setMenuNo(menuInfoModelInfo.getMenuNo());
            			secondMenuInfoModel.setMenuName(menuInfoModelInfo.getMenuName());
            			secondMenuInfoModel.setParentMenuNo(menuInfoModelInfo.getParentMenuNo());
            			secondMenuInfoModel.setParentMenuLevel(firstMenuInfoModel.getMenuLevel());
            			secondMenuInfoModel.setMenuUrl(menuInfoModelInfo.getMenuUrl());
            			secondMenuInfoModelList.add(secondMenuInfoModel);
            		}
            	}
            	firstMenuInfoModel.setMenuList(secondMenuInfoModelList);                	
            	//处理第三级别菜单
            	 for(SecondMenuInfoModel secondMenuInfoModel : secondMenuInfoModelList){
                 	String secondMenuNo = secondMenuInfoModel.getMenuNo();
                 	List<ThreeMenuInfoModel> threeMenuInfoModelList = new ArrayList<ThreeMenuInfoModel>();
                 	for(MenuInfoModelInfo menuInfoModelInfo : listMenu){
                 		if (secondMenuNo.equals(menuInfoModelInfo.getParentMenuNo())){
                 			//数据报告 变更到新的接口中了
                 			ThreeMenuInfoModel threeMenuInfoModel = new ThreeMenuInfoModel();
                 			threeMenuInfoModel.setMenuLevel(menuInfoModelInfo.getMenuLevel());
                 			threeMenuInfoModel.setMenuNo(menuInfoModelInfo.getMenuNo());
                 			threeMenuInfoModel.setMenuName(menuInfoModelInfo.getMenuName());
                 			threeMenuInfoModel.setParentMenuNo(menuInfoModelInfo.getParentMenuNo());
                 			threeMenuInfoModel.setParentMenuLevel(secondMenuInfoModel.getMenuLevel());
							threeMenuInfoModel.setMenuUrl(menuInfoModelInfo.getMenuUrl());
//							threeMenuInfoModel.setPageName(menuInfoModelInfo.getPageName());
//							threeMenuInfoModel.setDataDepartment(menuInfoModelInfo.getDataDepartment());
							threeMenuInfoModel.setData(menuInfoModelInfo.getData());
							threeMenuInfoModel.setJudge(menuInfoModelInfo.getJudge());
//							threeMenuInfoModel.setDataSynchronize(menuInfoModelInfo.getDataSynchronize());
//							threeMenuInfoModel.setList(menuInfoModelInfo.getList());
                 			threeMenuInfoModelList.add(threeMenuInfoModel);
                 		}
                 	}
                 	secondMenuInfoModel.setMenuList(threeMenuInfoModelList);
 				}
			}
            menuInfo.setMenuList(firstMenuInfoModelList);
			queryUserRoleMenuInfoRemoteResponse.setMenuInfo(menuInfo);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryUserRoleMenuInfoRemoteResponse);
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
	public SystemManageResponseInfo<QueryMenuDownDropdownResponse> queryMenuDownDropdown(
			QueryMenuDownDropdownRequest queryMenuDownDropdownRequest) {
		SystemManageResponseInfo<QueryMenuDownDropdownResponse> responseInfo = new SystemManageResponseInfo<QueryMenuDownDropdownResponse>();		
		try {
			List<QueryMenuDownDropdownModel> list = sunmnetMenuInfoDao.queryMenuDownDropdown(queryMenuDownDropdownRequest);
			QueryMenuDownDropdownResponse queryMenuDownDropdownResponse = new QueryMenuDownDropdownResponse();
			queryMenuDownDropdownResponse.setList(list);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryMenuDownDropdownResponse);
		} catch (Exception e) {
			logger.error("根据菜单编号查询菜单下级菜单下拉框--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 处理组装菜单信息
     * @param List<MenuInfoModelInfo> listMenu
     * @author wm
     * @create 2018-04-30
     * @return
     */
	public List<MenuInfoModel> assembleMenuInfo(List<MenuInfoModelInfo> listMenu){
		List<MenuInfoModel> list = new ArrayList<MenuInfoModel>();
		List<SunmnetSystemInfoEntity> systemInfoList = sunmnetSystemInfoDao.findSystemInfoAll(SystemManageConstants.SYSTEM_NO);
		for(SunmnetSystemInfoEntity sunmnetSystemInfoEntity:systemInfoList){
			String systemNo = sunmnetSystemInfoEntity.getSystemNo();
			MenuInfoModel queryMenuInfoModel = new MenuInfoModel();
			queryMenuInfoModel.setSystemNo(systemNo);
			queryMenuInfoModel.setSystemName(sunmnetSystemInfoEntity.getSystemName());
			List<QueryMenuInfoModelInfo> menuList = new ArrayList<QueryMenuInfoModelInfo>();
			for(MenuInfoModelInfo menuInfoModelInfo : listMenu){
				if(systemNo.equals(menuInfoModelInfo.getSystemNo())){
					QueryMenuInfoModelInfo queryMenuInfoModelInfo = new QueryMenuInfoModelInfo();	
					queryMenuInfoModelInfo.setMenuLevel(menuInfoModelInfo.getMenuLevel());
					queryMenuInfoModelInfo.setMenuNo(menuInfoModelInfo.getMenuNo());//菜单编号唯一标识
					queryMenuInfoModelInfo.setMenuName(menuInfoModelInfo.getMenuName());//菜单名称
					queryMenuInfoModelInfo.setParentMenuNo(menuInfoModelInfo.getParentMenuNo());//上级菜单编号
					menuList.add(queryMenuInfoModelInfo);
				}
			}				
			//按菜单级别进行归纳处理第一级别主菜单
			List<FirstMenuInfoModel> firstMenuInfoModelList = new ArrayList<FirstMenuInfoModel>();
			for(QueryMenuInfoModelInfo queryMenuInfoModelInfo : menuList){					
				if (MenuLevelEnum.ONE == queryMenuInfoModelInfo.getMenuLevel())
				{  						
					FirstMenuInfoModel firstMenuInfoModel = new FirstMenuInfoModel();
					firstMenuInfoModel.setMenuLevel(queryMenuInfoModelInfo.getMenuLevel());
					firstMenuInfoModel.setMenuNo(queryMenuInfoModelInfo.getMenuNo());
					firstMenuInfoModel.setMenuName(queryMenuInfoModelInfo.getMenuName());
					firstMenuInfoModel.setParentMenuNo(queryMenuInfoModelInfo.getParentMenuNo());						
					firstMenuInfoModelList.add(firstMenuInfoModel);
				}
			}
			//处理第二级别菜单
            for(FirstMenuInfoModel firstMenuInfoModel : firstMenuInfoModelList){
            	String firstMenuNo = firstMenuInfoModel.getMenuNo(); 
            	List<SecondMenuInfoModel> secondMenuInfoModelList = new ArrayList<SecondMenuInfoModel>();
            	for(QueryMenuInfoModelInfo queryMenuInfoModelInfo : menuList){
            		if (firstMenuNo.equals(queryMenuInfoModelInfo.getParentMenuNo()))
            		{
            			SecondMenuInfoModel secondMenuInfoModel = new SecondMenuInfoModel();
            			secondMenuInfoModel.setMenuLevel(queryMenuInfoModelInfo.getMenuLevel());
            			secondMenuInfoModel.setMenuNo(queryMenuInfoModelInfo.getMenuNo());
            			secondMenuInfoModel.setMenuName(queryMenuInfoModelInfo.getMenuName());
            			secondMenuInfoModel.setParentMenuNo(queryMenuInfoModelInfo.getParentMenuNo());
            			secondMenuInfoModel.setParentMenuLevel(firstMenuInfoModel.getMenuLevel());
            			secondMenuInfoModelList.add(secondMenuInfoModel);
            		}
            	}
            	firstMenuInfoModel.setMenuList(secondMenuInfoModelList);                	
            	//处理第三级别菜单
            	 for(SecondMenuInfoModel secondMenuInfoModel : secondMenuInfoModelList){
                 	String secondMenuNo = secondMenuInfoModel.getMenuNo();
                 	List<ThreeMenuInfoModel> threeMenuInfoModelList = new ArrayList<ThreeMenuInfoModel>();
                 	for(QueryMenuInfoModelInfo queryMenuInfoModelInfo : menuList){
                 		if (secondMenuNo.equals(queryMenuInfoModelInfo.getParentMenuNo()))
                 		{
                 			ThreeMenuInfoModel threeMenuInfoModel = new ThreeMenuInfoModel();
                 			threeMenuInfoModel.setMenuLevel(queryMenuInfoModelInfo.getMenuLevel());
                 			threeMenuInfoModel.setMenuNo(queryMenuInfoModelInfo.getMenuNo());
                 			threeMenuInfoModel.setMenuName(queryMenuInfoModelInfo.getMenuName());
                 			threeMenuInfoModel.setParentMenuNo(queryMenuInfoModelInfo.getParentMenuNo());
                 			threeMenuInfoModel.setParentMenuLevel(secondMenuInfoModel.getMenuLevel());
                 			threeMenuInfoModelList.add(threeMenuInfoModel);
                 		}
                 	}
                 	secondMenuInfoModel.setMenuList(threeMenuInfoModelList);
 				}
			}
			queryMenuInfoModel.setMenuList(firstMenuInfoModelList);
			list.add(queryMenuInfoModel);
		}
		return list;
	}
	
	
	
	
	

	/**
     * 根据菜单编号查询菜单详细信息
     * @param sunmnetMenuInfoEntity
     * @author zfb
     * @create 2018-04-13
     * @return
     */
	@Override
	public SystemManageResponseInfo<QueryMenuInfoByMenuNoResonse> queryMenuInfoByMenuNo(
			SunmnetMenuInfoEntity sunmnetMenuInfoEntity) {
		SystemManageResponseInfo<QueryMenuInfoByMenuNoResonse> responseInfo = new SystemManageResponseInfo<QueryMenuInfoByMenuNoResonse>();		
		try {
			QueryMenuInfoByMenuNoResonse queryMenuInfoByMenuNoResonse = new QueryMenuInfoByMenuNoResonse();
						
			queryMenuInfoByMenuNoResonse.setMenuNo(sunmnetMenuInfoEntity.getMenuNo());
			queryMenuInfoByMenuNoResonse.setMenuName(sunmnetMenuInfoEntity.getMenuName());
			queryMenuInfoByMenuNoResonse.setMenuUrl(sunmnetMenuInfoEntity.getMenuUrl());
			queryMenuInfoByMenuNoResonse.setMenuLevel(sunmnetMenuInfoEntity.getMenuLevel());
			queryMenuInfoByMenuNoResonse.setMenuLevelStr(sunmnetMenuInfoEntity.getMenuLevel().getMsg());
			String parentMenuNo = sunmnetMenuInfoEntity.getParentMenuNo();
			queryMenuInfoByMenuNoResonse.setParentMenuNo(parentMenuNo);
			if (null != parentMenuNo && !"".equals(parentMenuNo))
			{
				SunmnetMenuInfoEntity menuInfoEntity = sunmnetMenuInfoDao.getMenuInfoByMenuNo(parentMenuNo);
				if (menuInfoEntity.getMenuLevel() == MenuLevelEnum.TWO)
				{
					queryMenuInfoByMenuNoResonse.setSecondMenuNo(parentMenuNo);
					queryMenuInfoByMenuNoResonse.setSecondMenuName(menuInfoEntity.getMenuName());
					String firstMenuNo = menuInfoEntity.getParentMenuNo();
					if (null != firstMenuNo && !"".equals(firstMenuNo))
					{
						SunmnetMenuInfoEntity firstMenuInfoEntity = sunmnetMenuInfoDao.getMenuInfoByMenuNo(firstMenuNo);
						queryMenuInfoByMenuNoResonse.setFirstMenuNo(firstMenuNo);
						queryMenuInfoByMenuNoResonse.setFirstMenuName(firstMenuInfoEntity.getMenuName());
					}
				}
				else
				{
					queryMenuInfoByMenuNoResonse.setFirstMenuNo(parentMenuNo);
					queryMenuInfoByMenuNoResonse.setFirstMenuName(menuInfoEntity.getMenuName());
				}
			}
			queryMenuInfoByMenuNoResonse.setMenuSortNo(sunmnetMenuInfoEntity.getMenuSortNo());
			String systemNo = sunmnetMenuInfoEntity.getSystemNo();
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = sunmnetSystemInfoDao.getSystemInfoBySystemNo(systemNo);
			queryMenuInfoByMenuNoResonse.setSystemNo(systemNo);
			queryMenuInfoByMenuNoResonse.setSystemName(sunmnetSystemInfoEntity.getSystemName());
			
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryMenuInfoByMenuNoResonse);
		} catch (Exception e) {
			logger.error("根据菜单编号查询菜单详细信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 查询用户权限菜单编号服务间调用
     * @param queryUserMenuNoAllRequest
     * @author wm
     * @create 2018-05-27
     * @return
     */
	@Override
	public SystemManageResponseInfo<QueryUserRoleMenuAllResponse> queryUserRoleMenuAll(
			QueryUserRoleMenuAllRequest queryUserRoleMenuAllRequest) {
		SystemManageResponseInfo<QueryUserRoleMenuAllResponse> responseInfo = new SystemManageResponseInfo<QueryUserRoleMenuAllResponse>();		
		try {
			List<String> list = sunmnetMenuInfoDao.queryUserRoleMenuAll(queryUserRoleMenuAllRequest.getUserNo());
			QueryUserRoleMenuAllResponse queryUserRoleMenuAllResponse = new QueryUserRoleMenuAllResponse();
			queryUserRoleMenuAllResponse.setMenuNoList(list);;
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryUserRoleMenuAllResponse);
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
	public SystemManageResponseInfo<QueryUserSystemNoResponse> queryUserSystemNo(
			QueryUserSystemNoRequest queryUserSystemNoRequest) {
		SystemManageResponseInfo<QueryUserSystemNoResponse> responseInfo = new SystemManageResponseInfo<QueryUserSystemNoResponse>();		
		try {
			List<QueryUserSystemNoModel> systemList = sunmnetMenuInfoDao.queryUserSystemNo(queryUserSystemNoRequest.getUserNo());
			QueryUserSystemNoResponse queryUserSystemNoResponse = new QueryUserSystemNoResponse();
			queryUserSystemNoResponse.setSystemList(systemList);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryUserSystemNoResponse);
		} catch (Exception e) {
			logger.error("查询用户拥有的系统权限--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
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
	@Override
	public SystemManageResponseInfo<Object> menuSort(
			MenuSortRequest menuSortRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			String menuNoCom = menuSortRequest.getMenuNoCom();
			String[] menuNoStr = menuNoCom.split(",");
			for(int i=0; i<menuNoStr.length; i++)
			{
				String menuNo = menuNoStr[i];
				SunmnetMenuInfoEntity entity = sunmnetMenuInfoDao.getMenuInfoByMeno(menuNo);
				if(null == entity)
				{
					logger.info("菜单排序--菜单编号不存在;菜单编号："+menuNo);
					responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_MENU);
					return responseInfo;
				}
				else
				{
					entity.setMenuSortNo(String.valueOf(i));
					entity.setLastModifyTime(DateUtil.getDateAndTimes()); //最后修改时间  格式：YYYYMMDDHHmmssSSS
					int count = sunmnetMenuInfoDao.updateMenuInfoByMenuNo(entity);
					if(count!=1){
						logger.info("菜单排序--修改信息失败;详情："+entity.toString());
						responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
						return responseInfo;
					}
				}
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("菜单排序--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

}
