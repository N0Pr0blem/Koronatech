package com.task.output.printer.impl;

import com.task.output.printer.Printer;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String content) {
        System.out.println(content);
    }
}
