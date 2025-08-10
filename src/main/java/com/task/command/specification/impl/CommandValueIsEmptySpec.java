package com.task.command.specification.impl;

import com.task.command.CommandContext;
import com.task.command.specification.CommandSpecification;

public class CommandValueIsEmptySpec implements CommandSpecification {
    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return context.getValue()==null||context.getValue().isEmpty();
    }
}
