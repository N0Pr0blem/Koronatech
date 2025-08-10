package com.task.command.specification.impl;

import com.task.command.CommandContext;
import com.task.command.prefix.ParamPrefix;
import com.task.command.prefix.SubcommandPrefix;
import com.task.command.specification.CommandSpecification;

public class SubcommandHasParamSpec implements CommandSpecification {

    private final SubcommandPrefix subcommandPrefix;
    private final ParamPrefix paramPrefix;

    public SubcommandHasParamSpec(SubcommandPrefix subcommandPrefix, ParamPrefix paramPrefix) {
        this.subcommandPrefix = subcommandPrefix;
        this.paramPrefix = paramPrefix;
    }

    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return context.getSubcommand(subcommandPrefix).hasParam(paramPrefix);
    }
}
