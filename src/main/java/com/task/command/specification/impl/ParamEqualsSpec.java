package com.task.command.specification.impl;

import com.task.command.CommandContext;
import com.task.command.prefix.ParamPrefix;
import com.task.command.specification.CommandSpecification;

public class ParamEqualsSpec implements CommandSpecification {

    private final ParamPrefix paramPrefix;
    private final String value;

    public ParamEqualsSpec(ParamPrefix paramPrefix, String value) {
        this.paramPrefix = paramPrefix;
        this.value = value;
    }

    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return context.getParam(paramPrefix).equals(value);
    }
}
