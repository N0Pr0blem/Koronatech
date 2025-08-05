package com.task.repository.impl;

import com.task.repository.SimpleListRepository;

import java.util.ArrayList;
import java.util.List;

public class ListRepository<T> implements SimpleListRepository<T> {

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
}
