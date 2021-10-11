package com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemManageResultEnum;

public class SystemManageResponseInfo<T> extends BaseResponseInfo<T> {

	private static final long serialVersionUID = 8943079454662950287L;
	
	
	public SystemManageResponseInfo() {
		super();
    }
	public SystemManageResponseInfo(SystemManageResultEnum systemManageResultEnum) {
        setCode(systemManageResultEnum.getCode());
        setMessage(systemManageResultEnum.getMessage());
    }
	public void setSystemManageResponseInfo(SystemManageResultEnum systemManageResultEnum) {
        setCode(systemManageResultEnum.getCode());
        setMessage(systemManageResultEnum.getMessage());
    }
	
	public SystemManageResponseInfo(SystemManageResultEnum systemManageResultEnum,T data) {
		setCode(systemManageResultEnum.getCode());
        setMessage(systemManageResultEnum.getMessage());
        setData(data);
    }
	public void setSystemManageResponseInfo(SystemManageResultEnum systemManageResultEnum,T data) {
		setCode(systemManageResultEnum.getCode());
        setMessage(systemManageResultEnum.getMessage());
        setData(data);
    }
}
