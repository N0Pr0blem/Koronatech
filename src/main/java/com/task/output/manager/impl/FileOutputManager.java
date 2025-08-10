package com.task.output.manager.impl;

import com.task.config.MainData;
import com.task.output.format.Formatter;
import com.task.output.manager.OutputManager;
import com.task.output.printer.impl.FilePrinter;

public class FileOutputManager implements OutputManager {
    private final String OUTPUT_DIRECTORY = "output/";

    @Override
    public void print(Formatter formatter) {
        MainData.getInstance().getManagerRepository()
                .findAll()
                .forEach(m -> {
                    new FilePrinter(OUTPUT_DIRECTORY + m.getDepartmentName() + ".sb").print(formatter.format(m));
                });
        new FilePrinter(OUTPUT_DIRECTORY + "error.log").print(formatter.formatErrors());
    }
}
