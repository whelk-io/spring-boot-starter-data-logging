package io.whelk.spring.data.logging.aop;

import static org.springframework.boot.logging.LogLevel.DEBUG;
import static org.springframework.boot.logging.LogLevel.FATAL;
import static org.springframework.boot.logging.LogLevel.INFO;
import static org.springframework.boot.logging.LogLevel.TRACE;
import static org.springframework.boot.logging.LogLevel.WARN;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.logging.LogLevel;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Aspect
@Order(1)
@Component
@RequiredArgsConstructor
public class LogPointcut {

    private final LogAdvice logAdvice;

    @Before("@annotation(around)")
    void logBefore(JoinPoint joinPoint, Log.Around around) {
        logAdvice.logBefore(joinPoint, around.withLevel(), around.withArgs());
    }

    @Before("@annotation(around)")
    void logBefore(JoinPoint joinPoint, Log.Trace.Around around) {
        logAdvice.logBefore(joinPoint, TRACE, around.withArgs());
    }

    @Before("@annotation(around)")
    void logBefore(JoinPoint joinPoint, Log.Debug.Around around) {
        logAdvice.logBefore(joinPoint, DEBUG, around.withArgs());
    }

    @Before("@annotation(around)")
    void logBefore(JoinPoint joinPoint, Log.Info.Around around) {
        logAdvice.logBefore(joinPoint, INFO, around.withArgs());
    }

    @Before("@annotation(around)")
    void logBefore(JoinPoint joinPoint, Log.Warn.Around around) {
        logAdvice.logBefore(joinPoint, WARN, around.withArgs());
    }

    @Before("@annotation(around)")
    void logBefore(JoinPoint joinPoint, Log.Error.Around around) {
        logAdvice.logBefore(joinPoint, LogLevel.ERROR, around.withArgs());
    }

    @Before("@annotation(around)")
    void logBefore(JoinPoint joinPoint, Log.Fatal.Around around) {
        logAdvice.logBefore(joinPoint, FATAL, around.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Before before) {
        logAdvice.logBefore(joinPoint, before.withLevel(), before.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Trace.Before before) {
        logAdvice.logBefore(joinPoint, TRACE, before.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Debug.Before before) {
        logAdvice.logBefore(joinPoint, DEBUG, before.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Info.Before before) {
        logAdvice.logBefore(joinPoint, INFO, before.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Warn.Before before) {
        logAdvice.logBefore(joinPoint, WARN, before.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Error.Before before) {
        logAdvice.logBefore(joinPoint, LogLevel.ERROR, before.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Fatal.Before before) {
        logAdvice.logBefore(joinPoint, FATAL, before.withArgs());
    }

    @After("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.After after) {
        logAdvice.logAfter(joinPoint, after.withLevel());
    }

    @After("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Trace.After after) {
        logAdvice.logAfter(joinPoint, TRACE);
    }

    @After("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Debug.After after) {
        logAdvice.logAfter(joinPoint, DEBUG);
    }

    @After("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Info.After after) {
        logAdvice.logAfter(joinPoint, INFO);
    }

    @After("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Warn.After after) {
        logAdvice.logAfter(joinPoint, WARN);
    }

    @After("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Error.After after) {
        logAdvice.logAfter(joinPoint, LogLevel.ERROR);
    }

    @After("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Fatal.After after) {
        logAdvice.logAfter(joinPoint, FATAL);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, afterReturning.withLevel(), afterReturning.withReturnTypeWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Trace.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, TRACE, afterReturning.withReturnTypeWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Debug.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, DEBUG, afterReturning.withReturnTypeWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Info.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, INFO, afterReturning.withReturnTypeWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Warn.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, WARN, afterReturning.withReturnTypeWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Error.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, LogLevel.ERROR, afterReturning.withReturnTypeWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Fatal.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, FATAL, afterReturning.withReturnTypeWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, around.withLevel(), around.withReturnType(), around.withReturnTypeWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Trace.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, TRACE, around.withReturnType(), around.withReturnTypeWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Debug.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, DEBUG, around.withReturnType(), around.withReturnTypeWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Info.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, INFO, around.withReturnType(), around.withReturnTypeWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Warn.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, WARN, around.withReturnType(), around.withReturnTypeWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Error.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, LogLevel.ERROR, around.withReturnType(), around.withReturnTypeWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Fatal.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, FATAL, around.withReturnType(), around.withReturnTypeWriter(), returnType);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, INFO, afterThrowing.withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Trace.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, TRACE, afterThrowing.withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Debug.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, DEBUG, afterThrowing.withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Info.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, INFO, afterThrowing.withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Warn.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, WARN, afterThrowing.withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Error.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, LogLevel.ERROR, afterThrowing.withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Fatal.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, FATAL, afterThrowing.withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, INFO, around.withStacktrace(), e);
    }

}