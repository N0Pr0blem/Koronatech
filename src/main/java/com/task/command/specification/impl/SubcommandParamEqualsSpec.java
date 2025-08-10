package com.task.command.specification.impl;

import com.task.command.CommandContext;
import com.task.command.prefix.ParamPrefix;
import com.task.command.prefix.SubcommandPrefix;
import com.task.command.specification.CommandSpecification;

public class SubcommandParamEqualsSpec implements CommandSpecification {
    private final SubcommandPrefix subcommandPrefix;
    private final ParamPrefix paramPrefix;
    private final String value;

    public SubcommandParamEqualsSpec(SubcommandPrefix subcommandPrefix, ParamPrefix paramPrefix, String value) {
        this.subcommandPrefix = subcommandPrefix;
        this.paramPrefix = paramPrefix;
        this.value = value;
    }

    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return context.getSubcommand(subcommandPrefix).getParam(paramPrefix).equals(value);
    }
}
