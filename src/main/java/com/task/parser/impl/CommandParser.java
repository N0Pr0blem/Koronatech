package com.task.parser.impl;

import com.task.command.CommandContext;
import com.task.command.CommandWord;
import com.task.parser.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser implements Parser<List<CommandContext>,String[]> {
    @Override
    public List<CommandContext> parse(String[] args) {
        List<CommandContext> result = new ArrayList<>();
        List<String> commandLines = Arrays.stream(args).toList();

        commandLines.forEach(line->{
            CommandWord word = CommandWord.fromString(line);
            if(word.getWordType().equals(CommandWord.CommandWordType.PARAM)){
                if(!result.isEmpty()){
                    String[] parts = line.split("=");
                    result.get(result.size()-1).addArgs(word.name().toLowerCase(),parts[1]);
                }
                else{
                    throw new IllegalArgumentException("Wrong command line format");
                }
            }
            else if(word.getWordType().equals(CommandWord.CommandWordType.COMMAND)){
                CommandContext commandContext = new CommandContext(word.name().toLowerCase());
                if(line.contains("=")){
                    String[] parts = line.split("=");
                    commandContext.addArgs(word.name().toLowerCase(),parts[1]);
                }
                else {
                    commandContext.addArgs(word.name().toLowerCase(), word.name().toLowerCase());
                }
                result.add(commandContext);
            }
        });

        return result;
    }
}
