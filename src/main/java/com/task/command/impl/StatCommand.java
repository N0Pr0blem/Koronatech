package com.task.command.impl;

import com.task.command.Command;
import com.task.config.MainData;
import com.task.model.Employee;
import com.task.model.Manager;
import com.task.output.printer.Printer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class StatCommand implements Command {
    public StatCommand(Printer printer) {
        new OutputCommand(printer).execute();
    }

    public StatCommand() {
    }

    @Override
    public void execute() {
        StringBuilder res = new StringBuilder();

        res.append("department, min, max, mid\n");
        MainData.getInstance().getManagerRepository().findAll().sort(Comparator.comparing(Manager::getDepartmentName));
        for (Manager manager : MainData.getInstance().getManagerRepository().findAll()) {
            List<Employee> employees = new ArrayList<>(
                    MainData.getInstance().getEmployeeRepository().findAllByManagerId(manager.getId())
            );
            if (employees.isEmpty()) {
                res.append(manager.getDepartmentName()).append(",0.00,0.00,0.00\n");
            } else {
                employees.sort(Comparator.comparing(Employee::getSalary));
                res.append(manager.getDepartmentName())
                        .append(String.format(Locale.US, ",%.2f,%.2f,%.2f\n", getMin(employees), getMax(employees), getMid(employees)));
            }
        }

        MainData.getInstance().getOutputStatSource().print(res.toString());
    }

    private double getMax(List<Employee> employees) {
        return employees.get(employees.size() - 1).getSalary();
    }

    private double getMin(List<Employee> employees) {
        return employees.get(0).getSalary();
    }

    private double getMid(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }
}
