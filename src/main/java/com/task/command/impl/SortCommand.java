package com.task.command.impl;

import com.task.command.Command;
import com.task.config.MainData;
import com.task.model.Employee;

import java.util.Comparator;
import java.util.Map;

public class SortCommand implements Command {

    private final String sortBy;
    private final boolean ascending;

    private static final Map<String, Comparator<Employee>> COMPARATORS = Map.of(
            "name", Comparator.comparing(Employee::getName),
            "salary", Comparator.comparingDouble(Employee::getSalary)
    );

    public SortCommand(String sortBy, boolean ascending) {
        this.sortBy = sortBy;
        this.ascending = ascending;
    }

    @Override
    public void execute() {
        if (sortBy!=null) {
            Comparator<Employee> comparator = COMPARATORS.getOrDefault(sortBy.toLowerCase(), null);

            if (comparator == null) {
                throw new IllegalArgumentException("Wrong field name");
            }
            if (!ascending) {
                comparator = comparator.reversed();
            }

            MainData.getInstance().getEmployeeRepository().sort(comparator);
        }
    }
}
