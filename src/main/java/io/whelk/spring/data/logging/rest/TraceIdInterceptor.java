/*
 * Copyright 2021 Whelk Contributors (http://whelk.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.whelk.spring.data.logging.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.SneakyThrows;

/**
 * @author Zack Teater
 * @since 0.1.0
 */
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