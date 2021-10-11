package com.sunmnet.bigdata.systemManage.RemoteController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetUserInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyUserPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserInfoByRelationRequest;
import com.sunmnet.bigdata.systemManage.biz.UserInfoBiz;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;
import com.sunmnet.bigdata.systemManage.controller.BaseController;


/**
 * 用户信息服务间调用
 * @author wm
 * @create 2018-04-10
 */
@RestController
@RequestMapping("/userRemote")
public class UserInfoRemoteController  extends BaseController {
	

	@Autowired
	private UserInfoBiz userInfoBiz;
	
	
	
	/**
     * 查看用户信息
     * @param queryUserInfoRequest
     * @author zfb
     * @create 2018-04-10
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryUserInfoRemote")
    @LoggerManage(description = "查看远程用户详情")
    public BaseResponseInfo<SunmnetUserInfoEntity> queryUserInfoRemote(@RequestBody @Validated QueryUserInfoByRelationRequest queryUserInfoByRelationRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<SunmnetUserInfoEntity> responseInfo = new BaseResponseInfo<SunmnetUserInfoEntity>();
		try {
			responseInfo = userInfoBiz.queryUserInfoRemote(queryUserInfoByRelationRequest);
		} catch (Exception e) {
			logger.error("查看远程用户详情--异常",e);
			return SystemManageException.exception();	
		}
		return responseInfo;
    }
	
	
	
	/**
     * 修改用户密码
     * @param modifyPassword
     * @author zfb
     * @create 2018-04-10
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/modifyPasswordRemote")
    @LoggerManage(description = "远程修改密码")
    public BaseResponseInfo<Object> modifyPasswordRemote(@RequestBody @Validated  ModifyUserPasswordRequest modifyUserPasswordRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = userInfoBiz.modifyPassword(modifyUserPasswordRequest);
		} catch (Exception e) {
			logger.error("远程修改密码--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	
}
