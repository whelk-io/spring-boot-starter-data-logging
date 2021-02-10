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

import java.util.Optional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Component;

import io.whelk.spring.data.logging.sleuth.TracerAdvice;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

/**
 * @author Zack Teater
 * @since 0.1.0
 */
@Aspect
@Component
@RequiredArgsConstructor
public class QueryByExampleExecutorPointcut {

    private final LogAdvice logAdvice;
    private final Optional<TracerAdvice> tracerAdvice;

    @Pointcut("execution(* org.springframework.data.repository.query.QueryByExampleExecutor.findAll(..))")
    void findAllWithArgs() {
    }

    @Before("findAllWithArgs() && args(..,example,pageable)")
    void findAllWithExamplePageableBefore(JoinPoint joinPoint, Example<?> example, Pageable pageable) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "findAllWithArgs() && args(..,example,pageable)", returning = "returnType")
    void findAllWithExamplePageableAfterReturning(JoinPoint joinPoint, Example<?> example, Pageable pageable,
            Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "findAllWithArgs() && args(..,example,pageable)", throwing = "e")
    void findAllWithExampleageableAfterThrowing(JoinPoint joinPoint, Example<?> example, Pageable pageable,
            Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @Pointcut("execution(* org.springframework.data.repository.query.QueryByExampleExecutor.findOne(..))")
    void findOne() {
    }

    @Before("findOne()")
    void findOneBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "findOne()", returning = "returnType")
    void findOneAfterReturning(JoinPoint joinPoint, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "findOne()", throwing = "e")
    void findOneAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    @Pointcut("execution(* org.springframework.data.repository.query.QueryByExampleExecutor.count(..))")
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

    @Pointcut("execution(* org.springframework.data.repository.query.QueryByExampleExecutor.exists(..))")
    void exists() {
    }

    @Before("exists()")
    void existsBefore(JoinPoint joinPoint) throws Throwable {
        logBefore(joinPoint);
    }

    @AfterReturning(pointcut = "exists()", returning = "returnType")
    void existsAfterReturning(JoinPoint joinPoint, Object returnType) {
        logAfterReturning(joinPoint, returnType);
    }

    @AfterThrowing(pointcut = "exists()", throwing = "e")
    void existsAfterThrowing(JoinPoint joinPoint, Exception e) {
        logAfterThrowing(joinPoint, e);
    }

    void logBefore(JoinPoint joinPoint) {
        if (isQueryByExampleExecutorDeclaringType(joinPoint))
            logAdvice.logBefore(joinPoint, Debug);
    }

    void logAfterReturning(JoinPoint joinPoint, Object returnType) {
        if (isQueryByExampleExecutorDeclaringType(joinPoint))
            logAdvice.logAfterReturning(joinPoint, Debug, returnType);
    }

    void logAfterThrowing(JoinPoint joinPoint, Exception e) {
        if (isQueryByExampleExecutorDeclaringType(joinPoint))
            logAdvice.logAfterThrowing(joinPoint, Error, e);
    }

    @SneakyThrows
    Object spanAround(ProceedingJoinPoint joinPoint) {
        return tracerAdvice.isPresent() && isQueryByExampleExecutorDeclaringType(joinPoint) //
                ? tracerAdvice.get().spanAround(joinPoint) //
                : joinPoint.proceed();
    }

    boolean isQueryByExampleExecutorDeclaringType(JoinPoint joinPoint) {
        return joinPoint.getSignature().getDeclaringType().equals(QueryByExampleExecutor.class);
    }

}