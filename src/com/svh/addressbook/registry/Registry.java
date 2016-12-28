package com.svh.addressbook.registry;

import com.svh.addressbook.contact.Contact;
import com.svh.addressbook.contact.ContactDetails;
import com.svh.addressbook.contact.LocalContact;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by SVh on 12/27/2016.
 */
public class Registry {

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(String fName, String lName, String email) {
        UUID uuid = new UniqueIdGenerator().generateUniqueId();
        ContactDetails contactDetails = new ContactDetails(fName, lName, email);
        LocalContact contact = new LocalContact(uuid, contactDetails);
        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return this.contacts;
    }


    public boolean deleteContact(String id) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                return contacts.remove(contact);
            }
        }
        return false;
    }

    public List<Contact> search(String term) {
        List<Contact> found = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getFirstName().toLowerCase().startsWith(term.toLowerCase()) || contact.getLastName().toLowerCase().startsWith(term.toLowerCase())) {
                found.add(contact);
            }
        }
        return found;
    }

    public void load(List<Contact> contacts) {
        this.contacts = contacts;
    }


}
