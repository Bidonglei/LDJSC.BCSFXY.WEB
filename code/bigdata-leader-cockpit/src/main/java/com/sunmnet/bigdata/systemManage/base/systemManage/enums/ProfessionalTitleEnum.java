package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

import java.util.ArrayList;
import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryTeacherDropDownModel;


/**
 * 职称枚举
 * @author fr
 * @create 2018-05-21
 * @return
 */
public enum ProfessionalTitleEnum {

	JS("JS", "教授"),
	JSGJGCS("JSGJGCS", "教授级高级工程师"),
	FJS("FJS", "副教授"),
	GJGCS("GJGCS", "高级工程师"),
	JIANGSHI("JIANGSHI", "讲师"),
	GCS("GCS", "工程师"),
	ZJ("ZJ", "助教"),
	ZLGCS("ZLGCS", "助理工程师"),
	GJJS("GJJS", "高级技师"),
	QT("QT", "其他"),
	JISHI("JISHI", "技师");
	

	private String code;
	private String msg;

	private ProfessionalTitleEnum(String code, String msg) {
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
        ProfessionalTitleEnum[] exceptionMsg = ProfessionalTitleEnum.values();

       if(exceptionMsg != null && exceptionMsg.length > 0){
           resultList = new ArrayList<QueryTeacherDropDownModel>();
           QueryTeacherDropDownModel typeModel = null;
           for(ProfessionalTitleEnum typeEnum:exceptionMsg){
               typeModel = new QueryTeacherDropDownModel();
               typeModel.setModelKey(typeEnum.getCode());
               typeModel.setModelName(typeEnum.getMsg());
               resultList.add(typeModel);
           }
        }
       return resultList;
   }
}
