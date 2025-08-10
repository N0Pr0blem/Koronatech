package com.task.output.manager.impl;

import com.task.output.format.Formatter;
import com.task.output.manager.OutputManager;
import com.task.output.printer.impl.ConsolePrinter;

public class ConsoleOutputManager implements OutputManager {

    @Override
    public void print(Formatter formatter) {
        new ConsolePrinter().print(formatter.format());
    }
}
