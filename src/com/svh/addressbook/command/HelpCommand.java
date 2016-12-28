package com.svh.addressbook.command;

import com.svh.addressbook.console.ConsolePrinter;

import java.util.List;

/**
 * Created by SVh on 12/27/2016.
 */
public class HelpCommand implements Command {

    private ConsolePrinter consolePrinter;

    public HelpCommand() {

    }

    public HelpCommand(ConsolePrinter cp) {
        this.consolePrinter = cp;
    }

    public String format(String command) {
        return null;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Describes commands";
    }

    @Override
    public void execute() {
        HelpMenu helpMenu = new HelpMenu();
        List<Command> commands = helpMenu.getCommands();
        for (Command command : commands) {
            this.consolePrinter.print(command.getName() + " - " + command.getDescription());
        }
    }
}
