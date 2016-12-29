package com.svh.addressbook.command;

import com.svh.addressbook.application.Application;
import com.svh.addressbook.console.ConsolePrinter;
import com.svh.addressbook.contact.Contact;
import com.svh.addressbook.registry.Registry;
import com.svh.addressbook.remoteregistry.RemoteRegistry;

import java.util.List;

/**
 * Created by SVh on 12/27/2016.
 */
public class DeleteContactCommand implements Command {

    private Registry registry;
    private RemoteRegistry remoteRegistry;
    private ConsolePrinter consolePrinter;
    private List<String> parameters;

    public DeleteContactCommand() {
    }

    public DeleteContactCommand(Application app, ConsolePrinter cp, List<String> params) {
        this.registry = app.getRegistry();
        this.remoteRegistry = app.getRemoteRegistry();
        this.consolePrinter = cp;
        this.parameters = params;
    }

    @Override
    public String getName() {
        return "delete";
    }

    @Override
    public String getDescription() {
        return "Deletes a contact";
    }

    @Override
    public void execute() {
        if (validate()) {
            boolean isDeleted = this.registry.deleteContact(parameters.get(0));
            if (isDeleted) {
                consolePrinter.print("The contact has been deleted.");
            }
            if (!isDeleted) {
                boolean found = false;
                for (Contact contact : this.remoteRegistry.getRemoteContacts()) {
                    if (contact.getId().equals(parameters.get(0))) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    consolePrinter.print("Central contact can not be deleted.");
                } else {
                    consolePrinter.print("The contact was not deleted. The contact does not exist.");
                }
            }
        }
    }

    public boolean validate() {
        if (parameters.size() != 1) {
            consolePrinter.print("Delete command should have one parameter.");
            return false;
        }
        if (parameters.get(0).isEmpty()) {
            consolePrinter.print("Paramaters for delete command should not be empty.");
            return false;
        }
        return true;
    }
}
