package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

import java.util.ArrayList;
import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryTeacherDropDownModel;


/**
 * 是否离职退休  YES 是  NO 否
 * @author wm
 * @create 2018-06-22
 * @return
 */
public enum IsQuitEnum {
	
	//是否离职退休  YES 是  NO 否

	YES("YES", "是"),
	NO("NO", "否");
	

	private String code;
	private String msg;

	private IsQuitEnum(String code, String msg) {
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
        IsQuitEnum[] exceptionMsg = IsQuitEnum.values();

       if(exceptionMsg != null && exceptionMsg.length > 0){
           resultList = new ArrayList<QueryTeacherDropDownModel>();
           QueryTeacherDropDownModel typeModel = null;
           for(IsQuitEnum typeEnum:exceptionMsg){
               typeModel = new QueryTeacherDropDownModel();
               typeModel.setModelKey(typeEnum.getCode());
               typeModel.setModelName(typeEnum.getMsg());
               resultList.add(typeModel);
           }
        }
       return resultList;
   }
}
