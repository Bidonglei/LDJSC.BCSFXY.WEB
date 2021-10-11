package com.sunmnet.bigdata.systemManage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.support.util.DateUtil;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetRoleInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetRoleMenuInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryRoleDropdownModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryRoleInfoPageModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRoleInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.RoleSetMenuFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRoleDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRoleInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetRoleInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetRoleMenuInfoDao;
import com.sunmnet.bigdata.systemManage.service.RoleInfoService;
import com.sunmnet.bigdata.systemManage.util.SequenceUtil;
/**
 * 角色信息
 * @author wm
 * @create 2018-04-04
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService{

	private Logger logger = LoggerFactory.getLogger(RoleInfoServiceImpl.class);
	
	@Autowired
	private SunmnetRoleInfoDao sunmnetRoleInfoDao;
	@Autowired
	private SunmnetRoleMenuInfoDao sunmnetRoleMenuInfoDao;
	
	
	/**
     * 添加角色
     * @param addRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> addRoleInfo(AddRoleInfoRequest addRoleInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetRoleInfoEntity sunmnetRoleInfoEntity = new SunmnetRoleInfoEntity();
			sunmnetRoleInfoEntity.setRoleNo(SequenceUtil.getRoleNo());//角色编号  唯一约束
			sunmnetRoleInfoEntity.setRoleName(addRoleInfoRequest.getRoleName());
			sunmnetRoleInfoEntity.setRoleDescribe(addRoleInfoRequest.getRoleDescribe());
			sunmnetRoleInfoEntity.setCreateTime(DateUtil.getDateAndTimes());//创建时间  格式：YYYYMMDDHHmmssSSS
		    int count = sunmnetRoleInfoDao.insertSelective(sunmnetRoleInfoEntity);
			if(count!=1){
				logger.info("添加角色--保存信息失败;详情："+sunmnetRoleInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("添加角色--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 修改角色信息
     * @param modifyRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> modifyRoleInfo(ModifyRoleInfoRequest modifyRoleInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetRoleInfoEntity sunmnetRoleInfoEntity = new SunmnetRoleInfoEntity();
			sunmnetRoleInfoEntity.setRoleNo(modifyRoleInfoRequest.getRoleNo());//角色编号  唯一约束
			sunmnetRoleInfoEntity.setRoleName(modifyRoleInfoRequest.getRoleName());
			sunmnetRoleInfoEntity.setRoleDescribe(modifyRoleInfoRequest.getRoleDescribe());
			sunmnetRoleInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes());//最后修改时间  格式：YYYYMMDDHHmmssSSS
		    int count = sunmnetRoleInfoDao.updateRoleInfoByRoleNo(sunmnetRoleInfoEntity);
			if(count!=1){
				logger.info("修改角色信息--修改信息失败;详情："+sunmnetRoleInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("修改角色信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 删除角色信息
     * @param sunmnetRoleInfoEntity
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> deleteRoleInfo(SunmnetRoleInfoEntity sunmnetRoleInfoEntity) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
		    int count = sunmnetRoleInfoDao.deleteByPrimaryKey(sunmnetRoleInfoEntity.getId());
			if(count!=1){
				logger.info("删除角色信息--删除信息失败;详情："+sunmnetRoleInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("删除角色信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	
	/**
     * 查询角色信息详情
     * @param sunmnetRoleInfoEntity
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@Override
	public SystemManageResponseInfo<QueryRoleInfoResponse> queryRoleInfo(SunmnetRoleInfoEntity sunmnetRoleInfoEntity) {
		SystemManageResponseInfo<QueryRoleInfoResponse> responseInfo = new SystemManageResponseInfo<QueryRoleInfoResponse>();		
		try {
			QueryRoleInfoResponse queryRoleInfoResponse = new QueryRoleInfoResponse();
			queryRoleInfoResponse.setRoleNo(sunmnetRoleInfoEntity.getRoleNo());//角色编号 唯一标识
			queryRoleInfoResponse.setRoleName(sunmnetRoleInfoEntity.getRoleName());//角色名称
			queryRoleInfoResponse.setRoleDescribe(sunmnetRoleInfoEntity.getRoleDescribe());//角色描述
		    String createTime = sunmnetRoleInfoEntity.getCreateTime();
			if(!("").equals(createTime)&&createTime!=null){
				queryRoleInfoResponse.setCreateTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,createTime));//创建时间  格式：YYYYMMDDHHmmssSSS
			}
			String lastModifyTime = sunmnetRoleInfoEntity.getLastModifyTime();
			if(!("").equals(lastModifyTime)&&lastModifyTime!=null){
				queryRoleInfoResponse.setLastModifyTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,lastModifyTime));//最后修改时间  格式：YYYYMMDDHHmmssSSS
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryRoleInfoResponse);
		} catch (Exception e) {
			logger.error("查询角色信息详情--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 分页查询角色信息列表
     * @param queryReleInfoPageRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@Override
	public SystemManageResponseInfo<PageResult> queryRoleInfoPage(QueryRoleInfoPageRequest queryReleInfoPageRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();		
		try {
			int pageNum = queryReleInfoPageRequest.getPageNum(); //  当前页
			int pageSize = queryReleInfoPageRequest.getPageSize();//  每页显示的记录数量
			PageHelper.startPage(pageNum, pageSize);
			List<SunmnetRoleInfoEntity> list = sunmnetRoleInfoDao.findRoleInfo(queryReleInfoPageRequest);
			Page<SunmnetRoleInfoEntity> count = (Page<SunmnetRoleInfoEntity>)list;
			List<QueryRoleInfoPageModel> listData = new ArrayList<QueryRoleInfoPageModel>(); 
			for(SunmnetRoleInfoEntity sunmnetRoleInfoEntity : list){
				QueryRoleInfoPageModel queryRoleInfoPageModel = new QueryRoleInfoPageModel();
				queryRoleInfoPageModel.setRoleNo(sunmnetRoleInfoEntity.getRoleNo());//角色编号 唯一标识
			    queryRoleInfoPageModel.setRoleName(sunmnetRoleInfoEntity.getRoleName()); //角色名称
			    queryRoleInfoPageModel.setRoleDescribe(sunmnetRoleInfoEntity.getRoleDescribe());//角色描述
				String createTime = sunmnetRoleInfoEntity.getCreateTime();
				if(!("").equals(createTime)&&createTime!=null){
					queryRoleInfoPageModel.setCreateTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,createTime));//创建时间  格式：YYYYMMDDHHmmssSSS
				}
				String lastModifyTime = sunmnetRoleInfoEntity.getLastModifyTime();
				if(!("").equals(lastModifyTime)&&lastModifyTime!=null){
					queryRoleInfoPageModel.setLastModifyTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,lastModifyTime));//最后修改时间  格式：YYYYMMDDHHmmssSSS
				}
				listData.add(queryRoleInfoPageModel);
			}
			PageResult pageResult = new PageResult(listData, count.getTotal(), pageNum, pageSize);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,pageResult);
		} catch (Exception e) {
			logger.error("分页查询角色信息列表--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 角色授权菜单、功能点
     * @param roleSetMenuFunctionRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	@Transactional
	@Override
	public SystemManageResponseInfo<Object> roleSetMenuFunction(RoleSetMenuFunctionRequest roleSetMenuFunctionRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			String roleNo = roleSetMenuFunctionRequest.getRoleNo();//角色编号 唯一标识
			//1、查询角色是否已经授权了菜单功能点
			List<String> menuNoList  = sunmnetRoleMenuInfoDao.getRoleMenuCountByRoleNo(roleNo);
			if(menuNoList.size()>0){
				//删除原有的已经授权了菜单功能点
				if(sunmnetRoleMenuInfoDao.deleteRoleMenuInfoByRoleNo(roleNo)<0){
					logger.info("角色授权菜单、功能点--删除原有的已经授权了菜单功能点失败;角色编号："+roleNo);
					responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
					return responseInfo;
				}
			}
			String [] menuList = roleSetMenuFunctionRequest.getMenuList().split(",");//菜单功能点集合
			for(String menuNo : menuList){
				SunmnetRoleMenuInfoEntity sunmnetRoleMenuInfoEntity = new SunmnetRoleMenuInfoEntity();
				sunmnetRoleMenuInfoEntity.setRoleNo(roleNo);
				sunmnetRoleMenuInfoEntity.setMenuNo(menuNo);
				sunmnetRoleMenuInfoEntity.setCreateTime(DateUtil.getDateAndTimes());
				int count = sunmnetRoleMenuInfoDao.insertSelective(sunmnetRoleMenuInfoEntity);
				if(count!=1){
					logger.info("角色授权菜单、功能点--保存信息失败;详情："+sunmnetRoleMenuInfoEntity.toString());
				}
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("角色授权菜单、功能点--异常", e);
			throw new RuntimeException();
		}
		return responseInfo;
	}

	/**
     * 查询角色下拉框     
     * @author zfb
     * @create 2018-04-11
     * @return
     */
	@Override
	public SystemManageResponseInfo<QueryRoleDropdownResponse> queryRoleDropdown() {
		SystemManageResponseInfo<QueryRoleDropdownResponse> responseInfo = new SystemManageResponseInfo<QueryRoleDropdownResponse>();		
		try {
			List<QueryRoleDropdownModel> list = sunmnetRoleInfoDao.queryRoleDropdown();
			QueryRoleDropdownResponse queryRoleDropdownResponse = new QueryRoleDropdownResponse();
			queryRoleDropdownResponse.setList(list);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryRoleDropdownResponse);
		} catch (Exception e) {
			logger.error("角色信息下拉框选择--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	

}
