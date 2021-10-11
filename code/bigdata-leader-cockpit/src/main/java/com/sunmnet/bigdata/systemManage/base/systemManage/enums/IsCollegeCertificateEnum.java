package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

import java.util.ArrayList;
import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryTeacherDropDownModel;


/**
 * 是否具备高校教师资格证
 * @author wm
 * @create 2018-06-22
 * @return
 */
public enum IsCollegeCertificateEnum {
	
	//是否具备高校教师资格证( YES 是  NO 否)

	YES("YES", "是"),
	NO("NO", "否");
	

	private String code;
	private String msg;

	private IsCollegeCertificateEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
     * 获取枚举类型list集合
     * @author 
     * @return
     */
    public static List<QueryTeacherDropDownModel>  getProfessionalTypeList(){
        List<QueryTeacherDropDownModel> resultList = null;
        IsCollegeCertificateEnum[] exceptionMsg = IsCollegeCertificateEnum.values();

       if(exceptionMsg != null && exceptionMsg.length > 0){
           resultList = new ArrayList<QueryTeacherDropDownModel>();
           QueryTeacherDropDownModel typeModel = null;
           for(IsCollegeCertificateEnum typeEnum:exceptionMsg){
               typeModel = new QueryTeacherDropDownModel();
               typeModel.setModelKey(typeEnum.getCode());
               typeModel.setModelName(typeEnum.getMsg());
               resultList.add(typeModel);
           }
        }
       return resultList;
   }
}
