package io.whelk.spring.data.logging.aop;

import static org.springframework.boot.logging.LogLevel.DEBUG;
import static org.springframework.boot.logging.LogLevel.ERROR;

import java.util.Optional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import io.whelk.spring.data.logging.sleuth.TracerAdvice;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Aspect
@Component
@RequiredArgsConstructor
public class JpaRepositoryPointcut {

    protected final LogAdvice logAdvice;
    protected final Optional<TracerAdvice> tracerAdvice;

    // T getOne(ID id);

	// <S extends T> List<S> findAll(Example<S> example);

	// <S extends T> List<S> findAll(Example<S> example, Sort sort);

	// List<T> findAll();

	// List<T> findAll(Sort sort);

	// List<T> findAllById(Iterable<ID> ids);

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.saveAll(*))")
    void saveAll() { }

    @Before("saveAll()")
    void saveAllBefore(JoinPoint joinPoint) throws Throwable {
        if (isJpaRepositoryDeclaringType(joinPoint))
            logAdvice.logBefore(joinPoint, DEBUG);
    }

    @AfterReturning(pointcut = "saveAll()", returning = "returnType")
    void saveAfterReturning(JoinPoint joinPoint, Object returnType) {
        if (isJpaRepositoryDeclaringType(joinPoint))
            logAdvice.logAfterReturning(joinPoint, DEBUG, returnType);
    }

    @AfterThrowing(pointcut = "saveAll()", throwing = "e")
    void saveAfterThrowing(JoinPoint joinPoint, Exception e) {
        if (isJpaRepositoryDeclaringType(joinPoint))
            logAdvice.logAfterThrowing(joinPoint, ERROR, e);
    }

    @SneakyThrows
    @Around("saveAll()")
    Object saveAround(ProceedingJoinPoint joinPoint) { 
        return tracerAdvice.isPresent() && isJpaRepositoryDeclaringType(joinPoint)
            ? tracerAdvice.get().spanAround(joinPoint)
            : joinPoint.proceed();
    }

    boolean isJpaRepositoryDeclaringType(JoinPoint joinPoint) {
        return joinPoint.getSignature().getDeclaringType().equals(JpaRepository.class);
    }


	// void flush();

	// <S extends T> S saveAndFlush(S entity);

	// void deleteInBatch(Iterable<T> entities);

	// void deleteAllInBatch();

}