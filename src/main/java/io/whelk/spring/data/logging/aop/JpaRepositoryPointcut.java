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
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import io.whelk.spring.data.logging.sleuth.TracerAdvice;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Aspect
@Component
@RequiredArgsConstructor
public class JpaRepositoryPointcut {

    protected final LogAdvice logAdvice;
    protected final Optional<TracerAdvice> tracerAdvice;

    // T getOne(ID id);

	// <S extends T> List<S> findAll(Example<S> example);

	// <S extends T> List<S> findAll(Example<S> example, Sort sort);

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.findAll())")
    void findAll() { }

    @Before("findAll()")
    void findAllBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "findAll()", returning = "returnType")
    void findAllAfterReturning(JoinPoint joinPoint, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "findAll()", throwing = "e")
    void findAllAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @Around("findAll()")
    Object findAllAround(ProceedingJoinPoint joinPoint) { 
        return spanAround(joinPoint);
    }

    // List<T> findAll(Sort sort);

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.findAllById(*))")
    void findAllById() { }

    @Before("findAllById()")
    void findAllByIdBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "findAllById()", returning = "returnType")
    void findAllByIdAfterReturning(JoinPoint joinPoint, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "findAllById()", throwing = "e")
    void findAllByIdAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @SneakyThrows
    @Around("findAllById()")
    Object findAllByIdAround(ProceedingJoinPoint joinPoint) { 
        return spanAround(joinPoint);
    }

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.saveAll(*))")
    void saveAll() { }

    @Before("saveAll()")
    void saveAllBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "saveAll()", returning = "returnType")
    void saveAllAfterReturning(JoinPoint joinPoint, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "saveAll()", throwing = "e")
    void saveAllAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @SneakyThrows
    @Around("saveAll()")
    Object saveAllAround(ProceedingJoinPoint joinPoint) { 
        return spanAround(joinPoint);
    }

	// void flush();

	// <S extends T> S saveAndFlush(S entity);

	// void deleteInBatch(Iterable<T> entities);

	// void deleteAllInBatch();

    void logBefore(JoinPoint joinPoint) { 
        if (isJpaRepositoryDeclaringType(joinPoint))
            logAdvice.logBefore(joinPoint, DEBUG);
    }

    void logAfterReturning(JoinPoint joinPoint, Object returnType) { 
        if (isJpaRepositoryDeclaringType(joinPoint))
            logAdvice.logAfterReturning(joinPoint, DEBUG, returnType);
    }

    void logAfterThrowing(JoinPoint joinPoint, Exception e) { 
        if (isJpaRepositoryDeclaringType(joinPoint))
            logAdvice.logAfterThrowing(joinPoint, ERROR, e);
    }

    @SneakyThrows
    Object spanAround(ProceedingJoinPoint joinPoint) { 
        return tracerAdvice.isPresent() && isJpaRepositoryDeclaringType(joinPoint)
            ? tracerAdvice.get().spanAround(joinPoint)
            : joinPoint.proceed();
    }

    boolean isJpaRepositoryDeclaringType(JoinPoint joinPoint) {
        return joinPoint.getSignature().getDeclaringType().equals(JpaRepository.class);
    }

}