package com.task.model;


import com.task.config.MainData;
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
        return String.format("Manager,%d,%s,%s",id,name, MainData.getInstance().getDecimalFormat().format(salary));
    }
}
