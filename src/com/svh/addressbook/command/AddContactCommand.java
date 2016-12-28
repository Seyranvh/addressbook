package com.svh.addressbook.command;

import com.svh.addressbook.application.Application;
import com.svh.addressbook.console.Console;
import com.svh.addressbook.console.ConsolePrinter;
import com.svh.addressbook.registry.Registry;

import java.util.List;

/**
 * Created by SVh on 12/27/2016.
 */
public class AddContactCommand implements Command {

    private List<String> parameters;
    private ConsolePrinter consolePrinter;
    private Registry registry;

    public AddContactCommand() {

    }

    public AddContactCommand(Application app, Console consolePrinter, List<String> params) {
        this.registry = app.getRegistry();
        this.parameters = params;
        this.consolePrinter = consolePrinter;
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "add a contact";
    }

    @Override
    public void execute() {
        if (validate()) {
            this.registry.addContact(parameters.get(0), parameters.get(1), parameters.get(2));
            this.consolePrinter.print("Contact added.");
        }
    }

    public boolean validate() {
        if (parameters.size() != 3) {
            consolePrinter.print("Add command should have three parameters.");
            return false;
        }
        if (parameters.get(0).isEmpty() || parameters.get(1).isEmpty() || parameters.get(2).isEmpty()) {
            consolePrinter.print("Paramaters for add command should not be empty.");
            return false;
        }
        return true;
    }
}
