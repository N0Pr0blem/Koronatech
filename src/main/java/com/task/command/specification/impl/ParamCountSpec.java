package com.task.command.specification.impl;

import com.task.command.CommandContext;
import com.task.command.specification.CommandSpecification;

public class ParamCountSpec implements CommandSpecification {

    private final int count;

    public ParamCountSpec(int count) {
        this.count = count;
    }

    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return context.getParams().size()==count;
    }
}
