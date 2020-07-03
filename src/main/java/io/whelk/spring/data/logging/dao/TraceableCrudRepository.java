package io.whelk.spring.data.logging.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.whelk.spring.data.logging.aop.Log;

@NoRepositoryBean
public interface TraceableCrudRepository<T, ID> extends CrudRepository<T, ID> {

    @Log.Trace.Around
    @Override
    boolean existsById(ID id);

    @Log.Trace.Around
    @Override
    long count();

    @Log.Trace.Around
    @Override
    Optional<T> findById(ID id);

    @Log.Trace.Around
    @Override
    Iterable<T> findAll();
    
    @Log.Trace.Around
    @Override
    Iterable<T> findAllById(Iterable<ID> ids);

    @Log.Debug.Around
    @Log.Span
    @Override
	<S extends T> S save(S entity);
    
    @Log.Debug.Around
    @Log.Span
    @Override
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
    
    @Log.Debug.Around
    @Log.Span
    @Override
    void deleteById(ID id);
    
    @Log.Debug.Around
    @Log.Span
    @Override
    void delete(T entity);
    
    @Log.Debug.Around
    @Log.Span
    @Override
    void deleteAll(Iterable<? extends T> entities);
    
    @Log.Debug.Around
    @Log.Span
    @Override
	void deleteAll();

}