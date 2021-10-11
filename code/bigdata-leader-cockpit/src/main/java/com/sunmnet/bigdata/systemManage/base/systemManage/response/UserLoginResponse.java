package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.RelationTypeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryUserSystemNoModel;

/**
 * @Description: 用户登录返回参数
 * @author wm
 * @date 2018-04-10
 * @version 1.0
 */
public class UserLoginResponse extends BaseResponse {

	private static final long serialVersionUID = 8351649838436920471L;
	private String userNo;//用户编号
    private String userName; //用户姓名
    //用户和学校教工，学生的关联类型  TEACHER 老师  HEADMASTER 校长  STUDENT学生
    private RelationTypeEnum  relationType;
    //关联编号  老师和校长的唯一编号
    private String relationNo;
    //系统编号集合
    private List<QueryUserSystemNoModel> systemList;
    private String token;//session token
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<QueryUserSystemNoModel> getSystemList() {
		return systemList;
	}
	public void setSystemList(List<QueryUserSystemNoModel> systemList) {
		this.systemList = systemList;
	}
}