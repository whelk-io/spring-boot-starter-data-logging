package io.whelk.spring.data.logging.aop;

import static io.whelk.spring.data.logging.aop.Log.Level.Debug;
import static io.whelk.spring.data.logging.aop.Log.Level.Error;

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
    void existsById() {
    }

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
    void count() {
    }

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
    void findById() {
    }

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
    void save() {
    }

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

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.deleteById(*))")
    void deleteById() {
    }

    @Before("deleteById()")
    void deleteByIdBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "deleteById()", returning = "returnType")
    void deleteByIdAfterReturning(JoinPoint joinPoint, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "deleteById()", throwing = "e")
    void deleteByIdAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @SneakyThrows
    @Around("deleteById()")
    Object deleteByIdAround(ProceedingJoinPoint joinPoint) {
        return spanAround(joinPoint);
    }

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.delete(*))")
    void delete() {
    }

    @Before("delete()")
    void deleteBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @After("delete()")
    void deleteAfter(JoinPoint joinPoint) {
        logAfter(joinPoint);
    }

    @AfterThrowing(pointcut = "delete()", throwing = "e")
    void deleteAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @SneakyThrows
    @Around("delete()")
    Object deleteAround(ProceedingJoinPoint joinPoint) {
        return spanAround(joinPoint);
    }

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.deleteAll(*))")
    void deleteAllByReference() {
    }

    @Before("deleteAllByReference()")
    void deleteAllByReferenceBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @After("deleteAllByReference()")
    void deleteAllByReferenceAfter(JoinPoint joinPoint) {
        logAfter(joinPoint);
    }

    @AfterThrowing(pointcut = "deleteAllByReference()", throwing = "e")
    void deleteAllByReferenceAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @SneakyThrows
    @Around("deleteAllByReference()")
    Object deleteAllByReferenceAround(ProceedingJoinPoint joinPoint) {
        return spanAround(joinPoint);
    }

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.deleteAll())")
    void deleteAll() {
    }

    @Before("deleteAll()")
    void deleteAllBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @After("deleteAll()")
    void deleteAllAfter(JoinPoint joinPoint) {
        logAfter(joinPoint);
    }

    @AfterThrowing(pointcut = "deleteAll()", throwing = "e")
    void deleteAllAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @SneakyThrows
    @Around("deleteAll()")
    Object deleteAllAround(ProceedingJoinPoint joinPoint) {
        return spanAround(joinPoint);
    }

    void logBefore(JoinPoint joinPoint) {
        if (isCrudRepositoryDeclaringType(joinPoint))
            logAdvice.logBefore(joinPoint, Debug);
    }

    void logAfter(JoinPoint joinPoint) {
        if (isCrudRepositoryDeclaringType(joinPoint))
            logAdvice.logAfter(joinPoint, Debug);
    }

    void logAfterReturning(JoinPoint joinPoint, Object returnType) {
        if (isCrudRepositoryDeclaringType(joinPoint))
            logAdvice.logAfterReturning(joinPoint, Debug, returnType);
    }

    void logAfterThrowing(JoinPoint joinPoint, Exception e) {
        if (isCrudRepositoryDeclaringType(joinPoint))
            logAdvice.logAfterThrowing(joinPoint, Error, e);
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