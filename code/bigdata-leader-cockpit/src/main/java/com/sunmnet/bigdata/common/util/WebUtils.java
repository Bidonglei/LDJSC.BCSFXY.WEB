package com.sunmnet.bigdata.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Pattern;

public final class WebUtils {
    public static final Pattern intranetIpPattern = Pattern.compile(
            "(^127\\.)|(^10\\.)|(^172\\.1[6-9]\\.)|(^172\\.2[0-9]\\.)|(^172\\.3[0-1]\\.)|(^192\\.168\\.)|(^::1$)"
    );

    private static final Logger LOG = LoggerFactory.getLogger(CookieUtils.class);

    private WebUtils() {
    }

    public static String getBasePath(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String port = request.getServerPort() == 80 ? "" : ":" + request.getServerPort();
        String basePath = request.getScheme() + "://" + request.getServerName() + port + contextPath;

        LOG.info("Util: WebUtil.getBasePath, Return: {}.", basePath);
        return basePath;
    }

    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }

    public static boolean isGet(HttpServletRequest request) {
        return "get".equalsIgnoreCase(request.getMethod());
    }

    public static boolean isPost(HttpServletRequest request) {
        return "post".equalsIgnoreCase(request.getMethod());
    }

    public static String getIp(HttpServletRequest req) {
        // 代理转发前IP识别由Apache/Nginx实现，取到的即为真实ip，无需考虑代理中转问题
        return req.getRemoteAddr();
    }

    public static boolean isIntranet(HttpServletRequest req) {
        return isIntranet(getIp(req));
    }

    public static boolean isIntranet(String ip) {
        return intranetIpPattern.matcher(ip).find();
    }

    public static String getUrl(HttpServletRequest req) {
        StringBuffer url = req.getRequestURL();

        String queryString = req.getQueryString();
        if (StringUtils.isNotEmpty(queryString)) {
            url.append('?').append(queryString);
        }
        return url.toString();
    }

    public static String encodeUrl(String url) {
        try {
            if (StringUtils.isEmpty(url)) {
                return "";
            }

            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String decodeUrl(String url) {
        try {
            if (StringUtils.isEmpty(url)) {
                return "";
            }

            URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void writeJSON(HttpServletResponse response, Object data) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        try (OutputStream out = response.getOutputStream()) {
            out.write(JSON.toJSONString(data).getBytes("UTF-8"));
            out.flush();
        }
    }

    public static String getString(Object obj) {
        return null == obj?null:String.valueOf(obj);
    }
}
