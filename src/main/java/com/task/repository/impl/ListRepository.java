package com.task.repository.impl;

import com.task.repository.SimpleRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListRepository<T> implements SimpleRepository<T> {

    private final List<T> objects;

    public ListRepository() {
        objects = new ArrayList<>();;
    }

    @Override
    public List<T> findAll() {
        return objects;
    }

    @Override
    public void save(T t) {
        objects.add(t);
    }

    @Override
    public void sort(Comparator<T> comparator) {
        objects.sort(comparator);
    }
}
