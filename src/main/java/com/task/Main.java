package com.task;

import com.task.command.CommandContext;
import com.task.command.CommandExecutor;
import com.task.input.impl.FileInputManager;
import com.task.output.format.impl.BaseFormatter;
import com.task.output.manager.OutputManager;
import com.task.output.manager.impl.FileOutputManager;
import com.task.parser.impl.CommandParser;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            FileInputManager fileInputManager = new FileInputManager();
            OutputManager outputManager = new FileOutputManager();
            fileInputManager.readData();
            List<CommandContext> commands = new CommandParser().parse(args);
            CommandExecutor commandExecutor = new CommandExecutor(commands);
            commandExecutor.execute();
            outputManager.print(new BaseFormatter());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
