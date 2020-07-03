package io.whelk.spring.data.logging.dao;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.whelk.spring.data.logging.aop.Log;

@NoRepositoryBean
public interface TraceableMongoRepository<T, ID>
         extends MongoRepository<T, ID>, 
                 TraceablePagingAndSortingRepository<T, ID>, 
                 TraceableQueryByExampleExecutor<T> {

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

    @Log.Debug.Around
    @Log.Span
    @Override
    <S extends T> List<S> saveAll(Iterable<S> entities);

    @Log.Trace.Around
    @Log.Span
    @Override
    <S extends T> S insert(S entity);

    @Log.Trace.Around
    @Log.Span
    @Override
    <S extends T> List<S> insert(Iterable<S> entities);

}