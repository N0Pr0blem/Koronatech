package com.task.command;

import com.task.command.prefix.ParamPrefix;
import com.task.command.prefix.SubcommandPrefix;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class CommandContext {
    private final String name;
    private String value;
    private final Map<ParamPrefix, String> params = new HashMap<>();
    private final Map<SubcommandPrefix, CommandContext> subcommands = new LinkedHashMap<>();

    public CommandContext(String name) {
        this.name = name;
    }
    public CommandContext(String name , String value) {
        this(name);
        this.value = value;
    }

    public void addSubcommand(SubcommandPrefix key, CommandContext value) {
        subcommands.put(key, value);
    }

    public void addParam(ParamPrefix key, String value) {
        params.put(key, value);
    }

    public String getParam(ParamPrefix key) {
        return params.get(key);
    }

    public boolean hasSubcommand(SubcommandPrefix subcommandPrefix) {
        return subcommands.containsKey(subcommandPrefix);
    }

    public boolean isCommand(String name) {
        return this.name.equals(name);
    }

    public boolean hasParam(ParamPrefix paramPrefix) {
        return params.containsKey(paramPrefix);
    }

    public CommandContext getSubcommand(SubcommandPrefix subcommandPrefix) {
        return subcommands.get(subcommandPrefix);
    }

    public CommandContext getLastSubcommand() {
        SubcommandPrefix lastKey = new ArrayList<>(subcommands.keySet()).get(subcommands.size() - 1);
        return getSubcommand(lastKey);
    }

    @Override
    public String toString() {
        return "CommandContext{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", params=" + params +
                ", subcommands=" + subcommands +
                '}';
    }
}
