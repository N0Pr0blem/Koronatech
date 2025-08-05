package com.task.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
@AllArgsConstructor
public class Manager {
    private int id;
    private String name;
    private double salary;
    private String departmentName;

    @Override
    public String toString() {
        return String.format(Locale.US,"Manager,%d,%s,%.2f,%s",id,name,salary,departmentName);
    }
}
