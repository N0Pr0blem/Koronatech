package com.task.repository;

import com.task.model.Employee;

import java.util.Comparator;
import java.util.List;

public interface SimpleRepository<T> {
    List<T> findAll();

    void save(T t);

    void sort(Comparator<T> comparator);

}
