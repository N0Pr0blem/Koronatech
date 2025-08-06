package com.task;

import com.task.command.CommandContext;
import com.task.input.impl.FileInputManager;
import com.task.output.manager.OutputManager;
import com.task.output.manager.impl.FileOutputManager;
import com.task.output.format.impl.BaseFormatter;
import com.task.parser.impl.CommandParser;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<CommandContext> commands = new CommandParser().parse(args);
        commands.forEach(commandContext -> System.out.println(commandContext.getArgs().toString()));
//        FileInputManager fileInputManager = new FileInputManager();
//        OutputManager outputManager = new FileOutputManager();
//        fileInputManager.readData();
//        outputManager.print(new BaseFormatter());
    }
}
