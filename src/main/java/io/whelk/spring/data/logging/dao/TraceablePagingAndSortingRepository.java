package io.whelk.spring.data.logging.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import io.whelk.spring.data.logging.aop.Log;

@NoRepositoryBean
public interface TraceablePagingAndSortingRepository<T, ID> 
         extends PagingAndSortingRepository<T, ID>,
                 TraceableCrudRepository<T, ID> {

    @Log.Trace.Around
    @Override
	Iterable<T> findAll(Sort sort);

    @Log.Trace.Around
    @Override
    Page<T> findAll(Pageable pageable);

}