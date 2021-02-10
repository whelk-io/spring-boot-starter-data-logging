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
package io.whelk.spring.data.logging.sleuth;

import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;

import brave.Tracer.SpanInScope;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

/**
 * @author Zack Teater
 * @since 0.1.0
 */
@RequiredArgsConstructor
public class TracerAdvice {

    /**
     * Default TraceID key for slf4j and Spring-Cloud
     */
    public static final String SPAN_MDC = "X-B3-TraceId";

    private final Optional<brave.Tracer> tracer;

    /**
     * Handle pointcut when intercepting Tracers and add new Sleuth span to tracer.
     * 
     * @param joinPoint - pointcut
     * @return response from pointcut after executing
     */
    @SneakyThrows
    public Object spanAround(final ProceedingJoinPoint joinPoint) {
        brave.Span span = null;
        try {
            if (tracer.isPresent()) {
                final var signature = joinPoint.getSignature().toString();
                span = tracer.get().nextSpan().name(signature);

                try (SpanInScope ws = tracer.get().withSpanInScope(span.start())) {
                    return joinPoint.proceed();
                }
            } else {
                return joinPoint.proceed();
            }
        } finally {
            try {
                if (span != null)
                    span.finish();
            } catch (final Exception e) {
                // ignore
            }
        }
    }

}