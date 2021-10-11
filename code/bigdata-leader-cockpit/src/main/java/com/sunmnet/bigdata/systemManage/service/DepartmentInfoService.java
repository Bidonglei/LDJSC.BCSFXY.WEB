package com.sunmnet.bigdata.systemManage.service;

import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetDepartmentInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddDepartmentInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyDepartmentInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyDepartmentStatusRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDepartmentInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDepartmentDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDepartmentInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;



/**
 * 部门信息
 * @author wm
 * @create 2018-03-21
 */
public interface DepartmentInfoService {
	/**
     * 部门信息下拉框选择
     * @author wm
     * @create 2018-03-23
     * @return
     */
	public SystemManageResponseInfo<QueryDepartmentDropdownResponse> queryDepartmentDropdown();
	
	/**
     * 分页查询部门信息
     * @param queryDepartmentInfoPageRequest
     * @author wth
     * @create 2018-03-27
     * @return
     */
	public SystemManageResponseInfo<PageResult> query(QueryDepartmentInfoPageRequest queryDepartmentInfoPageRequest);

	/**
     * 增加部门信息
     * @param addDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	public SystemManageResponseInfo<Object> addDepartmentInfo(AddDepartmentInfoRequest addDepartmentInfoRequest);

	/**
     * 删除部门信息
     * @param departmentNo
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	public SystemManageResponseInfo<Object> deleteDepartmentInfo(String departmentNo);

	/**
     * 修改部门状态
     * @param modifyDepartmentStatusRequest
     * @param sunmnetDepartmentInfoEntity
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	public SystemManageResponseInfo<Object> modifyDepartmentStatus(
			ModifyDepartmentStatusRequest modifyDepartmentStatusRequest,
			SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity);

	/**
     * 查看部门详情
     * @param sunmnetDepartmentInfoEntity
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	public SystemManageResponseInfo<QueryDepartmentInfoResponse> queryDepartmentInfoByDepartmentNo(
			SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity);

	/**
     * 修改部门信息
     * @param modifyDepartmentInfoRequest
     * @param sunmnetDepartmentInfoEntity
     * @author zfb
     * @create 2018-04-09
     * @return
     */
	public SystemManageResponseInfo<Object> modifyDepartmentInfo(ModifyDepartmentInfoRequest modifyDepartmentInfoRequest,
			SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity);
	/**
     * 同步教职工部门信息
     * @param 
     * @author wm
     * @create 2018-06-28
     * @return
     */
	public SystemManageResponseInfo<Object> generationDepartmentInfoTeacher();
}
