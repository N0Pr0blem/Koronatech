package com.task.command.prefix;

import com.task.command.prefix.base.ParamType;
import com.task.command.prefix.base.PrefixType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ParamPrefix {
    PATH(List.of("--path"),ParamType.SUBCOMMAND),
    ORDER(List.of("--order"),ParamType.COMMAND),
    NOT_PARAM(Collections.emptyList(),null);

    final List<String> prefixes;
    final ParamType paramOf;

    final PrefixType type = PrefixType.PARAM;

    public static ParamPrefix fromString(String line) {
        for(ParamPrefix word : values()){
            if(!word.prefixes.isEmpty()){
                for(String prefix : word.prefixes){
                    if(line.startsWith(prefix)) return word;
                }
            }

        }
        return NOT_PARAM;
    }
}
