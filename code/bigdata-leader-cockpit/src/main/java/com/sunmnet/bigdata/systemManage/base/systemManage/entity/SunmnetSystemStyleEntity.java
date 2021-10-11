package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

/**
 * @ClassName SunmnetSystemStyleEntity
 * @Description 系统风格设置表
 * @author user
 * @date 2019-01-21 14:47:21
 * @version 1.0 
 */
public class SunmnetSystemStyleEntity {

    //主键ID
    private Long id;
    //系统编号  唯一标识
    private String systemNo;
    //设置位置
    private String setPosition;
    //文件编号
    private String imgNo;
    //图片名称
    private String imgName;
    //  图片存储地址
    private String imgUrl;
    //应用状态 WYY未应用 YYY已应用
    private String applyStatus;
    //图片状态  正常 NORMAL 锁定LOCK 删除 DELETE
    private String fileStatus;
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
    public String getImgNo() {
        return imgNo;
    }
    public void setImgNo(String imgNo) {
        this.imgNo = imgNo == null ? null : imgNo.trim();
    }
    public String getImgName() {
        return imgName;
    }
    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
    public String getApplyStatus() {
        return applyStatus;
    }
    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus == null ? null : applyStatus.trim();
    }
    public String getFileStatus() {
        return fileStatus;
    }
    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus == null ? null : fileStatus.trim();
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