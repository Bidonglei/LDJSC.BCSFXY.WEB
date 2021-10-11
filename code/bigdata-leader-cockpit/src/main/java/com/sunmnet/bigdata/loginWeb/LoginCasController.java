package com.sunmnet.bigdata.loginWeb;

import com.sunmnet.bigdata.loginWeb.config.BaseController;
import com.sunmnet.bigdata.loginWeb.supwisdom.CasUtils;
import com.sunmnet.bigdata.loginWeb.supwisdom.Constants;
import com.sunmnet.bigdata.loginWeb.supwisdom.LoginUser;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.AccountLoginInfo;
import com.sunmnet.bigdata.systemManage.service.LoginLogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sunmnet-gf
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date 2018/12/24/024
 * ${tags}
 */
@RestController
@Api(tags="统一的登陆")
@RequestMapping("/cas")
public class LoginCasController extends BaseController {

	@Autowired
	private LoginLogService loginLogService;

    public boolean doLogin(LoginUser loginUser, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ServletContext application = session.getServletContext();
        // 如果使用了Spring可以用下面的方法获取spring的context对象
        // WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(application);
        // 如果需要使用SpringMVC上下文、可以用下面的方法获取springMVC的context对象
        // WebApplicationContext mvcContext = RequestContextUtils.getWebApplicationContext(request);

        // TODO 需要业务系统重写


        return true;
    }

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String targetUrl = CasUtils.getTargetUrl(request);
        System.out.println("进入login===============:"+targetUrl);
        if (CasUtils.isLogin(session)) {
            LoginUser loginUser = (LoginUser)session.getAttribute(Constants.LOGIN_USER_KEY);
            System.out.println("登录成功============："+loginUser.toString());
            response.sendRedirect(targetUrl);
//            return buildSuccJson(targetUrl);
        } else {
            if (CasUtils.hasTicket(request)) {
                LoginUser loginUser = CasUtils.getLoginUser(request);
                if (loginUser.isLogin() && doLogin(loginUser, request)) {
                	//增加登陆日志
					AccountLoginInfo accountLoginInfo = new AccountLoginInfo();
					accountLoginInfo.setAccount(loginUser.getAccount());
					accountLoginInfo.setName(loginUser.getName());
					accountLoginInfo.setMobile(loginUser.getMobile());
					accountLoginInfo.setDeptCode(loginUser.getDeptCode());
					accountLoginInfo.setDeptName(loginUser.getDeptName());
					accountLoginInfo.setEmail(loginUser.getEmail());
					accountLoginInfo.setIdCard(loginUser.getIdCard());
					loginLogService.addLoginLog(accountLoginInfo);
					CasUtils.login(loginUser, session);
                    response.sendRedirect(targetUrl);
//                    return buildSuccJson(targetUrl);
                } else {
                    // TODO 可选：业务系统可根据实际情况进行处理
                    response.sendRedirect(CasUtils.getErrorUrl(request));
//                    return buildErrJson(CasUtils.getErrorUrl(request));
                }
            } else {
                String loginUrl = CasUtils.getLoginUrl(request);
                System.out.println("登录失败，进入cas============："+loginUrl);
                response.sendRedirect(loginUrl);
//                return buildErrJson("-1",loginUrl);
            }
        }
    }




}
