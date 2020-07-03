package io.whelk.spring.data.logging.sleuth;

import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import brave.Tracer.SpanInScope;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Aspect
@RequiredArgsConstructor
public class TracerAspect {

    private final Optional<brave.Tracer> tracer;

    @SneakyThrows
    @Around("@annotation(tracerSpan)")
    public Object spanAround(final ProceedingJoinPoint joinPoint, final Tracer.Span tracerSpan) {
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