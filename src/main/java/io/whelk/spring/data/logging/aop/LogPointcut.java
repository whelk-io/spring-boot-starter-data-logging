package io.whelk.spring.data.logging.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class LogPointcut {

    private final LogAdvice logAdvice;

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Around around) {
        logAdvice.logBefore(joinPoint, around.withLevel(), around.withArgs());
    }

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Trace.Around around) {
        logAdvice.logBefore(joinPoint, LogLevel.TRACE, around.withArgs());
    }

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Debug.Around around) {
        logAdvice.logBefore(joinPoint, LogLevel.DEBUG, around.withArgs());
    }

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Info.Around around) {
        logAdvice.logBefore(joinPoint, LogLevel.INFO, around.withArgs());
    }

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Warn.Around around) {
        logAdvice.logBefore(joinPoint, LogLevel.WARN, around.withArgs());
    }

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Error.Around around) {
        logAdvice.logBefore(joinPoint, LogLevel.ERROR, around.withArgs());
    }

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Fatal.Around around) {
        logAdvice.logBefore(joinPoint, LogLevel.FATAL, around.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Before before) {
        logAdvice.logBefore(joinPoint, before.withLevel(), before.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Trace.Before before) {
        logAdvice.logBefore(joinPoint, LogLevel.TRACE, before.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Debug.Before before) {
        logAdvice.logBefore(joinPoint, LogLevel.DEBUG, before.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Info.Before before) {
        logAdvice.logBefore(joinPoint, LogLevel.INFO, before.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Warn.Before before) {
        logAdvice.logBefore(joinPoint, LogLevel.WARN, before.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Error.Before before) {
        logAdvice.logBefore(joinPoint, LogLevel.ERROR, before.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Fatal.Before before) {
        logAdvice.logBefore(joinPoint, LogLevel.FATAL, before.withArgs());
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.After after) {
        logAdvice.logAfter(joinPoint, after.withLevel(), false, null);
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.Trace.After after) {
        logAdvice.logAfter(joinPoint, LogLevel.TRACE, false, null);
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.Debug.After after) {
        logAdvice.logAfter(joinPoint, LogLevel.DEBUG, false, null);
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.Info.After after) {
        logAdvice.logAfter(joinPoint, LogLevel.INFO, false, null);
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.Warn.After after) {
        logAdvice.logAfter(joinPoint, LogLevel.WARN, false, null);
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.Error.After after) {
        logAdvice.logAfter(joinPoint, LogLevel.ERROR, false, null);
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.Fatal.After after) {
        logAdvice.logAfter(joinPoint, LogLevel.FATAL, false, null);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfter(joinPoint, afterReturning.withLevel(), true, returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Trace.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfter(joinPoint, LogLevel.TRACE, true, returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Debug.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfter(joinPoint, LogLevel.DEBUG, true, returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Info.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfter(joinPoint, LogLevel.INFO, true, returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Warn.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfter(joinPoint, LogLevel.WARN, true, returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Error.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfter(joinPoint, LogLevel.ERROR, true, returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Fatal.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfter(joinPoint, LogLevel.FATAL, true, returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Around around, Object returnType) {
        logAdvice.logAfter(joinPoint, around.withLevel(), around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Trace.Around around, Object returnType) {
        logAdvice.logAfter(joinPoint, LogLevel.TRACE, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Debug.Around around, Object returnType) {
        logAdvice.logAfter(joinPoint, LogLevel.DEBUG, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Info.Around around, Object returnType) {
        logAdvice.logAfter(joinPoint, LogLevel.INFO, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Warn.Around around, Object returnType) {
        logAdvice.logAfter(joinPoint, LogLevel.WARN, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Error.Around around, Object returnType) {
        logAdvice.logAfter(joinPoint, LogLevel.ERROR, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Fatal.Around around, Object returnType) {
        logAdvice.logAfter(joinPoint, LogLevel.FATAL, around.withReturnType(), returnType);
    }

}