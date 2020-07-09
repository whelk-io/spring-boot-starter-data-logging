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

    public void logBefore(JoinPoint joinPoint, LogLevel logLevel, boolean withArgs) { 
        var logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
        var methodName = joinPoint.getSignature().getName();
        var args = joinPoint.getArgs();

        switch(logLevel) {
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
            default: break;
        }
    }

    public void logAfter(JoinPoint joinPoint, LogLevel logLevel, boolean withReturnType, Object returnType) { 
        var logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
        var signature = joinPoint.getSignature();

        switch(logLevel) {
            case TRACE: {
                if (logger.isTraceEnabled()) {
                    var message = generateAfterMessage(signature, withReturnType, returnType);
                    logger.trace(message);
                }
                break;
            }
            case DEBUG: {
                if (logger.isDebugEnabled()) {
                    var message = generateAfterMessage(signature, withReturnType, returnType);
                    logger.debug(message);
                }
                break;
            }
            case INFO: {
                if (logger.isInfoEnabled()) {
                    var message = generateAfterMessage(signature, withReturnType, returnType);
                    logger.info(message);
                }
                break;
            }
            case WARN: {
                if (logger.isWarnEnabled()) {
                    var message = generateAfterMessage(signature, withReturnType, returnType);
                    logger.warn(message);
                }
                break;
            }
            case ERROR: {
                if (logger.isErrorEnabled()) {
                    var message = generateAfterMessage(signature, withReturnType, returnType);
                    logger.error(message);
                }
                break;
            }
            case FATAL: {
                var message = generateAfterMessage(signature, withReturnType, returnType);
                logger.error(message);
                break;
            }
            case OFF: break;
            default: 
        }
    }

    String generateAfterMessage(Signature signature, boolean withReturnType, Object returnType) {
        var methodName = signature.getName();
        if (withReturnType && !isVoidReturnType(signature)) { 
            var returnTypeString = this.loggingConfigurer.argWriter().argToString(returnType);
            return String.format(loggingConfigurer.afterMethodWithReturnType(), methodName, returnTypeString);
        } else {
            return String.format(loggingConfigurer.afterMethodMessage(), methodName);
        }
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
            return String.format(loggingConfigurer.beforeMethodWithArgsMessage(), methodName, argsJoined);
        } else { 
            return String.format(loggingConfigurer.beforeMethodMessage(), methodName);
        }
    }
    
}
