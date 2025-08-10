package com.task.command.specification.impl;

import com.task.command.CommandContext;
import com.task.command.prefix.SubcommandPrefix;
import com.task.command.specification.CommandSpecification;

public class HasSubcommandSpec implements CommandSpecification {

    private final SubcommandPrefix subcommandPrefix;

    public HasSubcommandSpec(SubcommandPrefix subcommandPrefix) {
        this.subcommandPrefix = subcommandPrefix;
    }

    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return context.hasSubcommand(subcommandPrefix);
    }
}
