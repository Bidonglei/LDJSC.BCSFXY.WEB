package com.sunmnet.bigdata.systemManage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.systemManage.base.support.beanUtil.BeanUtils;
import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.support.util.DateUtil;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetDepartmentInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetUserInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetUserRoleInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.*;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.*;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.*;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRemoteStudentListGroupResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRemoteTeacherListGroupResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserRoleInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.dao.systemManage.IndexInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetDepartmentInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetUserInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetUserRoleInfoDao;
import com.sunmnet.bigdata.systemManage.service.DiagnosisStudentService;
import com.sunmnet.bigdata.systemManage.service.DiagnosisTeacherService;
import com.sunmnet.bigdata.systemManage.service.IndexInfoService;
import com.sunmnet.bigdata.systemManage.service.UserInfoService;
import com.sunmnet.bigdata.systemManage.util.MethodUtil;
import com.sunmnet.bigdata.systemManage.util.SequenceUtil;
import com.sunmnet.bigdata.systemManage.util.SystemManageConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *功能描述 指标
 * @author lkg
 * @date 2019/5/30
 */
@Service
public class IndexInfoServiceImpl implements IndexInfoService {

	private Logger logger = LoggerFactory.getLogger(IndexInfoServiceImpl.class);
	
	@Autowired
	private IndexInfoDao indexInfoDao;


	@Override
	public SystemManageResponseInfo<Object> indexInfo(IndexInfoRequest indexInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			List<Map> list = null;
			if (StringUtil.isEmpty(indexInfoRequest.getIndexDate())){
				list = indexInfoDao.indexInfo(indexInfoRequest);//页面指标值
			}else{
				list = indexInfoDao.historyIndexInfo(indexInfoRequest);//页面历史指标值

			}
				responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,list);
		} catch (Exception e) {
			logger.error("通过组件编号获取指标--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	@Override
	public SystemManageResponseInfo<Object> addIndexInfo(AddIndexInfoRequest addIndexInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			addIndexInfoRequest.setIndexCode(SequenceUtil.getIndexNo());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			addIndexInfoRequest.setCreateTime(f.format(new Date()));
			int i = indexInfoDao.insertSelective(addIndexInfoRequest);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,i);
		} catch (Exception e) {
			logger.error("通过组件编号获取指标--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}


	@Override
	public SystemManageResponseInfo<Object> listPageFunctional(IndexInfoRequest indexInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			List<Map> list = indexInfoDao.listPageFunctional(indexInfoRequest);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,list);
		} catch (Exception e) {
			logger.error("获取四级功能点--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	@Override
	public SystemManageResponseInfo<Object> searchMenu(String content) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			List<Map> list = indexInfoDao.searchFunctional(content);
			for (Map m:list){
				StringBuilder menuString = new StringBuilder();
				String twoMenuNo = (String)m.get("twoMenuNo");
				String threeMenuName = (String)m.get("threeMenuName");//三级菜单名称
				menuString.append(threeMenuName);
				menuString = menuString(twoMenuNo,menuString);
				m.put("menuName",menuString.toString());
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,list);
		} catch (Exception e) {
			logger.error("搜索三级菜单--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	@Override
	public SystemManageResponseInfo<Object> pageDataSource(String menuNo) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			Map<String, Object> resultInfo = new HashMap<>();
			List<Map> list = indexInfoDao.pageDataSource(menuNo);
			int noCount = 0;//无数据个数
			int realCount = 0;//真实数据的个数
			for (Map m:list) {
				String dataType = (String)m.get("dataTypeCode");
				if ("NO".equals(dataType)){
					noCount++;
				}
				if ("REAL".equals(dataType)){
					realCount++;
				}
			}
			if (noCount != 0){
				resultInfo.put("dataJudge",3);//“无数据”不等于0，则为红色"数据报告"，设置为3
			}else {
				if (realCount == list.size()){
					resultInfo.put("dataJudge",1);//全部为“真实数据”，则为绿色"数据报告"，设置为1
				}else {
					resultInfo.put("dataJudge",2);//不全为“真实数据”，则为橙色"数据报告"，设置为2
				}
			}
			resultInfo.put("list",list);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,resultInfo);
		} catch (Exception e) {
			logger.error("获取数据报告--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/*
		public SystemManageResponseInfo<Object> searchMenu(String content) {
			SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
			try {
				List<Map> funList = indexInfoDao.searchFunctional(content);
				for (Map m:funList){
					StringBuilder menuString = new StringBuilder();
					String menuNo = (String)m.get("menuNo");
					String functional = (String)m.get("functional");//功能点名称
					menuString.append(functional);
					menuString = menuString(menuNo,menuString);
					m.put("menuName",menuString.toString());
				}
				responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,funList);
			} catch (Exception e) {
				logger.error("搜索四级功能点--异常", e);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
			}
			return responseInfo;
		}
	*/
	//获取目录层级，拼接目录名字
	private StringBuilder menuString(String menuNo,StringBuilder menuString){
		Map parentMenu = indexInfoDao.getParentMenu(menuNo);
		String parentMenuNo= (String)parentMenu.get("parentMenuNo");
		String menuName= (String)parentMenu.get("menuName");
		menuString.insert(0,"->");
		menuString.insert(0,menuName);
//		temp = menuName + "->" + temp;
		if (StringUtil.isNotEmpty(parentMenuNo)){
			menuString(parentMenuNo,menuString);
		}
		return menuString;
	}
}
