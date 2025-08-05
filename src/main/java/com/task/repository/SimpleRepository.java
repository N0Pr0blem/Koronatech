package com.task.repository;

import java.util.List;

public interface SimpleRepository<T> {
    List<T> findAll();

    void save(T t);


}
