package io.whelk.spring.data.logging.dao;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import io.whelk.spring.data.logging.aop.Log;

@NoRepositoryBean
public interface TraceableQueryByExampleExecutor<T> extends QueryByExampleExecutor<T> {

    @Log.Trace.Around
    @Override
    <S extends T> long count(Example<S> example);

    @Log.Trace.Around
    @Override
    <S extends T> boolean exists(Example<S> example);

    @Log.Trace.Around
    @Override
    <S extends T> Optional<S> findOne(Example<S> example);

    @Log.Trace.Around
    @Override
    <S extends T> Iterable<S> findAll(Example<S> example);

    @Log.Trace.Around
    @Override
    <S extends T> Iterable<S> findAll(Example<S> example, Sort sort);

    @Log.Trace.Around
    @Override
    <S extends T> Page<S> findAll(Example<S> example, Pageable pageable);

}