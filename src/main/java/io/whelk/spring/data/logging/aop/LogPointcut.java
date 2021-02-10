/*
 * Copyright 2021 Whelk Contributors (http://whelk.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.whelk.spring.data.logging.aop;

import static io.whelk.spring.data.logging.aop.Log.Level.Debug;
import static io.whelk.spring.data.logging.aop.Log.Level.Error;
import static io.whelk.spring.data.logging.aop.Log.Level.Fatal;
import static io.whelk.spring.data.logging.aop.Log.Level.Info;
import static io.whelk.spring.data.logging.aop.Log.Level.Trace;
import static io.whelk.spring.data.logging.aop.Log.Level.Warn;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * @author Zack Teater
 * @since 0.1.0
 */
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
        logAdvice.logBefore(joinPoint, Trace, around.withArgs());
    }

    @Before("@annotation(around)")
    void logBefore(JoinPoint joinPoint, Log.Debug.Around around) {
        logAdvice.logBefore(joinPoint, Debug, around.withArgs());
    }

    @Before("@annotation(around)")
    void logBefore(JoinPoint joinPoint, Log.Info.Around around) {
        logAdvice.logBefore(joinPoint, Info, around.withArgs());
    }

    @Before("@annotation(around)")
    void logBefore(JoinPoint joinPoint, Log.Warn.Around around) {
        logAdvice.logBefore(joinPoint, Warn, around.withArgs());
    }

    @Before("@annotation(around)")
    void logBefore(JoinPoint joinPoint, Log.Error.Around around) {
        logAdvice.logBefore(joinPoint, Error, around.withArgs());
    }

    @Before("@annotation(around)")
    void logBefore(JoinPoint joinPoint, Log.Fatal.Around around) {
        logAdvice.logBefore(joinPoint, Fatal, around.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Before before) {
        logAdvice.logBefore(joinPoint, before.withLevel(), before.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Trace.Before before) {
        logAdvice.logBefore(joinPoint, Trace, before.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Debug.Before before) {
        logAdvice.logBefore(joinPoint, Debug, before.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Info.Before before) {
        logAdvice.logBefore(joinPoint, Info, before.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Warn.Before before) {
        logAdvice.logBefore(joinPoint, Warn, before.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Error.Before before) {
        logAdvice.logBefore(joinPoint, Error, before.withArgs());
    }

    @Before("@annotation(before)")
    void logBefore(JoinPoint joinPoint, Log.Fatal.Before before) {
        logAdvice.logBefore(joinPoint, Fatal, before.withArgs());
    }

    /* After Returning */

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.After after) {
        logAdvice.logAfter(joinPoint, after.withLevel());
    }

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Trace.After after) {
        logAdvice.logAfter(joinPoint, Trace);
    }

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Debug.After after) {
        logAdvice.logAfter(joinPoint, Debug);
    }

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Info.After after) {
        logAdvice.logAfter(joinPoint, Info);
    }

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Warn.After after) {
        logAdvice.logAfter(joinPoint, Warn);
    }

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Error.After after) {
        logAdvice.logAfter(joinPoint, Error);
    }

    @AfterReturning("@annotation(after)")
    void logAfter(JoinPoint joinPoint, Log.Fatal.After after) {
        logAdvice.logAfter(joinPoint, Fatal);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, afterReturning.withLevel(), afterReturning.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Trace.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, Trace, afterReturning.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Debug.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, Debug, afterReturning.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Info.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, Info, afterReturning.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Warn.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, Warn, afterReturning.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Error.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, Error, afterReturning.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Fatal.AfterReturning afterReturning, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, Fatal, afterReturning.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, around.withLevel(), around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Trace.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, Trace, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Debug.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, Debug, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Info.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, Info, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Warn.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, Warn, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Error.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, Error, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    void logAfterReturning(JoinPoint joinPoint, Log.Fatal.Around around, Object returnType) {
        logAdvice.logAfterReturning(joinPoint, Fatal, around.withReturnType(), returnType);
    }

    /* After Throwing */

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, afterThrowing.withReturnException().withLogLevel(),
                afterThrowing.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Trace.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, afterThrowing.withReturnException().withLogLevel(),
                afterThrowing.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Debug.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, afterThrowing.withReturnException().withLogLevel(),
                afterThrowing.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Info.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, afterThrowing.withReturnException().withLogLevel(),
                afterThrowing.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Warn.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, afterThrowing.withReturnException().withLogLevel(),
                afterThrowing.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Error.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, Error, afterThrowing.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(afterThrowing)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Fatal.AfterThrowing afterThrowing, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, Fatal, afterThrowing.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, around.withReturnException().withLogLevel(),
                around.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Trace.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, around.withReturnException().withLogLevel(),
                around.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Debug.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, around.withReturnException().withLogLevel(),
                around.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Info.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, around.withReturnException().withLogLevel(),
                around.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Warn.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, around.withReturnException().withLogLevel(),
                around.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Error.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, Error, around.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(around)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Fatal.Around around, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, Fatal, around.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, after.withReturnException().withLogLevel(),
                after.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Trace.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, after.withReturnException().withLogLevel(),
                after.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Debug.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, after.withReturnException().withLogLevel(),
                after.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Info.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, after.withReturnException().withLogLevel(),
                after.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Warn.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, after.withReturnException().withLogLevel(),
                after.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Error.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, Error, after.withReturnException().withStackTrace(), e);
    }

    @AfterThrowing(value = "@annotation(after)", throwing = "e")
    void logAfterThrowing(JoinPoint joinPoint, Log.Fatal.After after, Exception e) {
        logAdvice.logAfterThrowing(joinPoint, Fatal, after.withReturnException().withStackTrace(), e);
    }

}