package com.task.command;

import com.task.command.impl.OutputCommand;
import com.task.command.impl.SortCommand;
import com.task.command.impl.StatCommand;
import com.task.output.printer.impl.ConsolePrinter;
import com.task.output.printer.impl.FilePrinter;
import com.task.validator.impl.CommandValidator;

import java.util.List;

public class CommandExecutor implements Command{

    private final List<CommandContext> contextList;
    private final CommandValidator commandValidator;

    public CommandExecutor(List<CommandContext> contextList) {
        this.contextList = contextList;
        commandValidator = new CommandValidator();
    }

    @Override
    public void execute() {
        contextList.forEach(commandContext -> {
            try{
                if(commandValidator.validate(commandContext)){
                    execute(commandContext);
                }
            }
            catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        });
    }

    private void execute(CommandContext commandContext) {
        switch(commandContext.getCommand()){
            case "sort"->{
                new SortCommand(
                        commandContext.getArg("sort"),
                        !commandContext.getArg("order").equalsIgnoreCase("asc")
                ).execute();
            }
            case "stat"->{
                if(commandContext.getSubcommands().isEmpty()){
                    new StatCommand().execute();
                }
                else{
                    if(commandContext.getSubcommands().get(0).getArgs().size()==2) {
                        new StatCommand(new FilePrinter(commandContext.getArg("path"))).execute();
                    }
                    else {
                        new StatCommand(new ConsolePrinter()).execute();
                    }
                }
            }
        }
    }
}
