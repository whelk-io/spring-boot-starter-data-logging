package io.whelk.spring.data.logging.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.SneakyThrows;

public class TraceIdInterceptor implements HandlerInterceptor {

    private static final String X_B3_TRACE_ID = "X-B3-TraceId";

    @SneakyThrows
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        var traceId = MDC.get(X_B3_TRACE_ID);
        if (traceId != null) {
            var traceIdString = traceId.toString();
            if (!traceIdString.isBlank()) {
                response.addHeader(X_B3_TRACE_ID, traceIdString.trim());
            }
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}