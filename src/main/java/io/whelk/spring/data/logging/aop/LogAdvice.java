package io.whelk.spring.data.logging.aop;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import io.whelk.spring.data.logging.configurer.LoggingConfigurer;
import io.whelk.spring.data.logging.writer.ArgWriter;
import io.whelk.spring.data.logging.writer.ReturnTypeWriter;
import io.whelk.spring.data.logging.writer.SimpleArgWriter;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LogAdvice {

    private final LoggingConfigurer loggingConfigurer;
    private final ApplicationContext applicationContext;

    void logBefore(JoinPoint joinPoint, LogLevel logLevel) { 
        logBefore(joinPoint, logLevel, true, SimpleArgWriter.class);
    }

    void logBefore(JoinPoint joinPoint, LogLevel logLevel, Log.Args args) {
        logBefore(joinPoint, logLevel, args.enabled(), args.withWriter());
    }

    void logBefore(JoinPoint joinPoint, LogLevel logLevel, boolean enabled, Class<? extends ArgWriter> argWriter) {
        var logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());

        switch (logLevel) {
            case TRACE: {
                if (logger.isTraceEnabled()) {
                    var message = generateBeforeMessage(joinPoint, enabled, argWriter);
                    logger.trace(message);
                }
                break;
            }
            case DEBUG: {
                if (logger.isDebugEnabled()) {
                    var message = generateBeforeMessage(joinPoint, enabled, argWriter);
                    logger.debug(message);
                }
                break;
            }
            case INFO: {
                if (logger.isInfoEnabled()) {
                    var message = generateBeforeMessage(joinPoint, enabled, argWriter);
                    logger.info(message);
                }
                break;
            }
            case WARN: {
                if (logger.isWarnEnabled()) {
                    var message = generateBeforeMessage(joinPoint, enabled, argWriter);
                    logger.warn(message);
                }
                break;
            }
            case ERROR: {
                if (logger.isErrorEnabled()) {
                    var message = generateBeforeMessage(joinPoint, enabled, argWriter);
                    logger.error(message);
                }
                break;
            }
            case FATAL: {
                var message = generateBeforeMessage(joinPoint, enabled, argWriter);
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

    public void logAfterReturning(
            JoinPoint joinPoint, 
            LogLevel logLevel, 
            Object returnType) {

        logAfterReturning(joinPoint, logLevel, true, null, returnType);

    }

    public void logAfterReturning(
        JoinPoint joinPoint, 
        LogLevel logLevel, 
        Class<? extends ReturnTypeWriter> returnTypeWriter, 
        Object returnType) {

        logAfterReturning(joinPoint, logLevel, true, returnTypeWriter, returnType);

    }

    public void logAfterReturning(
            JoinPoint joinPoint, 
            LogLevel logLevel, 
            boolean withReturnType, 
            Class<? extends ReturnTypeWriter> returnTypeWriter,
            Object returnType) {
        var signature = joinPoint.getSignature();
        var logger = LoggerFactory.getLogger(signature.getDeclaringType());

        if (!withReturnType || isVoidReturnType(signature) ) {
            this.logAfter(joinPoint, logLevel);
            return;
        }

        switch (logLevel) {
            case TRACE: {
                if (logger.isTraceEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnTypeWriter, returnType);
                    logger.trace(message);
                }
                break;
            }
            case DEBUG: {
                if (logger.isDebugEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnTypeWriter, returnType);
                    logger.debug(message);
                }
                break;
            }
            case INFO: {
                if (logger.isInfoEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnTypeWriter, returnType);
                    logger.info(message);
                }
                break;
            }
            case WARN: {
                if (logger.isWarnEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnTypeWriter, returnType);
                    logger.warn(message);
                }
                break;
            }
            case ERROR: {
                if (logger.isErrorEnabled()) {
                    var message = generateAfterReturningMessage(signature, returnTypeWriter, returnType);
                    logger.error(message);
                }
                break;
            }
            case FATAL: {
                var message = generateAfterReturningMessage(signature, returnTypeWriter, returnType); 
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

    String generateAfterReturningMessage(
            Signature signature, 
            Class<? extends ReturnTypeWriter> returnTypeWriter, 
            Object returnType) { 

        var methodName = signature.getName();
        var returnTypeString = this.getReturnTypeWriterBean(returnTypeWriter).toString(returnType);
        return String.format(loggingConfigurer.afterReturningMessage(), methodName, returnTypeString);

    }

    ReturnTypeWriter getReturnTypeWriterBean(Class<? extends ReturnTypeWriter> returnTypeWriter) { 
        return returnTypeWriter == null || ReturnTypeWriter.class.equals(returnTypeWriter)
               ? this.loggingConfigurer.returnTypeWriter() 
               : applicationContext.getBean(returnTypeWriter);
    }

    String generateAfterThrowingMessage(Signature signature, Exception e) { 
        var methodName = signature.getName();
        return String.format(loggingConfigurer.afterThrowingMessage(), methodName, e.getClass().getName(), e.getMessage());
    }

    boolean isVoidReturnType(Signature signature) {
        return Void.TYPE.equals(MethodSignature.class.cast(signature).getReturnType());
    }

    String generateBeforeMessage(JoinPoint joinPoint, boolean enabled, Class<? extends ArgWriter> argWriter) {
        var methodArgs = joinPoint.getArgs();
        var methodName = joinPoint.getSignature().getName();

        if (enabled && methodArgs != null && methodArgs.length > 0) {
            var argWriterBean = this.getArgWriterBean(argWriter);
            var argsJoined = 
                Arrays
                    .stream(methodArgs)
                    .map(argWriterBean::argToString)
                    .collect(Collectors.joining(", "));
            return String.format(loggingConfigurer.beforeWithArgsMessage(), methodName, argsJoined);
        } else {
            return String.format(loggingConfigurer.beforeMessage(), methodName);
        }

    }

    ArgWriter getArgWriterBean(Class<? extends ArgWriter> argWriter) { 
        return argWriter == null || ArgWriter.class.equals(argWriter)
               ? this.loggingConfigurer.argWriter() 
               : applicationContext.getBean(argWriter);
    }

}
