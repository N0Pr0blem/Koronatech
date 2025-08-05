package com.task.config;

import com.task.model.Employee;
import com.task.model.Manager;
import com.task.repository.SimpleRepository;
import com.task.repository.impl.ListRepository;
import lombok.Getter;

@Getter
public class MainData {
    private static final MainData INSTANCE = new MainData();

    private final SimpleRepository<Employee> employees = new ListRepository<>();
    private final SimpleRepository<Manager> managers = new ListRepository<>();
    private final SimpleRepository<String> errors = new ListRepository<>();

    public static MainData getInstance() {
        return INSTANCE;
    }
}
