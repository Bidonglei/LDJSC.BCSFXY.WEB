package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

/**
 * @ClassName SunmnetSystemColorEntity
 * @Description 系统颜色设置表
 * @author user
 * @date 2019-01-21 14:14:41
 * @version 1.0 
 */
public class SunmnetSystemColorEntity {

    //主键ID
    private Long id;
    //系统编号  唯一标识
    private String systemNo;
    //设置位置
    private String setPosition;
    //颜色
    private String colorName;
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
    public String getSystemNo() {
        return systemNo;
    }
    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo == null ? null : systemNo.trim();
    }
    public String getSetPosition() {
        return setPosition;
    }
    public void setSetPosition(String setPosition) {
        this.setPosition = setPosition == null ? null : setPosition.trim();
    }
    public String getColorName() {
        return colorName;
    }
    public void setColorName(String colorName) {
        this.colorName = colorName == null ? null : colorName.trim();
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