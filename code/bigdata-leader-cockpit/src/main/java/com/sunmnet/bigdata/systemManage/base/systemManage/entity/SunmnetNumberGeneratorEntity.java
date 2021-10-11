package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import com.sunmnet.bigdata.systemManage.base.support.entity.BaseEntity;

/**
 * @ClassName SunmnetNumberGeneratorEntity
 * @Description 菜单编号生成表
 * @author sum
 * @date 2018-05-20 17:32:35
 * @version 1.0 
 */
public class SunmnetNumberGeneratorEntity extends BaseEntity{

	private static final long serialVersionUID = -2523787764374619057L;
	//主键自增
    private Long id;
    //编号
    private Long number;
    // 创建时间  格式：YYYYMMDDHHmmss
    private String createTime;
    //最后修改时间  格式：YYYYMMDDHHmmss
    private String lastModifyTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getNumber() {
        return number;
    }
    public void setNumber(Long number) {
        this.number = number;
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