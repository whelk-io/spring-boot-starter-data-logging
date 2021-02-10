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

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import io.whelk.spring.data.logging.configurer.LoggingConfigurer;
import io.whelk.spring.data.logging.writer.ArgWriter;
import io.whelk.spring.data.logging.writer.ReturnTypeWriter;
import lombok.RequiredArgsConstructor;

/**
 * @author Zack Teater
 * @since 0.1.0
 */
@Component
@RequiredArgsConstructor
public class LogAdvice {

    private final LoggingConfigurer loggingConfigurer;
    private final ApplicationContext applicationContext;

    void logBefore(JoinPoint joinPoint, Log.Level logLevel) {
        logBefore(joinPoint, logLevel, true, loggingConfigurer.argWriter());
    }

    void logBefore(JoinPoint joinPoint, Log.Level logLevel, Log.Args args) {
        var argWriter = this.getArgWriterBean(args.withWriter());
        logBefore(joinPoint, logLevel, args.enabled(), argWriter);
    }

    void logBefore(JoinPoint joinPoint, Log.Level logLevel, boolean enabled, ArgWriter argWriter) {
        var logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());

        switch (logLevel) {
            case Trace: {
                if (logger.isTraceEnabled()) {
                    var message = generateBeforeMessage(joinPoint, enabled, argWriter);
                    logger.trace(message);
                }
                break;
            }
            case Debug: {
                if (logger.isDebugEnabled()) {
                    var message = generateBeforeMessage(joinPoint, enabled, argWriter);
                    logger.debug(message);
                }
                break;
            }
            case Info: {
                if (logger.isInfoEnabled()) {
                    var message = generateBeforeMessage(joinPoint, enabled, argWriter);
                    logger.info(message);
                }
                break;
            }
            case Warn: {
                if (logger.isWarnEnabled()) {
                    var message = generateBeforeMessage(joinPoint, enabled, argWriter);
                    logger.warn(message);
                }
                break;
            }
            case Error: {
                if (logger.isErrorEnabled()) {
                    var message = generateBeforeMessage(joinPoint, enabled, argWriter);
                    logger.error(message);
                }
                break;
            }
            case Fatal: {
                var message = generateBeforeMessage(joinPoint, enabled, argWriter);
                logger.error(message);
                break;
            }
            case Off:
            default:
                break;
        }
    }

    void logAfter(JoinPoint joinPoint, Log.Level logLevel) {

        var signature = joinPoint.getSignature();
        var logger = LoggerFactory.getLogger(signature.getDeclaringType());

        switch (logLevel) {
            case Trace: {
                if (logger.isTraceEnabled()) {
                    var message = generateAfterMessage(signature);
                    logger.trace(message);
                }
                break;
            }
            case Debug: {
                if (logger.isDebugEnabled()) {
                    var message = generateAfterMessage(signature);
                    logger.debug(message);
                }
                break;
            }
            case Info: {
                if (logger.isInfoEnabled()) {
                    var message = generateAfterMessage(signature);
                    logger.info(message);
                }
                break;
            }
            case Warn: {
                if (logger.isWarnEnabled()) {
                    var message = generateAfterMessage(signature);
                    logger.warn(message);
                }
                break;
            }
            case Error: {
                if (logger.isErrorEnabled()) {
                    var message = generateAfterMessage(signature);
                    logger.error(message);
                }
                break;
            }
            case Fatal: {
                var message = generateAfterMessage(signature);
                logger.error(message);
                break;
            }
            case Off:
                break;
            default:
        }
    }

    void logAfterReturning(JoinPoint joinPoint, Log.Level withLogLevel, Object returnType) {

        var returnTypeWriterBean = this.getReturnTypeWriterBean(null);
        logAfterReturning(joinPoint, withLogLevel, true, returnTypeWriterBean, returnType);

    }

    void logAfterReturning(JoinPoint joinPoint, Log.Level withLogLevel, Log.ReturnType withReturnType,
            Object returnType) {

        var returnTypeWriterBean = this.getReturnTypeWriterBean(withReturnType.withWriter());
        logAfterReturning(joinPoint, withLogLevel, withReturnType.enabled(), returnTypeWriterBean, returnType);

    }

    void logAfterReturning(JoinPoint joinPoint, Log.Level logLevel, boolean enabled, ReturnTypeWriter returnTypeWriter,
            Object returnType) {

        var signature = joinPoint.getSignature();
        var logger = LoggerFactory.getLogger(signature.getDeclaringType());

        if (!enabled || isVoidReturnType(signature)) {
            this.logAfter(joinPoint, logLevel);
            return;
        }

        switch (logLevel) {
            case Trace: {
                if (logger.isTraceEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnTypeWriter, returnType);
                    logger.trace(message);
                }
                break;
            }
            case Debug: {
                if (logger.isDebugEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnTypeWriter, returnType);
                    logger.debug(message);
                }
                break;
            }
            case Info: {
                if (logger.isInfoEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnTypeWriter, returnType);
                    logger.info(message);
                }
                break;
            }
            case Warn: {
                if (logger.isWarnEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnTypeWriter, returnType);
                    logger.warn(message);
                }
                break;
            }
            case Error: {
                if (logger.isErrorEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnTypeWriter, returnType);
                    logger.error(message);
                }
                break;
            }
            case Fatal: {
                var message = generateAfterReturningMessage(signature, returnTypeWriter, returnType);
                logger.error(message);
                break;
            }
            case Off:
                break;
            default:
        }

    }

    void logAfterThrowing(JoinPoint joinPoint, Log.Level logLevel, Exception e) {
        logAfterThrowing(joinPoint, logLevel, true, e);
    }

    void logAfterThrowing(JoinPoint joinPoint, Log.Level logLevel, boolean withStackTrace, Exception e) {

        var signature = joinPoint.getSignature();
        var logger = LoggerFactory.getLogger(signature.getDeclaringType());

        switch (logLevel) {
            case Trace: {
                if (logger.isTraceEnabled()) {
                    var message = generateAfterThrowingMessage(signature, e);
                    if (withStackTrace)
                        logger.trace(message, e);
                    else
                        logger.trace(message);
                }
                break;
            }
            case Debug: {
                if (logger.isDebugEnabled()) {
                    var message = generateAfterThrowingMessage(signature, e);
                    if (withStackTrace)
                        logger.debug(message, e);
                    else
                        logger.debug(message);
                }
                break;
            }
            case Info: {
                if (logger.isInfoEnabled()) {
                    var message = generateAfterThrowingMessage(signature, e);
                    if (withStackTrace)
                        logger.info(message, e);
                    else
                        logger.info(message);
                }
                break;
            }
            case Warn: {
                if (logger.isWarnEnabled()) {
                    var message = generateAfterThrowingMessage(signature, e);
                    if (withStackTrace)
                        logger.warn(message, e);
                    else
                        logger.warn(message);
                }
                break;
            }
            case Error: {
                if (logger.isErrorEnabled()) {
                    var message = generateAfterThrowingMessage(signature, e);
                    if (withStackTrace)
                        logger.error(message, e);
                    else
                        logger.error(message);
                }
                break;
            }
            case Fatal: {
                var message = generateAfterThrowingMessage(signature, e);
                if (withStackTrace)
                    logger.error(message, e);
                else
                    logger.error(message);
                break;
            }
            case Off:
                break;
            default:
        }

    }

    String generateAfterMessage(Signature signature) {
        return String.format(loggingConfigurer.afterMessage(), signature.getName());
    }

    String generateAfterReturningMessage(Signature signature, ReturnTypeWriter returnTypeWriter, Object returnType) {

        var methodName = signature.getName();
        var returnTypeString = returnTypeWriter.toString(returnType);
        return String.format(loggingConfigurer.afterReturningMessage(), methodName, returnTypeString);

    }

    ReturnTypeWriter getReturnTypeWriterBean(Class<? extends ReturnTypeWriter> returnTypeWriter) {
        return returnTypeWriter == null || ReturnTypeWriter.class.equals(returnTypeWriter)
                ? this.loggingConfigurer.returnTypeWriter()
                : applicationContext.getBean(returnTypeWriter);
    }

    String generateAfterThrowingMessage(Signature signature, Exception e) {
        var methodName = signature.getName();
        return String.format(loggingConfigurer.afterThrowingMessage(), methodName, e.getClass().getName(),
                e.getMessage());
    }

    boolean isVoidReturnType(Signature signature) {
        return Void.TYPE.equals(MethodSignature.class.cast(signature).getReturnType());
    }

    String generateBeforeMessage(JoinPoint joinPoint, boolean enabled, ArgWriter argWriter) {
        var methodArgs = joinPoint.getArgs();
        var methodName = joinPoint.getSignature().getName();

        if (enabled && methodArgs != null && methodArgs.length > 0) {
            var argsJoined = Arrays.stream(methodArgs).map(argWriter::argToString).collect(Collectors.joining(", "));
            return String.format(loggingConfigurer.beforeWithArgsMessage(), methodName, argsJoined);
        } else {
            return String.format(loggingConfigurer.beforeMessage(), methodName);
        }

    }

    ArgWriter getArgWriterBean(Class<? extends ArgWriter> argWriter) {
        return argWriter == null || ArgWriter.class.equals(argWriter) ? this.loggingConfigurer.argWriter()
                : applicationContext.getBean(argWriter);
    }

}
