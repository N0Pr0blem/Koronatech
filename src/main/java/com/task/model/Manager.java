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
        String salary_str = String.format(Locale.US,"%.2f",salary);
        salary_str = salary_str.replace(".00","");
        return String.format("Manager,%d,%s,%s",id,name,salary_str);
    }
}
