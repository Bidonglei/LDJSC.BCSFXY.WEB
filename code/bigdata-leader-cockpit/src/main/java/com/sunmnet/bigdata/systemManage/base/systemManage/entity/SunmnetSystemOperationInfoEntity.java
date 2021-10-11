package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import com.sunmnet.bigdata.systemManage.base.support.entity.BaseEntity;

/**
 * @ClassName SunmnetSystemOperationInfoEntity
 * @Description 管理系统操作日志信息
 * @author wm
 * @date 2018-04-03 18:32:51
 * @version 1.0 
 */
public class SunmnetSystemOperationInfoEntity extends BaseEntity{

	private static final long serialVersionUID = -2614764404786665200L;
	//主键ID
    private Long id;
    //操作管理员编号
    private String adminNo;
    //操作日志简况
    private String content;
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
    public String getAdminNo() {
        return adminNo;
    }
    public void setAdminNo(String adminNo) {
        this.adminNo = adminNo == null ? null : adminNo.trim();
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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