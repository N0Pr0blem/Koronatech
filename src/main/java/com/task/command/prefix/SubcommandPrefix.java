package com.task.command.prefix;

import com.task.command.prefix.base.PrefixType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public enum SubcommandPrefix {
    OUTPUT(List.of("--output", "-o")),
    NOT_SUBCOMMAND(Collections.emptyList());

    final List<String> prefixes;

    final PrefixType type = PrefixType.SUBCOMMAND;

    public static SubcommandPrefix fromString(String line) {
        for(SubcommandPrefix word : values()){
            if(!word.prefixes.isEmpty()){
                for(String prefix : word.prefixes){
                    if(line.startsWith(prefix)) return word;
                }
            }

        }
        return NOT_SUBCOMMAND;
    }
}
