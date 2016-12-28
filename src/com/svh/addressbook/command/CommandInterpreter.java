package com.svh.addressbook.command;

import com.svh.addressbook.application.Application;
import com.svh.addressbook.console.Console;
import com.svh.addressbook.exception.InvalidCommandException;

/**
 * Created by SVh on 12/27/2016.
 */
public class CommandInterpreter {

    private Application application;

    public CommandInterpreter(Application app) {
        this.application = app;
    }

    public Command interpret(CommandLine cmdLine) {
        String command = cmdLine.getCommand();
        switch (command) {
            case "add":
                return new AddContactCommand(this.application, new Console(), cmdLine.getParameters());
            case "delete":
                return new DeleteContactCommand(this.application, new Console(), cmdLine.getParameters());
            case "list":
                return new ListCommand(this.application, new Console());
            case "search":
                return new SearchCommand(this.application, new Console(), cmdLine.getParameters());
            case "help":
                return new HelpCommand(new Console());
            case "quit":
                return new QuitCommand(this.application, new Console());
            default:
                throw new InvalidCommandException("Invalid Command " + cmdLine.getCommand() + "!");
        }
    }
}
