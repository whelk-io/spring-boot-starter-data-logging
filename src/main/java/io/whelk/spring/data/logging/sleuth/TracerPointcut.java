package io.whelk.spring.data.logging.sleuth;

import static io.whelk.spring.data.logging.sleuth.TracerAdvice.SPAN_MDC;

import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
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
        return spanAround(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAround)")
    Object logAround(final ProceedingJoinPoint joinPoint, final Log.Around logAround) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAround)")
    Object logAround(final ProceedingJoinPoint joinPoint, final Log.Trace.Around logAround) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAround)")
    Object logAround(final ProceedingJoinPoint joinPoint, final Log.Debug.Around logAround) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAround)")
    Object logAround(final ProceedingJoinPoint joinPoint, final Log.Info.Around logAround) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAround)")
    Object logAround(final ProceedingJoinPoint joinPoint, final Log.Warn.Around logAround) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAround)")
    Object logAround(final ProceedingJoinPoint joinPoint, final Log.Error.Around logAround) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAround)")
    Object logAround(final ProceedingJoinPoint joinPoint, final Log.Fatal.Around logAround) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logBefore)")
    Object logBefore(final ProceedingJoinPoint joinPoint, final Log.Before logBefore) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logBefore)")
    Object logBefore(final ProceedingJoinPoint joinPoint, final Log.Trace.Before logBefore) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logBefore)")
    Object logBefore(final ProceedingJoinPoint joinPoint, final Log.Debug.Before logBefore) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logBefore)")
    Object logBefore(final ProceedingJoinPoint joinPoint, final Log.Info.Before logBefore) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logBefore)")
    Object logBefore(final ProceedingJoinPoint joinPoint, final Log.Warn.Before logBefore) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logBefore)")
    Object logBefore(final ProceedingJoinPoint joinPoint, final Log.Error.Before logBefore) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logBefore)")
    Object logBefore(final ProceedingJoinPoint joinPoint, final Log.Fatal.Before logBefore) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfter)")
    Object logAfter(final ProceedingJoinPoint joinPoint, final Log.After logAfter) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfter)")
    Object logAfter(final ProceedingJoinPoint joinPoint, final Log.Trace.After logAfter) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfter)")
    Object logAfter(final ProceedingJoinPoint joinPoint, final Log.Debug.After logAfter) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfter)")
    Object logAfter(final ProceedingJoinPoint joinPoint, final Log.Info.After logAfter) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfter)")
    Object logAfter(final ProceedingJoinPoint joinPoint, final Log.Warn.After logAfter) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfter)")
    Object logAfter(final ProceedingJoinPoint joinPoint, final Log.Error.After logAfter) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfter)")
    Object logAfter(final ProceedingJoinPoint joinPoint, final Log.Fatal.After logAfter) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterReturning)")
    Object logAfterReturning(final ProceedingJoinPoint joinPoint, final Log.AfterReturning logAfterReturning) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterReturning)")
    Object logAfterReturning(final ProceedingJoinPoint joinPoint, final Log.Trace.AfterReturning logAfterReturning) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterReturning)")
    Object logAfterReturning(final ProceedingJoinPoint joinPoint, final Log.Debug.AfterReturning logAfterReturning) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterReturning)")
    Object logAfterReturning(final ProceedingJoinPoint joinPoint, final Log.Info.AfterReturning logAfterReturning) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterReturning)")
    Object logAfterReturning(final ProceedingJoinPoint joinPoint, final Log.Warn.AfterReturning logAfterReturning) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterReturning)")
    Object logAfterReturning(final ProceedingJoinPoint joinPoint, final Log.Error.AfterReturning logAfterReturning) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterReturning)")
    Object logAfterReturning(final ProceedingJoinPoint joinPoint, final Log.Fatal.AfterReturning logAfterReturning) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterThrowing)")
    Object logAfterThrowing(final ProceedingJoinPoint joinPoint, final Log.AfterThrowing logAfterThrowing) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterThrowing)")
    Object logAfterThrowing(final ProceedingJoinPoint joinPoint, final Log.Trace.AfterThrowing logAfterThrowing) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterThrowing)")
    Object logAfterThrowing(final ProceedingJoinPoint joinPoint, final Log.Debug.AfterThrowing logAfterThrowing) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterThrowing)")
    Object logAfterThrowing(final ProceedingJoinPoint joinPoint, final Log.Info.AfterThrowing logAfterThrowing) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterThrowing)")
    Object logAfterThrowing(final ProceedingJoinPoint joinPoint, final Log.Warn.AfterThrowing logAfterThrowing) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterThrowing)")
    Object logAfterThrowing(final ProceedingJoinPoint joinPoint, final Log.Error.AfterThrowing logAfterThrowing) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    @Around("@annotation(logAfterThrowing)")
    Object logAfterThrowing(final ProceedingJoinPoint joinPoint, final Log.Fatal.AfterThrowing logAfterThrowing) {
        return spanAroundIfMissing(joinPoint);
    }

    @SneakyThrows
    Object spanAround(final ProceedingJoinPoint joinPoint) {
        return tracerAdvice.isPresent() 
               ? tracerAdvice.get().spanAround(joinPoint) 
               : joinPoint.proceed();
    }

    @SneakyThrows
    Object spanAroundIfMissing(final ProceedingJoinPoint joinPoint) {
        return MDC.get(SPAN_MDC) == null && tracerAdvice.isPresent()
               ? tracerAdvice.get().spanAround(joinPoint)
               : joinPoint.proceed();
    }

}