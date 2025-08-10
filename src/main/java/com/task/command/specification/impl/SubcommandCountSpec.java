package com.task.command.specification.impl;

import com.task.command.CommandContext;
import com.task.command.specification.CommandSpecification;

public class SubcommandCountSpec implements CommandSpecification {

    private final int count;

    public SubcommandCountSpec(int count) {
        this.count = count;
    }

    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return context.getSubcommands().size()==count;
    }
}
