package com.task.command.impl;

import com.task.command.Command;
import com.task.config.MainData;
import com.task.output.printer.Printer;

public class OutputCommand implements Command {

    private final Printer outputStatSource;

    public OutputCommand(Printer outputStatSource) {
        this.outputStatSource = outputStatSource;
    }

    @Override
    public void execute() {
        MainData.getInstance().setOutputStatSource(outputStatSource);
    }
}
