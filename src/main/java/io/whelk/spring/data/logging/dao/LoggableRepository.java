package io.whelk.spring.data.logging.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.whelk.spring.data.logging.aop.Log;

@NoRepositoryBean
public interface LoggableRepository<T, ID> extends JpaRepository<T, ID> {

    @Log.Trace.AfterReturning
    @Override
    long count();

    @Log.Trace.Around
    @Override
    <S extends T> long count(Example<S> example);

    @Log.Trace.Around
    @Override
    boolean existsById(ID id);

    @Log.Trace.Around
    @Override
    <S extends T> boolean exists(Example<S> example);

    @Log.Trace.Around
    @Override
    Optional<T> findById(ID id);

    @Log.Trace.Around
    @Override
    T getOne(ID id);

    @Log.Trace.Around
    @Override
    <S extends T> Optional<S> findOne(Example<S> example);

    @Log.Trace.AfterReturning
    @Override
    List<T> findAll();

    @Log.Trace.Around
    @Override
    List<T> findAll(Sort sort);

    @Log.Trace.Around
    @Override
    Page<T> findAll(Pageable pageable);

    @Log.Trace.Around
    @Override
    List<T> findAllById(Iterable<ID> ids);

    @Log.Trace.Around
    @Override
    <S extends T> List<S> findAll(Example<S> example);

    @Log.Trace.Around
    @Override
    <S extends T> List<S> findAll(Example<S> example, Sort sort);

    @Log.Trace.Around
    @Override
    <S extends T> Page<S> findAll(Example<S> example, Pageable pageable);

    @Log.Info.Around
    @Override
    <S extends T> S save(S entity);

    @Log.Debug.After
    @Override
    void flush();

    @Log.Info.Around
    @Override
    <S extends T> S saveAndFlush(S entity);

    @Log.Info.Around
    @Override
    <S extends T> List<S> saveAll(Iterable<S> entities);

    @Log.Info.Around
    @Override
    void deleteById(ID id);

    @Log.Info.Around
    @Override
    void delete(T entity);

    @Log.Info.Around
    @Override
    void deleteAll(Iterable<? extends T> entities);

    @Log.Info.Around
    @Override
    void deleteAll();

    @Log.Info.Around
    @Override
    void deleteInBatch(Iterable<T> entities);

    @Log.Info.Around
    @Override
    void deleteAllInBatch();

}