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

    public Void adapt(Stream<String> inputData) {
        inputData.forEach(line->{
            try{
                if(line.trim().charAt(0)=='E' || line.trim().charAt(0)=='e'){
                    Employee employee = employeeParser.parse(line);
                    MainData.getInstance().
                            getEmployees().
                            save(employee);
                }
                else if(line.trim().charAt(0)=='M' || line.trim().charAt(0)=='m'){
                    Manager manager = managerParser.parse(line);
                    managerIds.add(manager.getId());
                    MainData.getInstance().
                            getManagers().
                            save(manager);
                }
                else {
                    throw new IllegalArgumentException("Wrong format for person: "+line);
                }
            }
            catch(IllegalArgumentException ex){
                MainData.getInstance()
                        .getErrors()
                        .save(line);
            }
        });

        return null;
    }

    public void validEmployees() {
        MainData.getInstance().getEmployees().findAll().removeIf(employee -> {
            if (!managerIds.contains(employee.getManagerId())) {
                MainData.getInstance().getErrors().save(employee.toString());
                return true;
            }
            return false;
        });
    }

}
