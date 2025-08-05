package com.task.model;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private int managerId;

    @Override
    public String toString() {
        return String.format("Manager,%d,%s,%.2f,%d",id,name,salary,managerId);
    }
}
