package com.task.output.format.impl;

import com.task.config.MainData;
import com.task.model.Manager;
import com.task.output.format.Formatter;

public class BaseFormatter implements Formatter {

    @Override
    public String format() {
        StringBuilder result = new StringBuilder();
        MainData.getInstance().getManagerRepository()
                .findAll()
                .forEach(manager->{
                    result.append(manager.getDepartmentName()).append(".sb\n");
                    result.append(format(manager));
                });
        result.append("error.log\n");
        result.append(formatErrors());

        return result.toString();
    }

    @Override
    public String formatErrors() {
        StringBuilder result = new StringBuilder();
        MainData.getInstance().getErrorsRepository()
                .findAll()
                .forEach(e->result.append(e).append("\n"));
        return result.toString();
    }

    @Override
    public String format(Manager manager) {
        StringBuilder result = new StringBuilder();
        result.append(manager.toString()).append("\n");
        MainData.getInstance().getEmployeeRepository()
                .findAllByManagerId(manager.getId())
                .forEach(e->result.append(e.toString()).append("\n"));

        return result.toString();
    }
}
