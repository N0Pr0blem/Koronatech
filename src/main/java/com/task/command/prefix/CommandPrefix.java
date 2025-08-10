package com.task.command.prefix;

import com.task.command.prefix.base.PrefixType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public enum CommandPrefix {

    SORT("sort",List.of("--sort", "-s")),
    STAT("stat",List.of("--stat")),
    NOT_COMMAND(null, Collections.emptyList());

    final java.lang.String title;
    final List<java.lang.String> prefixes;

    final PrefixType type = PrefixType.COMMAND;

    public static CommandPrefix fromString(String line) {
        for(CommandPrefix word : values()){
            if(!word.prefixes.isEmpty()){
                for(java.lang.String prefix : word.prefixes){
                    if(line.startsWith(prefix)) return word;
                }
            }

        }
        return NOT_COMMAND;
    }
}
