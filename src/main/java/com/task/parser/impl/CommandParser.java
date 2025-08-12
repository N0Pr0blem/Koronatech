package com.task.parser.impl;

import com.task.command.CommandContext;
import com.task.command.prefix.CommandPrefix;
import com.task.command.prefix.ParamPrefix;
import com.task.command.prefix.SubcommandPrefix;
import com.task.command.prefix.base.ParamType;
import com.task.parser.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser implements Parser<List<CommandContext>, String[]> {
    @Override
    public List<CommandContext> parse(String[] args) {
        List<CommandContext> result = new ArrayList<>();
        List<String> commandLines = Arrays.stream(args).toList();

        commandLines.forEach(line->{
            CommandContext commandContext;
            CommandPrefix commandPrefix = CommandPrefix.fromString(line);

            if(!commandPrefix.equals(CommandPrefix.NOT_COMMAND)){
                commandContext = new CommandContext(commandPrefix.getTitle(), getValueFromString(line));
                result.add(commandContext);
            }
            else if(!result.isEmpty()){
                SubcommandPrefix subcommandPrefix = SubcommandPrefix.fromString(line);
                ParamPrefix paramPrefix = ParamPrefix.fromString(line);

                if(!subcommandPrefix.equals(SubcommandPrefix.NOT_SUBCOMMAND)){
                    result.get(result.size()-1)
                            .addSubcommand(subcommandPrefix,new CommandContext(subcommandPrefix.name(), getValueFromString(line)));
                }
                else if(!paramPrefix.equals(ParamPrefix.NOT_PARAM)){
                    if(paramPrefix.getParamOf().equals(ParamType.COMMAND)){
                        result.get(result.size()-1)
                                .addParam(paramPrefix,getValueFromString(line));
                    }
                    else if(paramPrefix.getParamOf().equals(ParamType.SUBCOMMAND)){
                        commandContext = result.get(result.size()-1);
                        CommandContext subcommandContext = commandContext.getLastSubcommand();
                        subcommandContext.addParam(paramPrefix, getValueFromString(line));
                    }
                }
                else{
                    throw new IllegalArgumentException("Unknown command, subcommand or parameter: "+line);
                }
            }
            else{
                throw new IllegalArgumentException("Incorrect command line format.Argument is not a command: "+line);
            }

        });

        return result;
    }

    public String getValueFromString(String line){
        String value = "";
        if(line.contains("=")){
            String[] args = line.trim().split("=",2);
            if(args.length==2) {
                value = args[1];
            }
        }
         return value;
    }

}
