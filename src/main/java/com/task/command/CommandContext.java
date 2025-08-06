package com.task.command;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CommandContext {
    private final String command;
    private final Map<String, String> args = new HashMap<>();

    public CommandContext(String command) {
        this.command = command;
    }

    public void addArgs(String key, String value) {
        args.put(key, value);
    }

    public String getArg(String key) {
        return args.get(key);
    }
}
