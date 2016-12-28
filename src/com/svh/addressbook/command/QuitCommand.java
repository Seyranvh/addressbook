package com.svh.addressbook.command;

import com.svh.addressbook.application.Application;
import com.svh.addressbook.console.ConsolePrinter;

/**
 * Created by SVh on 12/27/2016.
 */
public class QuitCommand implements Command {

    private ConsolePrinter consolePrinter;
    private Application application;

    public QuitCommand() {
    }

    public QuitCommand(Application app, ConsolePrinter cp) {
        this.application = app;
        this.consolePrinter = cp;
    }

    @Override
    public String getName() {
        return "Quit";
    }

    @Override
    public String getDescription() {
        return "Quit the program";
    }

    @Override
    public void execute() {

        this.consolePrinter.print("Exiting program...");
        application.quit();
    }
}
