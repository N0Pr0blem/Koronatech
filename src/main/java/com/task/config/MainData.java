package com.task.config;

import com.task.model.Manager;
import com.task.repository.SimpleRepository;
import com.task.repository.impl.EmployeeListRepository;
import com.task.repository.impl.ListRepository;
import lombok.Getter;

@Getter
public class MainData {
    private static final MainData INSTANCE = new MainData();

    private final EmployeeListRepository employeeRepository = new EmployeeListRepository();
    private final SimpleRepository<Manager> managerRepository = new ListRepository<>();
    private final SimpleRepository<String> errorsRepository = new ListRepository<>();

    public static MainData getInstance() {
        return INSTANCE;
    }
}
