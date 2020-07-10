package io.whelk.spring.data.logging.sleuth;

import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;

import brave.Tracer.SpanInScope;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class TracerAdvice {

    private final Optional<brave.Tracer> tracer;

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