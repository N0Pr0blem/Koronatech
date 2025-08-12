package com.task.parser.impl;

import com.task.model.Manager;
import com.task.parser.Parser;
import org.apache.commons.lang3.math.NumberUtils;

public class ManagerParser implements Parser<Manager,String> {

    private final int MANAGER_FIELD_COUNT = 4;
    private int id;
    private String name, departmentName;
    private double salary;

    @Override
    public Manager parse(String line) {
        String[] fields = line.trim().split(",");

        if (!fields[0].trim().equalsIgnoreCase("Manager") || fields.length != MANAGER_FIELD_COUNT + 1) {
            throw new IllegalArgumentException("Wrong format for Manager: " + line);
        }

        if (validFields(fields)) {
            return new Manager(id, name, salary, departmentName);
        } else {
            throw new IllegalArgumentException("Wrong data for Manager: " + line);
        }
    }

    private boolean validFields(String[] fields) {
        if (NumberUtils.isCreatable(fields[1].trim())
                && NumberUtils.isCreatable(fields[3].trim())
        ) {
            id = Integer.parseInt(fields[1].trim());
            name = fields[2].trim();
            salary = Double.parseDouble(fields[3].trim());
            departmentName = fields[4].trim();

            if(salary<=0){ return false;}
            
            return true;
        } else {
            return false;
        }
    }
}
