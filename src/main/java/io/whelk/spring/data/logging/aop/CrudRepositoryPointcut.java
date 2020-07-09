package io.whelk.spring.data.logging.aop;

import static org.springframework.boot.logging.LogLevel.DEBUG;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class CrudRepositoryPointcut {

    private final LogAdvice logAdvice;

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.count())))")
    private void count() { }

    @Before("count()")
    public void logBeforeCount(JoinPoint joinPoint) throws Throwable {
        logAdvice.logBefore(joinPoint, DEBUG, true);
    }

    @AfterReturning(pointcut = "count()", returning = "returnType")
    public void logAfterCount(JoinPoint joinPoint, Object returnType) {
        logAdvice.logAfter(joinPoint, DEBUG, true, returnType);
    }

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.findById(..))))")
    private void findById() { }

    @Before("findById()")
    public void logBeforeFindById(JoinPoint joinPoint) throws Throwable {
        logAdvice.logBefore(joinPoint, DEBUG, true);
    }

    @AfterReturning(pointcut = "findById()", returning = "returnType")
    public void logAfterFindById(JoinPoint joinPoint, Object returnType) {
        logAdvice.logAfter(joinPoint, DEBUG, true, returnType);
    }



    // @Log.Trace.Around
    // @Override
    // boolean existsById(ID id);

    // @Log.Trace.Around
    // @Override
    // long count();

    // @Log.Trace.Around
    // @Override
    // Iterable<T> findAll();

    // @Log.Trace.Around
    // @Override
    // Iterable<T> findAllById(Iterable<ID> ids);

    // @Log.Debug.Around
    // @Log.Span
    // @Override
    // <S extends T> S save(S entity);

    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.save(..))))")
    private void save() { }

    @Before("save()")
    public void logBeforeSave(JoinPoint joinPoint) throws Throwable {
        logAdvice.logBefore(joinPoint, DEBUG, true);
    }

    @AfterReturning(pointcut = "save()", returning = "returnType")
    public void logAfterSave(JoinPoint joinPoint, Object returnType) {
        logAdvice.logAfter(joinPoint, DEBUG, true, returnType);
    }

    // @Log.Debug.Around
    // @Log.Span
    // @Override
    // <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    // @Log.Debug.Around
    // @Log.Span
    // @Override
    // void deleteById(ID id);

    // @Log.Debug.Around
    // @Log.Span
    // @Override
    // void delete(T entity);

    // @Log.Debug.Around
    // @Log.Span
    // @Override
    // void deleteAll(Iterable<? extends T> entities);

    // @Log.Debug.Around
    // @Log.Span
    // @Override
    // void deleteAll();

}