package com.task.command.specification;

import com.task.command.CommandContext;

public interface CommandSpecification {
    boolean isSatisfiedBy(CommandContext context);

    default CommandSpecification and(CommandSpecification other) {
        return context -> this.isSatisfiedBy(context) && other.isSatisfiedBy(context);
    }

    default CommandSpecification or(CommandSpecification other) {
        return context -> this.isSatisfiedBy(context) || other.isSatisfiedBy(context);
    }

    default CommandSpecification not(CommandSpecification other) {
        return context -> this.isSatisfiedBy(context) && !other.isSatisfiedBy(context);
    }

    default String getErrorMessage() {
        return "Invalid data...";
    }

}
