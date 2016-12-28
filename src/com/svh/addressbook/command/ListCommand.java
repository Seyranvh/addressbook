package com.svh.addressbook.command;

import com.svh.addressbook.application.Application;
import com.svh.addressbook.console.ConsolePrinter;
import com.svh.addressbook.contact.Contact;
import com.svh.addressbook.registry.Registry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SVh on 12/27/2016.
 */
public class ListCommand implements Command {

    private Registry registry;
    private ConsolePrinter consolePrinter;

    public ListCommand() {
    }

    public ListCommand(Application app, ConsolePrinter cp) {
        this.registry = app.getRegistry();
        this.consolePrinter = cp;
    }

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public String getDescription() {

        return "Shows list of contacts";
    }

    @Override
    public void execute() {
        List<Contact> contacts = this.registry.getContacts();
        List<Contact> copiedList = (ArrayList) ((ArrayList) contacts).clone();
        List<Contact> sortedList = ContactListSorter.sort(copiedList);
        for (Contact contact : sortedList) {
            consolePrinter.print(ContactFormater.format(contact));
        }
    }
}
