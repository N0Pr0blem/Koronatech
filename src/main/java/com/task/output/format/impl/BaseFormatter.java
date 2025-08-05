package com.task.output.format.impl;

import com.task.config.MainData;
import com.task.output.format.Formatter;

public class BaseFormatter implements Formatter {
    StringBuilder result = new StringBuilder();

    @Override
    public String format() {
        MainData.getInstance().getManagers()
                .findAll()
                .forEach(m->{
                    result.append(m.getDepartmentName()).append(".sb\n").append(m.toString()).append("\n");
                    MainData.getInstance().getEmployees()
                            .findAll()
                            .stream()
                            .filter(e->e.getManagerId()==m.getId())
                            .forEach(e->result.append(e.toString()).append("\n"));
                });
        result.append("error.log\n");
        MainData.getInstance().getErrors()
                .findAll()
                .forEach(e->result.append(e).append("\n"));

        return result.toString();
    }
}
