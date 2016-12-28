package com.svh.addressbook.command;

import com.svh.addressbook.application.Application;
import com.svh.addressbook.console.Console;
import com.svh.addressbook.exception.InvalidCommandException;

/**
 * Created by SVh on 12/27/2016.
 */
public class CommandLineInterface implements InputHandler {

    private CommandInterpreter commandInterpreter;
    private Console console;

    public CommandLineInterface(Application app) {
        this.console = new Console();
        this.commandInterpreter = new CommandInterpreter(app);
        console.registerInputHandler(this);
    }

    @Override
    public void handle(CommandLine cl) {
        try {
            Command command = commandInterpreter.interpret(cl);
            command.execute();
        } catch (InvalidCommandException e) {
            this.console.print(e.getMessage());
        }
    }
}
