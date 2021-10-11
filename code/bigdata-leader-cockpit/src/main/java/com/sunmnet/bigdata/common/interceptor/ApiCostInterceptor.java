package com.sunmnet.bigdata.common.interceptor;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
public class ApiCostInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(ApiCostInterceptor.class);

    private static final ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex)
            throws Exception {
        // 请求耗时
        int cost = (int)(System.currentTimeMillis() - startTime.get());
        startTime.remove();

        // 请求头信息
        Map<String, String> headerInfo = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while(headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                headerInfo.put(headerName, headerValue);
            }
        }

        // 请求参数信息
        Map<String, String[]> paramMap = request.getParameterMap();
        if (paramMap == null) {
            paramMap = new HashMap<>();
        }

        String paramInfo = JSON.toJSONString(paramMap);
        paramInfo = URLDecoder.decode(paramInfo, "UTF-8");

        // 异常信息
        String exInfo = "";
        if (ex != null) {
            exInfo = ExceptionUtils.getStackTrace(ex);
        }

        // 响应头信息
        Map<String, String> respHeaderInfo = new HashMap<>();
        Collection<String> respHeaderNames = response.getHeaderNames();
        if (respHeaderNames != null) {
            for (String respHeaderName : respHeaderNames) {
                respHeaderInfo.put(respHeaderName, response.getHeader(respHeaderName));
            }
        }

        LOG.info("URL[{}], Request[method:{}, headers:{}, params:{}], Response[headers:{}, code:{}], Exception[{}], Cost[{}]",
                request.getRequestURL(), request.getMethod(), headerInfo, paramInfo, respHeaderInfo, response.getStatus(),
                exInfo, cost + "ms");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        startTime.set(System.currentTimeMillis());
        return true;
    }
}