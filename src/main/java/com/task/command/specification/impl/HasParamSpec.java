package com.task.command.specification.impl;

import com.task.command.CommandContext;
import com.task.command.prefix.ParamPrefix;
import com.task.command.specification.CommandSpecification;

public class HasParamSpec implements CommandSpecification {

    private final ParamPrefix paramPrefix;

    public HasParamSpec(ParamPrefix paramPrefix) {
        this.paramPrefix = paramPrefix;
    }

    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return context.hasParam(paramPrefix);
    }
}
