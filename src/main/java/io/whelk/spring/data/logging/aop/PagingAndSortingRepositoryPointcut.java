package io.whelk.spring.data.logging.aop;

import static io.whelk.spring.data.logging.aop.Log.Level.DEBUG;
import static io.whelk.spring.data.logging.aop.Log.Level.ERROR;

import java.util.Optional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import io.whelk.spring.data.logging.sleuth.TracerAdvice;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Aspect
@Component
@RequiredArgsConstructor
public class PagingAndSortingRepositoryPointcut {

    protected final LogAdvice logAdvice;
    protected final Optional<TracerAdvice> tracerAdvice;

    @Pointcut("execution(* org.springframework.data.repository.PagingAndSortingRepository.findAll(..))")
    void findAllWithArgs() {
    }

    @Before("findAllWithArgs() && args(pageable,..)")
    void findAllWithPageableBefore(JoinPoint joinPoint, Pageable pageable) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "findAllWithArgs() && args(pageable,..)", returning = "returnType")
    void findAllWithPageableAfterReturning(JoinPoint joinPoint, Pageable pageable, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "findAllWithArgs() && args(pageable,..)", throwing = "e")
    void findAllWithPageableAfterThrowing(JoinPoint joinPoint, Pageable pageable, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    void logBefore(JoinPoint joinPoint) {
        if (isPagingAndSortingRepositoryDeclaringType(joinPoint))
            logAdvice.logBefore(joinPoint, DEBUG);
    }

    void logAfterReturning(JoinPoint joinPoint, Object returnType) {
        if (isPagingAndSortingRepositoryDeclaringType(joinPoint))
            logAdvice.logAfterReturning(joinPoint, DEBUG, returnType);
    }

    void logAfterThrowing(JoinPoint joinPoint, Exception e) {
        if (isPagingAndSortingRepositoryDeclaringType(joinPoint))
            logAdvice.logAfterThrowing(joinPoint, ERROR, e);
    }

    @SneakyThrows
    Object spanAround(ProceedingJoinPoint joinPoint) {
        return tracerAdvice.isPresent() && isPagingAndSortingRepositoryDeclaringType(joinPoint)
                ? tracerAdvice.get().spanAround(joinPoint)
                : joinPoint.proceed();
    }

    boolean isPagingAndSortingRepositoryDeclaringType(JoinPoint joinPoint) {
        return joinPoint.getSignature().getDeclaringType().equals(PagingAndSortingRepository.class);
    }

}