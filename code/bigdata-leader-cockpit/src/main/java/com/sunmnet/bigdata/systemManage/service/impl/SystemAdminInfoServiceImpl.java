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
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemAdminInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemAdminMenuInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.AdminStatusEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.AdminTypeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QuerySystemAdminPageModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddSystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteSystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemAdminPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemAdminStutasRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemAdminInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ResetSystemAdminPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SetSystemAdminMenuRoleRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemAdminInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemAdminInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemAdminMenuInfoDao;
import com.sunmnet.bigdata.systemManage.service.SystemAdminInfoService;
import com.sunmnet.bigdata.systemManage.util.MethodUtil;
import com.sunmnet.bigdata.systemManage.util.SequenceUtil;
import com.sunmnet.bigdata.systemManage.util.SystemManageConstants;
/**
 * 管理员信息
 * @author wm
 * @create 2018-04-04
 */
@Service
public class SystemAdminInfoServiceImpl implements SystemAdminInfoService{

	private Logger logger = LoggerFactory.getLogger(SystemAdminInfoServiceImpl.class);
	
	@Autowired
	private SunmnetSystemAdminInfoDao sunmnetSystemAdminInfoDao;
	@Autowired
	private SunmnetSystemAdminMenuInfoDao sunmnetSystemAdminMenuInfoDao;
	
	/**
     * 新增管理员
     * @param addSystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> addSystemAdminInfo(AddSystemAdminInfoRequest addSystemAdminInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = new SunmnetSystemAdminInfoEntity();
			sunmnetSystemAdminInfoEntity.setAdminNo(SequenceUtil.getAdminNo());//管理员编号  唯一约束
		    sunmnetSystemAdminInfoEntity.setAdminName(addSystemAdminInfoRequest.getAdminName());//管理员姓名
		    String adminNickname  = MethodUtil.produceString(SystemManageConstants.ADMINNICKNAME_DIGIT);
		    sunmnetSystemAdminInfoEntity.setAdminNickname(adminNickname);;  // 管理员昵称
		    sunmnetSystemAdminInfoEntity.setAdminMobile(addSystemAdminInfoRequest.getAdminMobile());//管理员手机号
		    sunmnetSystemAdminInfoEntity.setAdminMail(addSystemAdminInfoRequest.getAdminMail());//管理员邮箱
		    sunmnetSystemAdminInfoEntity.setAdminType(AdminTypeEnum.ADMIN);// 管理员类型  SUPERADMIN 超级管理员    ADMIN 管理员
		    sunmnetSystemAdminInfoEntity.setAdminStatus(AdminStatusEnum.NORMAL);//管理员状态  初始化INIT， 正常 NORMAL,  锁定 LOCK 
		    sunmnetSystemAdminInfoEntity.setAdminPassword(SystemManageConstants.ADMIN_INIT_PASSWORD); //管理员密码	（密文）
			sunmnetSystemAdminInfoEntity.setCreateTime(DateUtil.getDateAndTimes());//创建时间  格式：YYYYMMDDHHmmssSSS
		    int count = sunmnetSystemAdminInfoDao.insertSelective(sunmnetSystemAdminInfoEntity);
			if(count!=1){
				logger.info("新增管理员--保存信息失败;详情："+sunmnetSystemAdminInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("新增管理员--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 删除管理员
     * @param deleteSystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> deleteSystemAdminInfo(DeleteSystemAdminInfoRequest deleteSystemAdminInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			String adminNo =  deleteSystemAdminInfoRequest.getAdminNo();
			int count = sunmnetSystemAdminInfoDao.deleteSystemAdminInfoByAdminNo(adminNo);
			if(count!=1){
				logger.info("删除管理员--删除信息失败;管理员编号："+adminNo);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("删除管理员--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	
	/**
     * 修改管理员状态
     * @param modifySystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> modifySystemAdminStatus(ModifySystemAdminStutasRequest modifySystemAdminInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = new SunmnetSystemAdminInfoEntity();
			sunmnetSystemAdminInfoEntity.setAdminNo(modifySystemAdminInfoRequest.getAdminNo());
			sunmnetSystemAdminInfoEntity.setAdminStatus(modifySystemAdminInfoRequest.getAdminStatus());
			sunmnetSystemAdminInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes());
			int count = sunmnetSystemAdminInfoDao.updateSystemAdminStatusByAdminNo(sunmnetSystemAdminInfoEntity);
			if(count!=1){
				logger.info("修改管理员状态--修改信息失败;详情："+sunmnetSystemAdminInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("修改管理员状态--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	
	/**
     * 查询管理员信息列表
     * @param querySystemAdminInfoPageRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@Override
	public SystemManageResponseInfo<PageResult> querySystemAdminInfoPage(QuerySystemAdminInfoPageRequest querySystemAdminInfoPageRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();		
		try {
			int pageNum = querySystemAdminInfoPageRequest.getPageNum(); //  当前页
			int pageSize = querySystemAdminInfoPageRequest.getPageSize();//  每页显示的记录数量
			PageHelper.startPage(pageNum, pageSize);
			List<SunmnetSystemAdminInfoEntity> list = sunmnetSystemAdminInfoDao.findSystemAdminInfo(querySystemAdminInfoPageRequest);
			Page<SunmnetSystemAdminInfoEntity> count = (Page<SunmnetSystemAdminInfoEntity>)list;
			List<QuerySystemAdminPageModel> listData = new ArrayList<QuerySystemAdminPageModel>(); 
			for(SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity : list){
				QuerySystemAdminPageModel querySystemAdminPageModel = new QuerySystemAdminPageModel();
				querySystemAdminPageModel.setAdminNo(sunmnetSystemAdminInfoEntity.getAdminNo());//管理员编号  唯一约束
			    querySystemAdminPageModel.setAdminName(sunmnetSystemAdminInfoEntity.getAdminName()); //管理员姓名
			    querySystemAdminPageModel.setAdminNickname(sunmnetSystemAdminInfoEntity.getAdminNickname()); // 管理员昵称
			    querySystemAdminPageModel.setAdminMobile(sunmnetSystemAdminInfoEntity.getAdminMobile()); //管理员手机号
			    querySystemAdminPageModel.setAdminMail(sunmnetSystemAdminInfoEntity.getAdminMail()); //管理员邮箱
			    querySystemAdminPageModel.setAdminType(sunmnetSystemAdminInfoEntity.getAdminType());// 管理员类型  SUPERADMIN 超级管理员    ADMIN 管理员
			    querySystemAdminPageModel.setAdminTypeStr(sunmnetSystemAdminInfoEntity.getAdminType().getMsg());// 管理员类型  SUPERADMIN 超级管理员    ADMIN 管理员
			    querySystemAdminPageModel.setAdminStatus(sunmnetSystemAdminInfoEntity.getAdminStatus());//管理员状态  初始化INIT， 正常 NORMAL,  锁定 LOCK 
			    querySystemAdminPageModel.setAdminStatusStr(sunmnetSystemAdminInfoEntity.getAdminStatus().getMsg());//管理员状态  初始化INIT， 正常 NORMAL,  锁定 LOCK 
				String createTime = sunmnetSystemAdminInfoEntity.getCreateTime();
				if(!("").equals(createTime)&&createTime!=null){
					querySystemAdminPageModel.setCreateTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,createTime));//创建时间  格式：YYYYMMDDHHmmssSSS
				}
				String lastModifyTime = sunmnetSystemAdminInfoEntity.getLastModifyTime();
				if(!("").equals(lastModifyTime)&&lastModifyTime!=null){
					querySystemAdminPageModel.setLastModifyTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,lastModifyTime));//最后修改时间  格式：YYYYMMDDHHmmssSSS
				}
				listData.add(querySystemAdminPageModel);
			}
			PageResult pageResult = new PageResult(listData, count.getTotal(), pageNum, pageSize);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,pageResult);
		} catch (Exception e) {
			logger.error("查询管理员信息列表--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
		
	}
	
	/**
     * 查询管理员详细信息
     * @param sunmnetSystemAdminInfoEntity
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@Override
	public SystemManageResponseInfo<QuerySystemAdminInfoResponse> querySystemAdminInfo(SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity) {
		SystemManageResponseInfo<QuerySystemAdminInfoResponse> responseInfo = new SystemManageResponseInfo<QuerySystemAdminInfoResponse>();		
		try {
			QuerySystemAdminInfoResponse querySystemAdminInfoResponse = new QuerySystemAdminInfoResponse();
			querySystemAdminInfoResponse.setAdminNo(sunmnetSystemAdminInfoEntity.getAdminNo());//管理员编号  唯一约束
			querySystemAdminInfoResponse.setAdminName(sunmnetSystemAdminInfoEntity.getAdminName());//管理员姓名
			querySystemAdminInfoResponse.setAdminNickname(sunmnetSystemAdminInfoEntity.getAdminNickname());// 管理员昵称
			querySystemAdminInfoResponse.setAdminMobile(sunmnetSystemAdminInfoEntity.getAdminMobile());//管理员手机号
			querySystemAdminInfoResponse.setAdminMail(sunmnetSystemAdminInfoEntity.getAdminMail()); //管理员邮箱
			querySystemAdminInfoResponse.setAdminType(sunmnetSystemAdminInfoEntity.getAdminType()); // 管理员类型  SUPERADMIN 超级管理员    ADMIN 管理员
		    querySystemAdminInfoResponse.setAdminTypeStr(sunmnetSystemAdminInfoEntity.getAdminType().getMsg()); // 管理员类型  SUPERADMIN 超级管理员    ADMIN 管理员
		    querySystemAdminInfoResponse.setAdminStatus(sunmnetSystemAdminInfoEntity.getAdminStatus());//管理员状态  初始化INIT， 正常 NORMAL,  锁定 LOCK
		    querySystemAdminInfoResponse.setAdminStatusStr(sunmnetSystemAdminInfoEntity.getAdminStatus().getMsg());
		    String createTime = sunmnetSystemAdminInfoEntity.getCreateTime();
			if(!("").equals(createTime)&&createTime!=null){
				querySystemAdminInfoResponse.setCreateTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,createTime));//创建时间  格式：YYYYMMDDHHmmssSSS
			}
			String lastModifyTime = sunmnetSystemAdminInfoEntity.getLastModifyTime();
			if(!("").equals(lastModifyTime)&&lastModifyTime!=null){
				querySystemAdminInfoResponse.setLastModifyTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,lastModifyTime));//最后修改时间  格式：YYYYMMDDHHmmssSSS
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,querySystemAdminInfoResponse);
		} catch (Exception e) {
			logger.error("查询管理员详细信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	
	/**
     * 重置管理员秘密
     * @param resetSystemAdminPasswordRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> resetSystemAdminPassword(
			ResetSystemAdminPasswordRequest resetSystemAdminPasswordRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = new SunmnetSystemAdminInfoEntity();
			sunmnetSystemAdminInfoEntity.setAdminNo(resetSystemAdminPasswordRequest.getAdminNo());
			sunmnetSystemAdminInfoEntity.setAdminPassword(SystemManageConstants.ADMIN_INIT_PASSWORD);
			sunmnetSystemAdminInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes());
			int count = sunmnetSystemAdminInfoDao.updateSystemAdminPasswordByAdminNo(sunmnetSystemAdminInfoEntity);
			if(count!=1){
				logger.info("重置管理员秘密--修改信息失败;详情："+sunmnetSystemAdminInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("重置管理员秘密--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 设置管理员菜单权限
     * @param setSystemAdminMenuRoleRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@Transactional
	@Override
	public SystemManageResponseInfo<Object> setSystemAdminMenuRole(SetSystemAdminMenuRoleRequest setSystemAdminMenuRoleRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			String adminNo = setSystemAdminMenuRoleRequest.getAdminNo();
			//1、查询管理员是否设置了菜单权限
			List<SunmnetSystemAdminMenuInfoEntity> list = sunmnetSystemAdminMenuInfoDao.findSystemAdminMenuInfoByAdminNo(adminNo);
			//2、如果设置了菜单权限删除，没有保存菜单权限
			if(list.size()>0){
				//删除原有的菜单权限
				if(sunmnetSystemAdminMenuInfoDao.deleteAdminMenuByAdminNo(adminNo)<0){
					logger.info("设置管理员菜单权限--删除原有权限菜单失败;管理员编号："+adminNo);
					responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
					return responseInfo;
				}
			}
			String [] menuNoList = setSystemAdminMenuRoleRequest.getMenuNoList().split(",");
			for(String menuNo : menuNoList){
				SunmnetSystemAdminMenuInfoEntity sunmnetSystemAdminMenuInfoEntity = new SunmnetSystemAdminMenuInfoEntity();
				sunmnetSystemAdminMenuInfoEntity.setAdminNo(adminNo); //管理员编号
				sunmnetSystemAdminMenuInfoEntity.setMenuNo(menuNo);//菜单编号
				sunmnetSystemAdminMenuInfoEntity.setCreateTime(DateUtil.getDateAndTimes());//创建时间  格式：YYYYMMDDHHmmssSSS
				int count = sunmnetSystemAdminMenuInfoDao.insertSelective(sunmnetSystemAdminMenuInfoEntity);
				if(count!=1){
					logger.info("设置管理员菜单权限--保存信息失败;详情："+sunmnetSystemAdminMenuInfoEntity.toString());
				}
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("设置管理员菜单权限--异常", e);
			throw new RuntimeException();
		}
		return responseInfo;
	}
	
	/**
     * 修改管理员信息
     * @param modifySystemAdminInfoRequest
     * @author wm
     * @create 2018-04-09
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> modifySystemAdminInfo(ModifySystemAdminInfoRequest modifySystemAdminInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = new SunmnetSystemAdminInfoEntity();
			sunmnetSystemAdminInfoEntity.setAdminNo(modifySystemAdminInfoRequest.getAdminNo());//管理员编号  唯一约束
		    sunmnetSystemAdminInfoEntity.setAdminName(modifySystemAdminInfoRequest.getAdminName());//管理员姓名
		    sunmnetSystemAdminInfoEntity.setAdminNickname(modifySystemAdminInfoRequest.getAdminNickname());  // 管理员昵称
		    sunmnetSystemAdminInfoEntity.setAdminMobile(modifySystemAdminInfoRequest.getAdminMobile());//管理员手机号
		    sunmnetSystemAdminInfoEntity.setAdminMail(modifySystemAdminInfoRequest.getAdminMail());//管理员邮箱
			sunmnetSystemAdminInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes());//最后修改时间  格式：YYYYMMDDHHmmssSSS
		    int count = sunmnetSystemAdminInfoDao.updateSystemAdminInfoByAdminNo(sunmnetSystemAdminInfoEntity);
			if(count!=1){
				logger.info("修改管理员信息--修改信息失败;详情："+sunmnetSystemAdminInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("修改管理员信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 修改管理员密码
     * @param modifySystemAdminPasswordRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> modifySystemAdminPassword(ModifySystemAdminPasswordRequest modifySystemAdminPasswordRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = new SunmnetSystemAdminInfoEntity();
			sunmnetSystemAdminInfoEntity.setAdminNo(modifySystemAdminPasswordRequest.getAdminNo());
			sunmnetSystemAdminInfoEntity.setAdminPassword(modifySystemAdminPasswordRequest.getAdminPassword());
			sunmnetSystemAdminInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes());
			int count = sunmnetSystemAdminInfoDao.updateSystemAdminPasswordByAdminNo(sunmnetSystemAdminInfoEntity);
			if(count!=1){
				logger.info("修改管理员密码--修改信息失败;详情："+sunmnetSystemAdminInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("修改管理员密码--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	

}
