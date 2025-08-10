package com.task.command.specification.impl;

import com.task.command.CommandContext;
import com.task.command.specification.CommandSpecification;

public class CommandEqualsSpec implements CommandSpecification {

    private final String value;

    public CommandEqualsSpec(String value) {
        this.value = value;
    }

    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return context.getValue().equals(value);
    }
}
