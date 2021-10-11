package com.sunmnet.bigdata.common.enums;

import java.util.ArrayList;
import java.util.List;

import com.sunmnet.bigdata.common.model.TypeModel;


/**
 * 参数屏蔽枚举
 * @author wm
 * @date 2018-01-23
 */
public enum ShieldEnum {
	
	
	MOBILE("mobile","手机号"),
	USER_NAME("userName","用户姓名"),
	BANK_CARD_NO("bankCardNo","银行卡号"),
	IDENTITY_CARD("identityCard","身份证号"),
	PASSWORD("password","密码");
    
    private String code;
    private String message;

    private ShieldEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
     * 获取枚举类型list集合
     * @author wm
     * 2016-08-27
     * @return
     */
    public static List<TypeModel>  getTradeTypeList(){
        List<TypeModel> resultList = null;
        ShieldEnum[] exceptionMsg = ShieldEnum.values();

       if(exceptionMsg != null && exceptionMsg.length > 0){
           resultList = new ArrayList<TypeModel>();
           TypeModel typeModel = null;
           for(ShieldEnum typeEnum:exceptionMsg){
               typeModel = new TypeModel();
               typeModel.setCode(typeEnum.getCode());
               typeModel.setMessage(typeEnum.getMessage());
               resultList.add(typeModel);
           }
        }
       return resultList;
   }
    
    
    /**
     * 获取code和message
     * @author wm
     * 2016-10-24
     * @return
     */
    public static TypeModel  getTradeTypeModel(String param){
    	ShieldEnum typeEnum = ShieldEnum.valueOf(param) ;
    	TypeModel typeModel = new TypeModel();
        typeModel.setCode(typeEnum.getCode());
        typeModel.setMessage(typeEnum.getMessage());
        return typeModel;
   }
}

