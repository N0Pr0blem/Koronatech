package com.task.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum CommandWord {

    ORDER(List.of("--order"), CommandWordType.PARAM),
    SORT(List.of("--sort", "-s"), CommandWordType.COMMAND),

    PATH(List.of("--path"), CommandWordType.PARAM),
    OUTPUT(List.of("--output", "-o"), CommandWordType.SUBCOMMAND),
    STAT(List.of("--stat"), CommandWordType.COMMAND);

    public enum CommandWordType {
        COMMAND,SUBCOMMAND, PARAM;
    }

    final List<String> prefixes;
    final CommandWordType wordType;

    public static CommandWord fromString(String line) {
        for(CommandWord word : values()){
            for(String prefix : word.prefixes){
                if(line.startsWith(prefix)) return word;
            }
        }
        throw new IllegalArgumentException("Wrong command format");
    }
}
