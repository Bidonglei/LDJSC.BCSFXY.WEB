package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import com.sunmnet.bigdata.systemManage.base.support.entity.BaseEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.RelationTypeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.UserStatusEnum;

/**
 * @ClassName SunmnetUserInfoEntity
 * @Description 用户信息表
 * @author wm
 * @date 2018-04-03 18:32:51
 * @version 1.0 
 */
public class SunmnetUserInfoEntity extends BaseEntity{

	private static final long serialVersionUID = 6114167359539258273L;
    //用户编号
    private String userNo;
    //用户姓名
    private String userName;
    //用户昵称
    private String userNickname;
    //用户手机号   唯一约束
    private String userMobile;
    //部门编号
    private String departmentNo;
    //用户邮箱
    private String userMail;
    //用户状态   初始化INIT， 正常 NORMAL,  锁定 LOCK 
    private UserStatusEnum userStatus;
    //用户密码	 （密文）
    private String userPassword;
    //用户和学校教工，学生的关联类型  TEACHER 老师  HEADMASTER 校长
    private RelationTypeEnum  relationType;
    //关联编号  老师和校长的唯一编号
    private String relationNo;
    //创建时间  格式：YYYYMMDDHHmmssSSS
    private String createTime;
    //最后修改时间  格式：YYYYMMDDHHmmssSSS
    private String lastModifyTime;

    public String getUserNo() {
        return userNo;
    }
    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
    public String getUserNickname() {
        return userNickname;
    }
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }
    public String getUserMobile() {
        return userMobile;
    }
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }
    public String getDepartmentNo() {
        return departmentNo;
    }
    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo == null ? null : departmentNo.trim();
    }
    public String getUserMail() {
        return userMail;
    }
    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }
    public UserStatusEnum getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserStatusEnum userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
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
	public RelationTypeEnum getRelationType() {
		return relationType;
	}
	public void setRelationType(RelationTypeEnum relationType) {
		this.relationType = relationType;
	}
	public String getRelationNo() {
		return relationNo;
	}
	public void setRelationNo(String relationNo) {
		this.relationNo = relationNo;
	}

}