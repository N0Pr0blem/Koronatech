package com.task.command.specification.impl;

import com.task.command.CommandContext;
import com.task.command.prefix.CommandPrefix;
import com.task.command.specification.CommandSpecification;

public class IsCommandSpec implements CommandSpecification {

    private final CommandPrefix commandPrefix;

    public IsCommandSpec(CommandPrefix commandPrefix) {
        this.commandPrefix = commandPrefix;
    }

    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return context.isCommand(commandPrefix.getTitle());
    }
}
