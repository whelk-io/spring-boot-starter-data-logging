package io.whelk.spring.data.logging.dao;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.whelk.spring.data.logging.aop.Log;

@NoRepositoryBean
public interface TraceableJpaRepository<T, ID>
         extends JpaRepository<T, ID>, 
                 TraceablePagingAndSortingRepository<T, ID>, 
                 TraceableQueryByExampleExecutor<T> {

    @Log.Trace.Around
    @Override
    T getOne(ID id);

    @Log.Trace.Around
    @Override
    List<T> findAll();

    @Log.Trace.Around
    @Override
    List<T> findAll(Sort sort);

    @Log.Trace.Around
    @Override
    <S extends T> List<S> findAll(Example<S> example);

    @Log.Trace.Around
    @Override
    <S extends T> List<S> findAll(Example<S> example, Sort sort);

    @Log.Trace.Around
    @Override
    List<T> findAllById(Iterable<ID> ids);

    @Log.Trace.Around
    @Override
    void flush();

    @Log.Debug.Around
    @Log.Span
    @Override
    <S extends T> List<S> saveAll(Iterable<S> entities);

    @Log.Debug.Around
    @Log.Span
    @Override
    <S extends T> S saveAndFlush(S entity);

    @Log.Debug.Around
    @Log.Span
    @Override
    void deleteInBatch(Iterable<T> entities);

    @Log.Debug.Around
    @Log.Span
    @Override
    void deleteAllInBatch();

}