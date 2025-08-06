package com.task.config;

import com.task.model.Manager;
import com.task.output.manager.OutputManager;
import com.task.output.manager.impl.FileOutputManager;
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
    OutputManager outputManager = new FileOutputManager();

    public static MainData getInstance() {
        return INSTANCE;
    }
}
