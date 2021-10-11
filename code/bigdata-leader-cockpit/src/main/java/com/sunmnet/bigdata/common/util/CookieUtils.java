package com.sunmnet.bigdata.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class CookieUtils {
    private static final Logger LOG = LoggerFactory.getLogger(CookieUtils.class);

    private CookieUtils() {}

    /**
     * 十年
     */
    private static final int DEFAULT_MAX_AGE = 60 * 60 * 24 * 365 * 10;

    public static String getValueByName(String name, HttpServletRequest request) {
        String value = "";

        Cookie cookie = WebUtils.getCookie(request, name);
        if (cookie != null) {
            value = cookie.getValue();
        }

        LOG.info("Util: CookieUtil.getValueByName, Args: {}, Return: {}.", name, value);
        return value;
    }

    public static void add(String name, String value, int expiry, HttpServletRequest request,
                           HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain(request.getServerName());
        cookie.setPath("/");
        cookie.setMaxAge(expiry);
        response.addCookie(cookie);
    }

    public static void add(String name, String value, HttpServletRequest request, HttpServletResponse response) {
        add(name, value, DEFAULT_MAX_AGE, request, response);
    }

    public static void delete(String name, String value, HttpServletRequest request, HttpServletResponse response) {
        add(name, value, 0, request, response);
    }
}
