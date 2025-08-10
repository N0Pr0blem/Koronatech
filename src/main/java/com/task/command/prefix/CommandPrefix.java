package com.task.command.prefix;

import com.task.command.prefix.base.PrefixType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public enum CommandPrefix {
    SORT("sort", List.of("--sort=", "-s="), true),
    STAT("stat", List.of("--stat"), false),
    NOT_COMMAND(null, Collections.emptyList(), false);

    private final String title;
    private final List<String> prefixes;
    private final boolean requiresValue;

    public static CommandPrefix fromString(String line) {
        line = line.trim();
        for (CommandPrefix cmd : values()) {
            for (String prefix : cmd.prefixes) {
                if (cmd.requiresValue) {
                    if (line.startsWith(prefix)) return cmd;
                } else {
                    if (
                            line.equals(prefix) || (line.startsWith(prefix)
                            && (line.length() == prefix.length() || Character.isWhitespace(line.charAt(prefix.length()))))
                    ) {
                        return cmd;
                    }
                }
            }
        }
        return NOT_COMMAND;
    }
}
