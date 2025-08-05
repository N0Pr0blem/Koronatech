package com.task.model;

public class Manager {
    private int id;
    private String name;
    private double salary;
    private String departmentName;

    @Override
    public String toString() {
        return String.format("Manager,%d,%s,%.2f,%s",id,name,salary,departmentName);
    }
}
