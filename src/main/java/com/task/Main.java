package com.task;

import com.task.config.MainData;
import com.task.input.impl.FileInputManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputManager fileInputManager = new FileInputManager();
        fileInputManager.readData();
        System.out.println("--- Employees ---");
        MainData.getInstance().getEmployees().findAll().forEach(System.out::println);
        System.out.println("--- Managers ---");
        MainData.getInstance().getManagers().findAll().forEach(System.out::println);
        System.out.println("--- Errors ---");
        MainData.getInstance().getErrors().findAll().forEach(System.out::println);
    }
}
