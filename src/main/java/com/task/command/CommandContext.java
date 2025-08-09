package com.task.command;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class CommandContext {
    private final String command;
    private final Map<String, String> args = new HashMap<>();
    private List<CommandContext> subcommands = new ArrayList<>();

    public CommandContext(String command) {
        this.command = command;
    }

    public void addArgs(String key, String value) {
        args.put(key, value);
    }

    public String getArg(String key) {
        return args.get(key);
    }

    public void addSubcommand(CommandContext commandContext){
        subcommands.add(commandContext);
    }
}
