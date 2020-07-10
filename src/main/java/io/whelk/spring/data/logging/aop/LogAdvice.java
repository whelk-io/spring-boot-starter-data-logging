package io.whelk.spring.data.logging.aop;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;

import io.whelk.spring.data.logging.configurer.LoggingConfigurer;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LogAdvice {

    private final LoggingConfigurer loggingConfigurer;

    public void logBefore(JoinPoint joinPoint, LogLevel logLevel) {
        logBefore(joinPoint, logLevel, true);
    }

    public void logBefore(JoinPoint joinPoint, LogLevel logLevel, boolean withArgs) {

        var logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
        var methodName = joinPoint.getSignature().getName();
        var args = joinPoint.getArgs();

        switch (logLevel) {
            case TRACE: {
                if (logger.isTraceEnabled()) {
                    var message = generateBeforeMessage(methodName, withArgs, args);
                    logger.trace(message);
                }
                break;
            }
            case DEBUG: {
                if (logger.isDebugEnabled()) {
                    var message = generateBeforeMessage(methodName, withArgs, args);
                    logger.debug(message);
                }
                break;
            }
            case INFO: {
                if (logger.isInfoEnabled()) {
                    var message = generateBeforeMessage(methodName, withArgs, args);
                    logger.info(message);
                }
                break;
            }
            case WARN: {
                if (logger.isWarnEnabled()) {
                    var message = generateBeforeMessage(methodName, withArgs, args);
                    logger.warn(message);
                }
                break;
            }
            case ERROR: {
                if (logger.isErrorEnabled()) {
                    var message = generateBeforeMessage(methodName, withArgs, args);
                    logger.error(message);
                }
                break;
            }
            case FATAL: {
                var message = generateBeforeMessage(methodName, withArgs, args);
                logger.error(message);
                break;
            }
            case OFF:
            default:
                break;
        }
    }

    public void logAfter(JoinPoint joinPoint, LogLevel logLevel) {

        var signature = joinPoint.getSignature();
        var logger = LoggerFactory.getLogger(signature.getDeclaringType());

        switch (logLevel) {
            case TRACE: {
                if (logger.isTraceEnabled()) {
                    var message = generateAfterMessage(signature);
                    logger.trace(message);
                }
                break;
            }
            case DEBUG: {
                if (logger.isDebugEnabled()) {
                    var message = generateAfterMessage(signature);
                    logger.debug(message);
                }
                break;
            }
            case INFO: {
                if (logger.isInfoEnabled()) {
                    var message = generateAfterMessage(signature);
                    logger.info(message);
                }
                break;
            }
            case WARN: {
                if (logger.isWarnEnabled()) {
                    var message = generateAfterMessage(signature);
                    logger.warn(message);
                }
                break;
            }
            case ERROR: {
                if (logger.isErrorEnabled()) {
                    var message = generateAfterMessage(signature);
                    logger.error(message);
                }
                break;
            }
            case FATAL: {
                var message = generateAfterMessage(signature);
                logger.error(message);
                break;
            }
            case OFF:
                break;
            default:
        }
    }

    public void logAfterReturning(JoinPoint joinPoint, LogLevel logLevel, Object returnType) {
        logAfterReturning(joinPoint, logLevel, true, returnType);
    }

    public void logAfterReturning(JoinPoint joinPoint, LogLevel logLevel, boolean withReturnType, Object returnType) {
        var signature = joinPoint.getSignature();
        var logger = LoggerFactory.getLogger(signature.getDeclaringType());

        if (!withReturnType || isVoidReturnType(signature) ) {
            this.logAfter(joinPoint, logLevel);
            return;
        }

        switch (logLevel) {
            case TRACE: {
                if (logger.isTraceEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnType);
                    logger.trace(message);
                }
                break;
            }
            case DEBUG: {
                if (logger.isDebugEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnType);
                    logger.debug(message);
                }
                break;
            }
            case INFO: {
                if (logger.isInfoEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnType);
                    logger.info(message);
                }
                break;
            }
            case WARN: {
                if (logger.isWarnEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnType);
                    logger.warn(message);
                }
                break;
            }
            case ERROR: {
                if (logger.isErrorEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnType);
                    logger.error(message);
                }
                break;
            }
            case FATAL: {
                var message = generateAfterReturningMessage(signature, returnType); 
                logger.error(message);
                break;
            }
            case OFF:
                break;
            default:
        }

    }

    public void logAfterThrowing(JoinPoint joinPoint, LogLevel logLevel, Exception e) {
        logAfterThrowing(joinPoint, logLevel, true, e);
    }

    public void logAfterThrowing(JoinPoint joinPoint, LogLevel logLevel, boolean withStacktrace, Exception e) {

        var signature = joinPoint.getSignature();
        var logger = LoggerFactory.getLogger(signature.getDeclaringType());

        switch (logLevel) {
            case TRACE: {
                if (logger.isTraceEnabled()) {
                    var message = generateAfterThrowingMessage(signature, e);
                    if (withStacktrace) 
                        logger.trace(message, e);
                    else
                        logger.trace(message);
                }
                break;
            }
            case DEBUG: {
                if (logger.isDebugEnabled()) {
                    var message = generateAfterThrowingMessage(signature, e);
                    if (withStacktrace) 
                        logger.debug(message, e);
                    else
                        logger.debug(message);
                }
                break;
            }
            case INFO: {
                if (logger.isInfoEnabled()) {
                    var message = generateAfterThrowingMessage(signature, e);
                    if (withStacktrace) 
                        logger.info(message, e);
                    else
                        logger.info(message);
                }
                break;
            }
            case WARN: {
                if (logger.isWarnEnabled()) {
                    var message = generateAfterThrowingMessage(signature, e);
                    if (withStacktrace) 
                        logger.warn(message, e);
                    else
                        logger.warn(message);
                }
                break;
            }
            case ERROR: {
                if (logger.isErrorEnabled()) {
                    var message = generateAfterThrowingMessage(signature, e);
                    if (withStacktrace) 
                        logger.error(message, e);
                    else
                        logger.error(message);
                }
                break;
            }
            case FATAL: {
                var message = generateAfterThrowingMessage(signature, e);
                if (withStacktrace) 
                    logger.error(message, e);
                else
                    logger.error(message);
                break;
            }
            case OFF:
                break;
            default:
        }

    }

    String generateAfterMessage(Signature signature) {
        return String.format(loggingConfigurer.afterMessage(), signature.getName());
    }

    String generateAfterReturningMessage(Signature signature, Object returnType) { 
        var methodName = signature.getName();
        var returnTypeString = this.loggingConfigurer.argWriter().argToString(returnType);
        return String.format(loggingConfigurer.afterReturningMessage(), methodName, returnTypeString);
    }

    String generateAfterThrowingMessage(Signature signature, Exception e) { 
        var methodName = signature.getName();
        return String.format(loggingConfigurer.afterThrowingMessage(), methodName, e.getClass().getName(), e.getMessage());
    }

    boolean isVoidReturnType(Signature signature) {
        return Void.TYPE.equals(MethodSignature.class.cast(signature).getReturnType());
    }

    String generateBeforeMessage(String methodName, boolean withArgs, Object[] args) {
        if (withArgs && args != null && args.length > 0) {
            var argsJoined = 
                Arrays
                    .stream(args)
                    .map(this.loggingConfigurer.argWriter()::argToString)
                    .collect(Collectors.joining(", "));
            return String.format(loggingConfigurer.beforeWithArgsMessage(), methodName, argsJoined);
        } else {
            return String.format(loggingConfigurer.beforeMessage(), methodName);
        }
    }

}
