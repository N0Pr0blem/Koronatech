package com.task.command.specification;

import com.task.command.CommandContext;
import com.task.command.prefix.CommandPrefix;
import com.task.command.prefix.ParamPrefix;
import com.task.command.specification.impl.*;

public class SortCommandSpecification implements CommandSpecification{

    private final CommandSpecification isSortCommand = new IsCommandSpec(CommandPrefix.SORT);
    private final CommandSpecification isValueEmpty = new CommandValueIsEmptySpec();
    private final CommandSpecification paramCount = new ParamCountSpec(1);
    private final CommandSpecification subcommandCount = new SubcommandCountSpec(0);
    private final CommandSpecification hasParamOrder = new HasParamSpec(ParamPrefix.ORDER);
    private final CommandSpecification paramOrderEqualsAsc = new ParamEqualsSpec(ParamPrefix.ORDER,"asc");
    private final CommandSpecification paramOrderEqualsDesc = new ParamEqualsSpec(ParamPrefix.ORDER,"desc");
    private final CommandSpecification sortEqualsName = new CommandEqualsSpec("name");
    private final CommandSpecification sortEqualsSalary = new CommandEqualsSpec("salary");

    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return isSortCommand
                .not(isValueEmpty)
                .and(paramCount)
                .and(subcommandCount)
                .and(hasParamOrder)
                .and((paramOrderEqualsAsc.or(paramOrderEqualsDesc)))
                .and((sortEqualsName.or(sortEqualsSalary)))
                .isSatisfiedBy(context);
    }

    @Override
    public java.lang.String getErrorMessage() {
        return "Invalid sort command. Correct format: --sort|-s=name|salary --order=asc|desc";
    }
}
