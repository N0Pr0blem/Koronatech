package com.task.command.specification;

import com.task.command.CommandContext;
import com.task.command.prefix.CommandPrefix;
import com.task.command.prefix.ParamPrefix;
import com.task.command.prefix.SubcommandPrefix;
import com.task.command.specification.impl.*;

public class StatCommandSpecification implements CommandSpecification {
    private final CommandSpecification isStatCommand = new IsCommandSpec(CommandPrefix.STAT);
    private final CommandSpecification isValueEmpty = new CommandValueIsEmptySpec();
    private final CommandSpecification withoutParam = new ParamCountSpec(0);
    private final CommandSpecification subcommandCount1 = new SubcommandCountSpec(1);
    private final CommandSpecification subcommandCount0 = new SubcommandCountSpec(0);
    private final CommandSpecification hasOutput = new HasSubcommandSpec(SubcommandPrefix.OUTPUT);
    private final CommandSpecification outputIsConsole = new SubcommandEqualsSpec(SubcommandPrefix.OUTPUT, "console");
    private final CommandSpecification outputIsFile = new SubcommandEqualsSpec(SubcommandPrefix.OUTPUT, "file");
    private final CommandSpecification outputParam0 = new SubcommandCountOfParamSpec(SubcommandPrefix.OUTPUT, 0);
    private final CommandSpecification outputParam1 = new SubcommandCountOfParamSpec(SubcommandPrefix.OUTPUT, 1);
    private final CommandSpecification outputHasPath = new SubcommandHasParamSpec(SubcommandPrefix.OUTPUT, ParamPrefix.PATH);

    private final CommandSpecification isEmptyStatCommand = subcommandCount0;

    private final CommandSpecification isStatCommandWithConsoleOutput = subcommandCount1
            .and(hasOutput)
            .and(outputIsConsole)
            .and(outputParam0);

    private final CommandSpecification isStatCommandWithFileOutput = subcommandCount1
            .and(hasOutput)
            .and(outputIsFile)
            .and(outputParam1)
            .and(outputHasPath);


    @Override
    public boolean isSatisfiedBy(CommandContext context) {
        return isStatCommand
                .and(isValueEmpty)
                .and(withoutParam)
                .and(isEmptyStatCommand.or(isStatCommandWithConsoleOutput).or(isStatCommandWithFileOutput))
                .isSatisfiedBy(context);
    }

    @Override
    public java.lang.String getErrorMessage() {
        return "Invalid stat command. Correct format: --stat --output=console|file( --path={path}) ";
    }
}
