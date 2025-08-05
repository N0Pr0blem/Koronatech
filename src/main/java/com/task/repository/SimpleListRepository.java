package com.task.repository;

import java.util.List;

public interface SimpleListRepository<T> {
    List<T> findAll();

    void save(T t);


}
