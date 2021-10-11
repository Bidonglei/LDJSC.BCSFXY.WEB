package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import com.sunmnet.bigdata.systemManage.base.support.entity.BaseEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.MenuLevelEnum;

/**
 * @ClassName SunmnetMenuInfoEntity
 * @Description 菜单信息表
 * @author wm
 * @date 2018-04-03 18:32:51
 * @version 1.0 
 */
public class SunmnetMenuInfoEntity extends BaseEntity{

	private static final long serialVersionUID = 3686494567783091483L;
	//主键ID
    private Long id;
    //菜单编号唯一标识
    private String menuNo;
    //菜单名称
    private String menuName;
    //菜单URL地址
    private String menuUrl;
    //菜单级别  等级  ONE 主菜单 TWO 子菜单  THREE 级为功能按钮
    private MenuLevelEnum menuLevel;
    //上级菜单编号
    private String parentMenuNo;
    //菜单排序序号
    private String menuSortNo;
    //菜单所属系统编号
    private String systemNo;
    //创建时间  格式：YYYYMMDDHHmmssSSS
    private String createTime;
    //最后修改时间  格式：YYYYMMDDHHmmssSSS
    private String lastModifyTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMenuNo() {
        return menuNo;
    }
    public void setMenuNo(String menuNo) {
        this.menuNo = menuNo == null ? null : menuNo.trim();
    }
    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }
    public String getMenuUrl() {
        return menuUrl;
    }
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }
    
    public MenuLevelEnum getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(MenuLevelEnum menuLevel) {
		this.menuLevel = menuLevel;
	}
	public String getParentMenuNo() {
        return parentMenuNo;
    }
    public void setParentMenuNo(String parentMenuNo) {
        this.parentMenuNo = parentMenuNo == null ? null : parentMenuNo.trim();
    }
    public String getMenuSortNo() {
        return menuSortNo;
    }
    public void setMenuSortNo(String menuSortNo) {
        this.menuSortNo = menuSortNo == null ? null : menuSortNo.trim();
    }
    public String getSystemNo() {
        return systemNo;
    }
    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo == null ? null : systemNo.trim();
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
    public String getLastModifyTime() {
        return lastModifyTime;
    }
    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime == null ? null : lastModifyTime.trim();
    }

}