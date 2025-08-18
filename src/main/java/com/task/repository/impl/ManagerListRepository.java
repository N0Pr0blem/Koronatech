package com.task.repository.impl;

import com.task.model.Manager;

public class ManagerListRepository extends ListRepository<Manager> {
    public Manager findById(int managerId) {
        return findAll().stream()
                .filter(m -> m.getId() == managerId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such manager with id: " + managerId));
    }
}
