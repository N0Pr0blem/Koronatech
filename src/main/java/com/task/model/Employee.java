package com.task.model;

import com.task.config.MainData;
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
        return String.format("Employee,%d,%s,%s,%d",id,name, MainData.getInstance().getDecimalFormat().format(salary),managerId);
    }
}
