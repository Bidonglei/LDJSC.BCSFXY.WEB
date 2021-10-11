package com.sunmnet.bigdata.loginWeb;

import com.sunmnet.bigdata.loginWeb.bean.JsonResult;
import com.sunmnet.bigdata.loginWeb.config.BaseController;
import com.sunmnet.bigdata.loginWeb.supwisdom.CasUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/cas")
public class LogoutController extends BaseController {

    @RequestMapping("/logout")
    public JsonResult logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=================退出登录============");
        HttpSession session = request.getSession();
        if (doLogout(request)) {
            CasUtils.logout(session);
//            response.sendRedirect(CasUtils.getLogoutUrl(request));
            return buildSuccJson(CasUtils.getLogoutUrl(request));
        } else {
//            response.sendRedirect(CasUtils.getLoginUrl(request));
            return buildSuccJson(CasUtils.getLoginUrl(request));
        }
    }

    /**
    * @Title: 处理逻辑
    * @Description: ${todo}
    * ${tags} ${return_type}
    * @throws
    */
    public boolean doLogout(HttpServletRequest request) {

        return true;
    }




}
