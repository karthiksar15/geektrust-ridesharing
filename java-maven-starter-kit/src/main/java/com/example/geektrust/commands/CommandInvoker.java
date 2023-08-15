package com.example.geektrust.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandInvoker {

    private static final Map<String, ICommand> commandMap = new HashMap<>();

    public void register(String commandName, ICommand command) {
        commandMap.put(commandName, command);
    }

    public ICommand getCommand(String commandName) {
        return commandMap.get(commandName);
    }

    public void executeCommand(String commandName, List<String> tokens) {
        ICommand command = commandMap.get(commandName);
        try {
            command.execute(tokens);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
