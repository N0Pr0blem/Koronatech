package com.task.output;

import com.task.output.format.Formatter;
import com.task.output.printer.impl.ConsolePrinter;

public class ConsoleOutputManager{

    public void print(Formatter formatter) {
        new ConsolePrinter().print(formatter.format());
    }
}
