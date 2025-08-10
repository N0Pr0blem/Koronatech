package com.task.command.specification.impl;

import com.task.command.CommandContext;
import com.task.command.prefix.SubcommandPrefix;
import com.task.command.specification.CommandSpecification;

public class SubcommandEqualsSpec implements CommandSpecification {
    private final SubcommandPrefix subcommandPrefix;
    private final String value;

    public SubcommandEqualsSpec(SubcommandPrefix subcommandPrefix, String value) {
        this.subcommandPrefix = subcommandPrefix;
        this.value=value;
    }

    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return context.getSubcommand(subcommandPrefix).getValue().equals(value);
    }
}
