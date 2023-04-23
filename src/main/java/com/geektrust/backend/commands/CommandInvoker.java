package com.geektrust.backend.commands;

import com.geektrust.backend.exceptions.CommandNotFoundException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.geektrust.backend.constants.Constants.ZERO;


public class CommandInvoker {

    private static final Map<String, ICommand> commandMap = new HashMap<>();

    public void registerCommand(String commandKeyword, ICommand command) {
        commandMap.put(commandKeyword, command);
    }

    private ICommand get(String commandName) {
        return commandMap.get(commandName);
    }

    public List<String> parse(String input) {
        return Arrays.asList(input.split(" "));
    }

    public void invokeCommand(String input) {
        List<String> tokens = parse(input);
        ICommand command = get(tokens.get(ZERO));
        if (command == null) {
            throw new CommandNotFoundException("Invalid command!");
        }
        command.execute(tokens);
    }
}
