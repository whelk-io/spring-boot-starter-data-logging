package io.whelk.spring.data.logging.sleuth;

import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.whelk.spring.data.logging.aop.Log;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Aspect
@Order(0)
@Component
@RequiredArgsConstructor
@ConditionalOnClass(brave.Tracer.class)
public class TracerPointcut {

    private final Optional<TracerAdvice> tracerAdvice;

    @SneakyThrows
    @Around("@annotation(logSpan)")
    public Object spanAround(final ProceedingJoinPoint joinPoint, final Log.Span logSpan) {
        System.out.println("span it");
        return tracerAdvice.isPresent()
               ? tracerAdvice.get().spanAround(joinPoint)
               : joinPoint.proceed();
    }

}