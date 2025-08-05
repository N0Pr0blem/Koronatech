package com.task.config;

import com.task.model.Employee;
import com.task.model.Manager;
import com.task.repository.SimpleListRepository;
import com.task.repository.impl.ListRepository;
import lombok.Getter;

@Getter
public class MainData {
    private static final MainData INSTANCE = new MainData();

    private final SimpleListRepository<Employee> employees = new ListRepository<>();
    private final SimpleListRepository<Manager> managers = new ListRepository<>();

    private static MainData getInstance() {
        return INSTANCE;
    }
}
