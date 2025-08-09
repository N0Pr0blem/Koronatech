package com.task.validator.impl;

import com.task.command.CommandContext;
import com.task.validator.Validator;

public class CommandValidator implements Validator<Boolean, CommandContext> {
    private CommandValidator commandValidator;

    @Override
    public Boolean validate(CommandContext commandContext) {
        if (commandContext.getCommand().equals("sort")) {
            if (commandContext.getArgs().size() != 2
                    || !commandContext.getArgs().containsKey("order")
                    || (!commandContext.getArg("sort").equals("name") && !commandContext.getArg("sort").equals("salary"))
                    || (!commandContext.getArg("order").equals("asc") && !commandContext.getArg("order").equals("desc"))
            ) {
                throw new IllegalArgumentException("Wrong sort command style\n - example: --sort/-s=name/salary --order=asc/desc");
            }

            return true;
        }
        if (commandContext.getCommand().equals("stat")) {
            if (commandContext.getArgs().size() != 1) {
                throw new IllegalArgumentException("Wrong stat command style\n - example: --stat");
            }
            return true;
        }
        if (commandContext.getCommand().equals("output")) {
            if (commandContext.getArgs().size() > 2
                    || (commandContext.getArgs().size() == 2 && (!commandContext.getArgs().containsKey("path") || !commandContext.getArg("output").equals("file")))
                    || (commandContext.getArgs().size() == 1 && !commandContext.getArg("output").equals("console"))
            ) {
                throw new IllegalArgumentException("Wrong output command style\n - example: --output/-o=console/file (--path={path} #for file input)");
            }

            return true;
        }
        throw new IllegalArgumentException("No such command");
    }
}
