package io.whelk.spring.data.logging.aop;

import static org.springframework.boot.logging.LogLevel.DEBUG;
import static org.springframework.boot.logging.LogLevel.ERROR;

import java.util.Optional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import io.whelk.spring.data.logging.sleuth.TracerAdvice;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Aspect
@Component
@RequiredArgsConstructor
public class CrudRepositoryPointcut {

    protected final LogAdvice logAdvice;
    protected final Optional<TracerAdvice> tracerAdvice;

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.existsById(*))")
    void existsById() { }

    @Before("existsById()")
    void existsByIdBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "existsById()", returning = "returnType")
    void existsByIdAfterReturning(JoinPoint joinPoint, Object returnType) throws Throwable {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "existsById()", throwing = "e")
    void existsByIdAfterThrowing(JoinPoint joinPoint, Exception e) throws Throwable {
        logAfterThrowing(joinPoint, e);
    }

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.count())")
    void count() { }

    @Before("count()")
    void countBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "count()", returning = "returnType")
    void countAfterReturning(JoinPoint joinPoint, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "count()", throwing = "e")
    void countAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }
 
    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.findById(*))")
    void findById() { }

    @Before("findById()")
    void findByIdBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "findById()", returning = "returnType")
    void findByIdAfterReturning(JoinPoint joinPoint, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "findById()", throwing = "e")
    void findByIdAfterReturning(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.save(*))")
    void save() { }

    @Before("save()")
    void saveBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "save()", returning = "returnType")
    void saveAfterReturning(JoinPoint joinPoint, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "save()", throwing = "e")
    void saveAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @SneakyThrows
    @Around("save()")
    Object saveAround(ProceedingJoinPoint joinPoint) { 
        return spanAround(joinPoint);
    }

    
    // @Log.Debug.Around
    // @Log.Span
    // @Override
    // void deleteById(ID id);

    // @Log.Debug.Around
    // @Log.Span
    // @Override
    // void delete(T entity);

    // @Log.Debug.Around
    // @Log.Span
    // @Override
    // void deleteAll(Iterable<? extends T> entities);

    // @Log.Debug.Around
    // @Log.Span
    // @Override
    // void deleteAll();

    void logBefore(JoinPoint joinPoint) { 
        if (isCrudRepositoryDeclaringType(joinPoint))
            logAdvice.logBefore(joinPoint, DEBUG);
    }

    void logAfterReturning(JoinPoint joinPoint, Object returnType) { 
        if (isCrudRepositoryDeclaringType(joinPoint))
            logAdvice.logAfterReturning(joinPoint, DEBUG, returnType);
    }

    void logAfterThrowing(JoinPoint joinPoint, Exception e) { 
        if (isCrudRepositoryDeclaringType(joinPoint))
            logAdvice.logAfterThrowing(joinPoint, ERROR, e);
    }

    @SneakyThrows
    Object spanAround(ProceedingJoinPoint joinPoint) { 
        return tracerAdvice.isPresent() && isCrudRepositoryDeclaringType(joinPoint)
             ? tracerAdvice.get().spanAround(joinPoint)
             : joinPoint.proceed();
    }

    boolean isCrudRepositoryDeclaringType(JoinPoint joinPoint) {
        return joinPoint.getSignature().getDeclaringType().equals(CrudRepository.class);
    }

}