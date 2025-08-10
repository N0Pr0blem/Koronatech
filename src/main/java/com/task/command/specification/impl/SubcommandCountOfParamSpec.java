package com.task.command.specification.impl;

import com.task.command.CommandContext;
import com.task.command.prefix.SubcommandPrefix;
import com.task.command.specification.CommandSpecification;

public class SubcommandCountOfParamSpec implements CommandSpecification {

    private final SubcommandPrefix subcommandPrefix;
    private final int count;

    public SubcommandCountOfParamSpec(SubcommandPrefix subcommandPrefix, int count) {
        this.subcommandPrefix = subcommandPrefix;
        this.count = count;
    }

    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return context.getSubcommand(subcommandPrefix).getParams().size()==count;
    }
}
