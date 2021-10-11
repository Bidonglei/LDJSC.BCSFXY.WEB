package com.sunmnet.bigdata.loginWeb.supwisdom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

/**
 * @author sunmnet-gf
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date 2018/12/24/024
 * ${tags}
 */
@Component
public class Constants {
    // CAS根地址
    public static String CAS_BASE_PATH = "https://uis.nwpu.edu.cn/cas/";  // 西工大地址
//    String CAS_BASE_PATH = "http://authserver.sisu.edu.cn/authserver/";

    // 业务系统需要显式使用的端口配置，包括80端口，如果不需要配置显式端口，则配置空字符串""即可
	public static String CLIENT_SYSTEM_EXPLICIT_PORT = "";

    // CAS票据验证地址
	public static String CAS_VALIDATE_URL = CAS_BASE_PATH + "serviceValidate";  // 西工大地址
//    String CAS_VALIDATE_URL = CAS_BASE_PATH + "validate";

    // CAS登录地址
	public static String CAS_LOGIN_URL = CAS_BASE_PATH + "login";

    // CAS注销地址
	public static String CAS_LOGOUT_URL = CAS_BASE_PATH + "logout";

    //登录成功默认跳转地址
//    String DEF_TARGET_URI = "sso/index.jsp";
	public static String DEF_TARGET_URI;  // 西工大地址
//    String DEF_TARGET_URI = "http://202.202.198.57/";
	@Value("${DEF_TARGET_URI}")
	public void setDefTargetUri( String defTargetUri) {
		Constants.DEF_TARGET_URI = defTargetUri;
	}

    // 业务系统认证集成改造之后的登录URI
//    String SSO_LOGIN_URI = "sso/login.jsp";

	public static String SSO_LOGIN_URI;  // 西工大地址
//    String SSO_LOGIN_URI = "http://202.202.198.57/cas/login";

	@Value("${SSO_LOGIN_URI}")
	public void setAdminInitPassWord( String ssoLoginUri) {
		Constants.SSO_LOGIN_URI = ssoLoginUri;
	}

    // 业务系统认证集成失败提示页
	public static String SSO_ERROR_URI = "error.jsp";

    // REQUEST中获取需要跳转URL的KEY
	public static String TARGET_URL_KEY = "targetUrl";

    // SESSION中判断是否登录的KEY
	public static String LOGIN_KEY = "isSupwisdomCasLogin";
	public static String LOGIN_USER_KEY = "supwisdomCasLoginUser";

    // REQUEST中获取票据的KEY
	public static String TICKET_KEY = "ticket";

    // CAS Server验证成功后需跳转客户端Url的Key
	public static String SERVICE_KEY = "service";

    // BASE64编码的前缀
	public static String BASE64_PREFIX = "base64";

    // 默认编码字符串格式
	public static String UTF_8_STR = "UTF-8";

    // 默认编码
	public static Charset UTF_8 = Charset.forName(UTF_8_STR);

    // Ticket验证超时时间
	public static int CONNECT_TIMEOUT = 5000;
}
