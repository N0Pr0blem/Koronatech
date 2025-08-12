package com.task.command;

import com.task.command.impl.SortCommand;
import com.task.command.impl.StatCommand;
import com.task.command.prefix.CommandPrefix;
import com.task.command.prefix.ParamPrefix;
import com.task.command.prefix.SubcommandPrefix;
import com.task.command.specification.CommandSpecification;
import com.task.command.specification.SortCommandSpecification;
import com.task.command.specification.StatCommandSpecification;
import com.task.output.printer.impl.FilePrinter;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CommandExecutor implements Command {

    private final List<CommandContext> contextList;

    private final Map<String, CommandSpecification> validators = Map.of(
            CommandPrefix.SORT.getTitle(), new SortCommandSpecification(),
            CommandPrefix.STAT.getTitle(), new StatCommandSpecification()
    );

    private final Map<String, Function<CommandContext, Command>> commandFactory = Map.of(
            CommandPrefix.SORT.getTitle(), this::createSortCommand,
            CommandPrefix.STAT.getTitle(), this::createStatCommand
    );

    public CommandExecutor(List<CommandContext> contextList) {
        this.contextList = contextList;
    }

    @Override
    public void execute() {
        contextList.forEach(this::execute);
    }

    public void execute(CommandContext context) {
        CommandSpecification specification = validators.get(context.getName());
        if (specification.isSatisfiedBy(context)) {
            Command command = commandFactory.getOrDefault(context.getName(), c -> {
                throw new IllegalArgumentException("No such command");
            }).apply(context);

            command.execute();
        } else {
            throw new IllegalArgumentException(specification.getErrorMessage());
        }
    }

    private Command createSortCommand(CommandContext commandContext) {
        String sortBy = commandContext.getValue();
        boolean ascending = commandContext.getParam(ParamPrefix.ORDER).equals("asc");
        return new SortCommand(sortBy, ascending);
    }

    private Command createStatCommand(CommandContext commandContext) {
        if (commandContext.getSubcommands().isEmpty()
                || commandContext.getSubcommand(SubcommandPrefix.OUTPUT).getParams().isEmpty()) {
            return new StatCommand();
        } else {
            return new StatCommand(
                    new FilePrinter(commandContext
                            .getSubcommand(SubcommandPrefix.OUTPUT)
                            .getParam(ParamPrefix.PATH)
                    )
            );
        }
    }

}
