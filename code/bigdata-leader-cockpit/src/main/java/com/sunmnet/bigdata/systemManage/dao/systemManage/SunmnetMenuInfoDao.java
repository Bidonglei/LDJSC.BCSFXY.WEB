package com.sunmnet.bigdata.systemManage.dao.systemManage;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetMenuInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.MenuInfoModelInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryMenuDownDropdownModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryMenuDropdownModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryMenuInfoRequestModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryRoleMenuInfoRequestModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryUserRoleMenuInfoRemoteRequestModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryUserSystemNoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.RoleMenuInfoModelInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMenuDownDropdownRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMenuDropdownRequest;

public interface SunmnetMenuInfoDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetMenuInfoEntity record);

    public SunmnetMenuInfoEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetMenuInfoEntity record);

	/**
     * 根据系统编号查询系统菜单
     * @param systemNo
     * @author wm
     * @create 2018-03-30
     * @return
     */
	public List<SunmnetMenuInfoEntity> findMenuInfoBySystemNo(String systemNo);

	/**
	 * 根据菜单编号查询菜单信息
	 * @param menuNo
	 * @author wm
	 * @create 2018-04-07
	 */
	public SunmnetMenuInfoEntity getMenuInfoByMeno(String menuNo);
	/**
     * 根据菜单编号修改菜单信息
     * @param sunmnetMenuInfoEntity
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public int updateMenuInfoByMenuNo(SunmnetMenuInfoEntity sunmnetMenuInfoEntity);

	/**
     * 根据功能点编号修改功能点信息
     * @param sunmnetMenuInfoEntity
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public int updateMenuFunctionByMenuNo(SunmnetMenuInfoEntity sunmnetMenuInfoEntity);

	/**
	 * 查询菜单下拉框
	 * @param queryMenuDorpdownRequest
	 * @author zfb
	 * @create 2018-04-08
	 */
	public List<QueryMenuDropdownModel> queryMenuDropdown(QueryMenuDropdownRequest queryMenuDorpdownRequest);
	/**
     * 查询角色授权的菜单信息,和角色已经拥有的角色
     * @param queryRoleMenuInfoRequestModel
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public List<RoleMenuInfoModelInfo> findSetRoleMenuInfo(QueryRoleMenuInfoRequestModel queryRoleMenuInfoRequestModel);

	/**
     * 查询角色授权的菜单信息,和角色已经拥有的角色
     * @param queryMenuInfoRequestModel
     * @author zfb
     * @create 2018-04-12
     * @return
     */
	public List<MenuInfoModelInfo> findSetMenuInfo(QueryMenuInfoRequestModel queryMenuInfoRequestModel);
	/**
     * 查询用户登录的权限菜单信息服务间调用根据用户编号和系统编号
     * @param queryUserRoleMenuInfoRemoteRequestModel
     * @author wm
     * @create 2018-04-12
     * @return
     */
	public List<MenuInfoModelInfo> findUserRoleMenuInfo(QueryUserRoleMenuInfoRemoteRequestModel queryUserRoleMenuInfoRemoteRequestModel);
	/**
     * 根据菜单编号查询菜单下级菜单
     * @author wm
     * @create 2018-04-12
     * @return
     */
	public List<QueryMenuDownDropdownModel> queryMenuDownDropdown(
			QueryMenuDownDropdownRequest queryMenuDownDropdownRequest);

	/**
     * 根据菜单编号查询菜单详细信息
     * @param menuNo
     * @author zfb
     * @create 2018-04-13
     * @return
     */
	public SunmnetMenuInfoEntity getMenuInfoByMenuNo(String menuNo);
	/**
     * 查询用户权限菜单编号服务间调用
     * @param queryUserMenuNoAllRequest
     * @author wm
     * @create 2018-05-27
     * @return
     */
	public List<String> queryUserRoleMenuAll(String userNo);

	/**
     * 根据菜单编号查询子菜单或者子功能点
     * @param menuNo
     * @author zfb
     * @create 2018-07-04
     * @return
     */
	public List<SunmnetMenuInfoEntity> getChildMenuInfoByMeno(String menuNo);
	/**
     * 查询用户拥有的系统权限
     * @param queryUserSystemNoRequest
     * @author wm
     * @create 2018-07-31
     * @return
     */
	public List<QueryUserSystemNoModel> queryUserSystemNo(String userNo);


}