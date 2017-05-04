package com.master.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by Mr.Cheng on 2017/4/25 0025.
 */
public interface ICommonService<T> {
    T save(T entity) throws Exception;
    void delete(Long id) throws Exception;
    void delete(T entity) throws Exception;
    T findById(Long id);
    T findBySample(T sample);
 //   T findBySamples(String username,String password);
    List<T> findAll();
    List<T> findAll(T sample);
    Page<T> findAll(PageRequest pageRequest);
    Page<T> findAll(T sample,PageRequest pageRequest);
}
