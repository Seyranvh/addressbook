package com.svh.addressbook.remoteregistry;

import com.svh.addressbook.contact.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SVh on 29/12/2016.
 */
public class RemoteRegistry {

    private List<Contact> remoteContacts = new ArrayList<>();

    public List<Contact> getRemoteContacts() {
        return this.remoteContacts;
    }

    public List<Contact> search(String term) {
        List<Contact> foundList = new ArrayList<>();
        for (Contact contact : remoteContacts) {
            if (contact.getFirstName().toLowerCase().startsWith(term.toLowerCase()) || contact.getLastName().toLowerCase().startsWith(term.toLowerCase())) {
                foundList.add(contact);
            }
        }
        return foundList;
    }

    public void addRemoteContact(String id, String firstName, String lastName, String email) {
        RemoteContact contact = new RemoteContact(id, firstName, lastName, email);
        remoteContacts.add(contact);
    }
}
