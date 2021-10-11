package com.sunmnet.bigdata.systemManage.biz;

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



/**
 * 部门信息校验
 * @author wm
 * @create 2018-03-21
 */
public interface DepartmentInfoBiz {
	/**
     * 部门信息下拉框选择
     * @author wm
     * @create 2018-03-23
     * @return
     */
	public BaseResponseInfo<QueryDepartmentDropdownResponse> queryDepartmentDropdown();
	
	/**
     * 分页查询部门信息列表
     * @param queryDepartmentInfoPageRequest
     * @author wth
     * @create 2018-03-27
     * @return
     */
	public BaseResponseInfo<PageResult> query(QueryDepartmentInfoPageRequest queryDepartmentInfoPageRequest);

	/**
     * 增加部门
     * @param addDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public BaseResponseInfo<Object> add(AddDepartmentInfoRequest addDepartmentInfoRequest);

	/**
     * 删除部门信息
     * @param deleteDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	public BaseResponseInfo<Object> deleteDepartmentInfo(DeleteDepartmentInfoRequest deleteDepartmentInfoRequest);

	/**
     * 修改部门状态
     * @param modifyDepartmentStatusRequest
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	public BaseResponseInfo<Object> modifyDepartmentStatus(
			ModifyDepartmentStatusRequest modifyDepartmentStatusRequest);

	/**
     * 查询部门详细信息
     * @param queryDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	public BaseResponseInfo<QueryDepartmentInfoResponse> queryDepartmentInfo(
			QueryDepartmentInfoRequest queryDepartmentInfoRequest);

	/**
     * 修改部门信息
     * @param modifyDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-09
     * @return
     */
	public BaseResponseInfo<Object> modifyDepartmentInfo(ModifyDepartmentInfoRequest modifyDepartmentInfoRequest);
	/**
     * 同步教职工部门信息
     * @param 
     * @author wm
     * @create 2018-06-28
     * @return
     */
	public BaseResponseInfo<Object> generationDepartmentInfoTeacher();
}
