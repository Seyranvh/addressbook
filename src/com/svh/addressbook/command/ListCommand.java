package com.svh.addressbook.command;

import com.svh.addressbook.application.Application;
import com.svh.addressbook.console.ConsolePrinter;
import com.svh.addressbook.contact.Contact;
import com.svh.addressbook.registry.Registry;
import com.svh.addressbook.remoteregistry.RemoteRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SVh on 12/27/2016.
 */
public class ListCommand implements Command {

    private Registry registry;
    private RemoteRegistry remoteRegistry;
    private ConsolePrinter consolePrinter;

    public ListCommand() {
    }

    public ListCommand(Application app, ConsolePrinter cp) {
        this.registry = app.getRegistry();
        this.remoteRegistry = app.getRemoteRegistry();
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
        List<Contact> allContacts = new ArrayList<>();
        allContacts.addAll(this.registry.getContacts());
        allContacts.addAll(this.remoteRegistry.getRemoteContacts());

        List<Contact> copiedList = (ArrayList) ((ArrayList) allContacts).clone();
        List<Contact> sortedList = ContactListSorter.sort(copiedList);
        for (Contact contact : sortedList) {
            consolePrinter.print(ContactFormater.format(contact));
        }
    }
}
