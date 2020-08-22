package io.whelk.spring.data.logging.aop;

import static io.whelk.spring.data.logging.aop.Log.Level.DEBUG;
import static io.whelk.spring.data.logging.aop.Log.Level.ERROR;
import static io.whelk.spring.data.logging.aop.Log.Level.FATAL;
import static io.whelk.spring.data.logging.aop.Log.Level.INFO;
import static io.whelk.spring.data.logging.aop.Log.Level.TRACE;
import static io.whelk.spring.data.logging.aop.Log.Level.WARN;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Aspect
@Order(1)
@Component
@RequiredArgsConstructor
public class LogPointcut {

    private final LogAdvice logAdvice;

    /* Before */

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
        logAdvice.logBefore(joinPoint, ERROR, around.withArgs());
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
        logAdvice.logBefore(joinPoint, ERROR, before.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Fatal.Before before) {
        logAdvice.logBefore(joinPoint, FATAL, before.withArgs());
    }

    /* After Returning */

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.After after) {
        logAdvice.logAfter(joinPoint, after.withLevel());
    }

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Trace.After after) {
        logAdvice.logAfter(joinPoint, TRACE);
    }

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Debug.After after) {
        logAdvice.logAfter(joinPoint, DEBUG);
    }

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Info.After after) {
        logAdvice.logAfter(joinPoint, INFO);
    }

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Warn.After after) {
        logAdvice.logAfter(joinPoint, WARN);
    }

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Error.After after) {
        logAdvice.logAfter(joinPoint, ERROR);
    }

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Fatal.After after) {
        logAdvice.logAfter(joinPoint, FATAL);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, afterReturning.withLevel(), afterReturning.withReturnType().withWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Trace.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, TRACE, afterReturning.withReturnType().withWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Debug.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, DEBUG, afterReturning.withReturnType().withWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Info.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, INFO, afterReturning.withReturnType().withWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Warn.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, WARN, afterReturning.withReturnType().withWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Error.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, ERROR, afterReturning.withReturnType().withWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Fatal.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, FATAL, afterReturning.withReturnType().withWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, around.withLevel(), around.withReturnType().enabled(), around.withReturnType().withWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Trace.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, TRACE, around.withReturnType().enabled(), around.withReturnType().withWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Debug.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, DEBUG, around.withReturnType().enabled(), around.withReturnType().withWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Info.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, INFO, around.withReturnType().enabled(), around.withReturnType().withWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Warn.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, WARN, around.withReturnType().enabled(), around.withReturnType().withWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Error.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, ERROR, around.withReturnType().enabled(), around.withReturnType().withWriter(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Fatal.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, FATAL, around.withReturnType().enabled(), around.withReturnType().withWriter(), returnType);
    }

    /* After Throwing */

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, afterThrowing.withReturnException().withOverride() ? ERROR : INFO, afterThrowing.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Trace.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, afterThrowing.withReturnException().withOverride() ? ERROR : TRACE, afterThrowing.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Debug.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, afterThrowing.withReturnException().withOverride() ? ERROR : DEBUG, afterThrowing.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Info.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, afterThrowing.withReturnException().withOverride() ? ERROR : INFO, afterThrowing.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Warn.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, afterThrowing.withReturnException().withOverride() ? ERROR : WARN, afterThrowing.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Error.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, ERROR, afterThrowing.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Fatal.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, FATAL, afterThrowing.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, around.withReturnException().withOverride() ? ERROR : INFO, around.withReturnException().withStacktrace() , e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Trace.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, around.withReturnException().withOverride() ? ERROR : TRACE, around.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Debug.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, around.withReturnException().withOverride() ? ERROR : DEBUG, around.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Info.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, around.withReturnException().withOverride() ? ERROR : INFO, around.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Warn.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, around.withReturnException().withOverride() ? ERROR : WARN, around.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Error.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, ERROR, around.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Fatal.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, FATAL, around.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, after.withReturnException().withOverride() ? ERROR : INFO, after.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Trace.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, after.withReturnException().withOverride() ? ERROR : TRACE, after.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Debug.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, after.withReturnException().withOverride() ? ERROR : DEBUG, after.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Info.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, after.withReturnException().withOverride() ? ERROR : INFO, after.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Warn.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, after.withReturnException().withOverride() ? ERROR : WARN, after.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Error.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, ERROR, after.withReturnException().withStacktrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Fatal.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, FATAL, after.withReturnException().withStacktrace(), e);
    }

}