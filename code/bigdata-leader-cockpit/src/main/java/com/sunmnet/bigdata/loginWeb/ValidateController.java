package com.sunmnet.bigdata.loginWeb;

import com.sunmnet.bigdata.loginWeb.bean.JsonResult;
import com.sunmnet.bigdata.loginWeb.config.BaseController;
import com.sunmnet.bigdata.loginWeb.supwisdom.CasUtils;
import com.sunmnet.bigdata.loginWeb.supwisdom.Constants;
import com.sunmnet.bigdata.loginWeb.supwisdom.LoginUser;
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
 * @date 2018/12/24/025
 * ${tags}
 */
@RestController
@RequestMapping("/cas")
public class ValidateController extends BaseController {


    @RequestMapping("/validate")
    public JsonResult login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (CasUtils.isLogin(session)) {
            LoginUser loginUser = (LoginUser)session.getAttribute(Constants.LOGIN_USER_KEY);
            return buildSuccJson(loginUser);
        } else {
            String loginUrl = CasUtils.getLoginUrl(request);
//            return buildErrJson("-1",loginUrl);
            return buildJson(false,"-1","请登录",loginUrl);
        }
    }




}
