package com.task.repository.impl;

import com.task.model.Employee;

import java.util.List;

public class EmployeeListRepository extends ListRepository<Employee>{
    public List<Employee> findAllByManagerId(int managerId){
        return findAll().stream()
                .filter(e->e.getManagerId()==managerId)
                .toList();
    }
}
