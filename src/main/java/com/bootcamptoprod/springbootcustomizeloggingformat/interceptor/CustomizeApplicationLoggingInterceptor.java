package com.bootcamptoprod.springbootcustomizeloggingformat.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Component
public class CustomizeApplicationLoggingInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomizeApplicationLoggingInterceptor.class);
    private static final String REQUEST_ID = "requestId";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestId = UUID.randomUUID().toString().substring(0, 6);
        MDC.put(REQUEST_ID, requestId);
        LOGGER.info("Received request with ID: {}", requestId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestId = MDC.get(REQUEST_ID);
        LOGGER.info("Request with ID {} completed", requestId);
        MDC.remove(REQUEST_ID);
    }

}
