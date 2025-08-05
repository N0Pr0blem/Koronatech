package com.task.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private double salary;
    private int managerId;

    @Override
    public String toString() {
        return String.format(Locale.US,"Employee,%d,%s,%.2f,%d",id,name,salary,managerId);
    }
}
