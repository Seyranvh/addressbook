package com.svh.addressbook.command;

import com.svh.addressbook.application.Application;
import com.svh.addressbook.console.ConsolePrinter;
import com.svh.addressbook.contact.Contact;
import com.svh.addressbook.registry.Registry;

import java.util.List;

/**
 * Created by SVh on 12/27/2016.
 */
public class SearchCommand implements Command {

    private ConsolePrinter consolePrinter;
    private List<String> parameters;
    private Registry registry;

    public SearchCommand() {
    }

    public SearchCommand(Application app, ConsolePrinter cp, List<String> params) {
        this.registry = app.getRegistry();
        this.consolePrinter = cp;
        this.parameters = params;
    }

    @Override
    public String getName() {
        return "search";
    }

    @Override
    public String getDescription() {
        return "searches a contact";
    }

    @Override
    public void execute() {
        if (validate()) {
            List<Contact> found = this.registry.search(parameters.get(0));
            if (found.isEmpty()) {
                consolePrinter.print(parameters.get(0) + " was not found.");
            } else {
                List<Contact> sorted = ContactListSorter.sort(found);
                for (Contact contact : sorted) {
                    consolePrinter.print(ContactFormater.format(contact));
                }
            }
        }
    }

    public boolean validate() {
        if (parameters.size() != 1) {
            consolePrinter.print("Search command should have one parameter.");
            return false;
        }
        if (parameters.get(0).isEmpty()) {
            consolePrinter.print("Paramaters for search command should not be empty.");
            return false;
        }
        return true;
    }

}
