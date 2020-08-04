package io.whelk.spring.data.logging.aop;

import static org.springframework.boot.logging.LogLevel.DEBUG;
import static org.springframework.boot.logging.LogLevel.ERROR;

import java.util.Optional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
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

    @Pointcut("execution(* org.springframework.data..jpa.repository.JpaRepository.getOne(*))")
    void getOne() { }

    @Before("getOne()")
    void getOneBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "getOne()", returning = "returnType")
    void getOneAfterReturning(JoinPoint joinPoint, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "getOne()", throwing = "e")
    void getOneAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

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

    @Pointcut("execution(* org.springframework.data.jpa.repository.JpaRepository.findAll(..))")
    void findAllWithArgs() { }

    @Before("findAllWithArgs() && args(sort,..)")
    void findAllWithSortBefore(JoinPoint joinPoint, Sort sort) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "findAllWithArgs() && args(sort,..)", returning = "returnType")
    void findAllWithSortAfterReturning(JoinPoint joinPoint, Sort sort, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "findAllWithArgs() && args(sort,..)", throwing = "e")
    void findAllWithSortAfterThrowing(JoinPoint joinPoint, Sort sort, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @Before("findAllWithArgs() && args(..,example)")
    void findAllWithExampleBefore(JoinPoint joinPoint, Example<?> example) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "findAllWithArgs() && args(..,example)", returning = "returnType")
    void findAllWithExampleAfterReturning(JoinPoint joinPoint, Example<?> example, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "findAllWithArgs() && args(..,example)", throwing = "e")
    void findAllWithExampleAfterThrowing(JoinPoint joinPoint, Example<?> example, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @Before("findAllWithArgs() && args(..,example,sort)")
    void findAllWithExampleSortBefore(JoinPoint joinPoint, Example<?> example, Sort sort) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "findAllWithArgs() && args(..,example,sort)", returning = "returnType")
    void findAllWithExampleSortAfterReturning(JoinPoint joinPoint, Example<?> example, Sort sort, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "findAllWithArgs() && args(..,example,sort)", throwing = "e")
    void findAllWithExampleSortAfterThrowing(JoinPoint joinPoint, Example<?> example, Sort sort, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

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

    @Pointcut("execution(* org.springframework.data.jpa.repository.JpaRepository.flush())")
    void flush() { }

    @Before("flush()")
    void flushBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @After("flush()")
    void flushAfter(JoinPoint joinPoint) {
        logAfter(joinPoint);
    }

    @AfterThrowing(pointcut = "flush()", throwing = "e")
    void flushAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @Pointcut("execution(* org.springframework.data.jpa.repository.JpaRepository.saveAndFlush(*))")
    void saveAndFlush() { }

    @Before("saveAndFlush()")
    void saveAndFlushBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "saveAndFlush()", returning = "returnType")
    void saveAndFlushAfterReturning(JoinPoint joinPoint, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "saveAndFlush()", throwing = "e")
    void saveAndFlushAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @SneakyThrows
    @Around("saveAndFlush()")
    Object saveAndFlushAround(ProceedingJoinPoint joinPoint) { 
        return spanAround(joinPoint);
    }

    @Pointcut("execution(* org.springframework.data.jpa.repository.JpaRepository.deleteInBatch(*))")
    void deleteInBatch() { }

    @Before("deleteInBatch()")
    void deleteInBatchBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @After("deleteInBatch()")
    void deleteInBatchAfter(JoinPoint joinPoint) {
        logAfter(joinPoint);
    }

    @AfterThrowing(pointcut = "deleteInBatch()", throwing = "e")
    void deleteInBatchAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @SneakyThrows
    @Around("deleteInBatch()")
    Object deleteInBatchAround(ProceedingJoinPoint joinPoint) { 
        return spanAround(joinPoint);
    }

    @Pointcut("execution(* org.springframework.data.jpa.repository.JpaRepository.deleteAllInBatch())")
    void deleteAllInBatch() { }

    @Before("deleteAllInBatch()")
    void deleteAllInBatchBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @After("deleteAllInBatch()")
    void deleteAllInBatchAfter(JoinPoint joinPoint) {
        logAfter(joinPoint);
    }

    @AfterThrowing(pointcut = "deleteAllInBatch()", throwing = "e")
    void deleteAllInBatchAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @SneakyThrows
    @Around("deleteAllInBatch()")
    Object deleteAllInBatchAround(ProceedingJoinPoint joinPoint) { 
        return spanAround(joinPoint);
    }

    void logBefore(JoinPoint joinPoint) { 
        if (isJpaRepositoryDeclaringType(joinPoint))
            logAdvice.logBefore(joinPoint, DEBUG);
    }

    void logAfterReturning(JoinPoint joinPoint, Object returnType) { 
        if (isJpaRepositoryDeclaringType(joinPoint))
            logAdvice.logAfterReturning(joinPoint, DEBUG, returnType);
    }

    void logAfter(JoinPoint joinPoint) { 
        if (isJpaRepositoryDeclaringType(joinPoint))
            logAdvice.logAfter(joinPoint, DEBUG);
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