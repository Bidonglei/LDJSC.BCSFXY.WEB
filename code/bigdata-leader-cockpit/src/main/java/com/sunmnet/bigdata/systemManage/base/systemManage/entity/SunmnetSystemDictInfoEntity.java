package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import com.sunmnet.bigdata.systemManage.base.support.entity.BaseEntity;

/**
 * @ClassName SunmnetSystemDictInfoEntity
 * @Description 数据字典表
 * @author user
 * @date 2018-09-17 09:58:47
 * @version 1.0 
 */
public class SunmnetSystemDictInfoEntity extends BaseEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6972252144012723810L;
	// id 主键自增
    private Long id;
    //字典类型
    private String dictType;
    //字典名称
    private String dictName;
    //字典键
    private String dictKey;
    //字典值
    private String dictValue;
    //描述
    private String dictDescribe;
    //创建时间  格式：YYYYMMDDHHmmss
    private String createTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDictType() {
        return dictType;
    }
    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim();
    }
    public String getDictName() {
        return dictName;
    }
    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }
    public String getDictKey() {
        return dictKey;
    }
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey == null ? null : dictKey.trim();
    }
    public String getDictValue() {
        return dictValue;
    }
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }
    public String getDictDescribe() {
        return dictDescribe;
    }
    public void setDictDescribe(String dictDescribe) {
        this.dictDescribe = dictDescribe == null ? null : dictDescribe.trim();
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

}