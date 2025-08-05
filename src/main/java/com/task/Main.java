package com.task;

import com.task.input.impl.FileInputManager;
import com.task.output.ConsoleOutputManager;
import com.task.output.format.impl.BaseFormatter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputManager fileInputManager = new FileInputManager();
        ConsoleOutputManager consoleOutputManager = new ConsoleOutputManager();
        fileInputManager.readData();
        consoleOutputManager.print(new BaseFormatter());
    }
}
