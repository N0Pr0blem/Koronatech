package com.task.adapter.impl;

import com.task.adapter.Adapter;
import com.task.config.MainData;
import com.task.model.Employee;
import com.task.model.Manager;
import com.task.parser.impl.EmployeeParser;
import com.task.parser.impl.ManagerParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputDataAdapter implements Adapter<Void,String> {
    private final EmployeeParser employeeParser = new EmployeeParser();
    private final ManagerParser managerParser = new ManagerParser();
    private final List<Integer> managerIds = new ArrayList<>();
    private final List<Integer> employeeIds = new ArrayList<>();

    public Void adapt(Stream<String> inputData) {
        inputData.forEach(line->{
            try{
                if(line.trim().charAt(0)=='E' || line.trim().charAt(0)=='e'){
                    Employee employee = employeeParser.parse(line);
                    if (employeeIds.contains(employee.getId())) {
                        throw new IllegalArgumentException("Duplicate employee ID: " + employee.getId());
                    }
                    employeeIds.add(employee.getId());
                    MainData.getInstance().
                            getEmployeeRepository().
                            save(employee);
                }
                else if(line.trim().charAt(0)=='M' || line.trim().charAt(0)=='m'){
                    Manager manager = managerParser.parse(line);
                    if (managerIds.contains(manager.getId())) {
                        throw new IllegalArgumentException("Duplicate manager ID: " + manager.getId());
                    }
                    managerIds.add(manager.getId());
                    MainData.getInstance().
                            getManagerRepository().
                            save(manager);
                }
                else {
                    throw new IllegalArgumentException("Wrong format for person: "+line);
                }
            }
            catch(IllegalArgumentException ex){
                MainData.getInstance()
                        .getErrorsRepository()
                        .save(line);
            }
        });

        return null;
    }

    public void validEmployees() {
        MainData.getInstance().getEmployeeRepository().findAll().removeIf(employee -> {
            if (!managerIds.contains(employee.getManagerId())) {
                MainData.getInstance().getErrorsRepository().save(employee.toString());
                return true;
            }
            return false;
        });
    }

}
