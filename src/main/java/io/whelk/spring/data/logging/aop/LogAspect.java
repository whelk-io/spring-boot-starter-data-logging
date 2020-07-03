package io.whelk.spring.data.logging.aop;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;

import io.whelk.spring.data.logging.configurer.LoggingConfigurer;
import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class LogAspect {

    private final LoggingConfigurer loggingConfigurer;

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Around around) {
        logBefore(joinPoint, around.withLevel(), around.withArgs());
    }

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Trace.Around around) {
        logBefore(joinPoint, LogLevel.TRACE, around.withArgs());
    }

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Debug.Around around) {
        logBefore(joinPoint, LogLevel.DEBUG, around.withArgs());
    }

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Info.Around around) {
        logBefore(joinPoint, LogLevel.INFO, around.withArgs());
    }

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Warn.Around around) {
        logBefore(joinPoint, LogLevel.WARN, around.withArgs());
    }

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Error.Around around) {
        logBefore(joinPoint, LogLevel.ERROR, around.withArgs());
    }

    @Before("@annotation(around)")
    public void logBefore(JoinPoint joinPoint, Log.Fatal.Around around) {
        logBefore(joinPoint, LogLevel.FATAL, around.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Before before) {
        logBefore(joinPoint, before.withLevel(), before.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Trace.Before before) {
        logBefore(joinPoint, LogLevel.TRACE, before.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Debug.Before before) {
        logBefore(joinPoint, LogLevel.DEBUG, before.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Info.Before before) {
        logBefore(joinPoint, LogLevel.INFO, before.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Warn.Before before) {
        logBefore(joinPoint, LogLevel.WARN, before.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Error.Before before) {
        logBefore(joinPoint, LogLevel.ERROR, before.withArgs());
    }

    @Before("@annotation(before)")
    public void logBefore(JoinPoint joinPoint, Log.Fatal.Before before) {
        logBefore(joinPoint, LogLevel.FATAL, before.withArgs());
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.After after) {
        logAfter(joinPoint, after.withLevel(), false, null);
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.Trace.After after) {
        logAfter(joinPoint, LogLevel.TRACE, false, null);
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.Debug.After after) {
        logAfter(joinPoint, LogLevel.DEBUG, false, null);
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.Info.After after) {
        logAfter(joinPoint, LogLevel.INFO, false, null);
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.Warn.After after) {
        logAfter(joinPoint, LogLevel.WARN, false, null);
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.Error.After after) {
        logAfter(joinPoint, LogLevel.ERROR, false, null);
    }

    @After("@annotation(after)")
    public void logAfter(JoinPoint joinPoint, Log.Fatal.After after) {
        logAfter(joinPoint, LogLevel.FATAL, false, null);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.AfterReturning afterReturning, Object returnType) {
        logAfter(joinPoint, afterReturning.withLevel(), true, returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Trace.AfterReturning afterReturning, Object returnType) {
        logAfter(joinPoint, LogLevel.TRACE, true, returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Debug.AfterReturning afterReturning, Object returnType) {
        logAfter(joinPoint, LogLevel.DEBUG, true, returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Info.AfterReturning afterReturning, Object returnType) {
        logAfter(joinPoint, LogLevel.INFO, true, returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Warn.AfterReturning afterReturning, Object returnType) {
        logAfter(joinPoint, LogLevel.WARN, true, returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Error.AfterReturning afterReturning, Object returnType) {
        logAfter(joinPoint, LogLevel.ERROR, true, returnType);
    }

    @AfterReturning(value = "@annotation(afterReturning)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Fatal.AfterReturning afterReturning, Object returnType) {
        logAfter(joinPoint, LogLevel.FATAL, true, returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Around around, Object returnType) {
        logAfter(joinPoint, around.withLevel(), around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Trace.Around around, Object returnType) {
        logAfter(joinPoint, LogLevel.TRACE, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Debug.Around around, Object returnType) {
        logAfter(joinPoint, LogLevel.DEBUG, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Info.Around around, Object returnType) {
        logAfter(joinPoint, LogLevel.INFO, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Warn.Around around, Object returnType) {
        logAfter(joinPoint, LogLevel.WARN, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Error.Around around, Object returnType) {
        logAfter(joinPoint, LogLevel.ERROR, around.withReturnType(), returnType);
    }

    @AfterReturning(value = "@annotation(around)", returning = "returnType")
    public void logAfter(JoinPoint joinPoint, Log.Fatal.Around around, Object returnType) {
        logAfter(joinPoint, LogLevel.FATAL, around.withReturnType(), returnType);
    }

    void logBefore(JoinPoint joinPoint, LogLevel logLevel, boolean withArgs) { 
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
            case OFF: { 
                break;
            }
        }
    }

    void logAfter(JoinPoint joinPoint, LogLevel logLevel, boolean withReturnType, Object returnType) { 
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
            case OFF: { 
                break;
            }
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