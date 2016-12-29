package com.svh.addressbook.remoteregistry;

import com.svh.addressbook.contact.Contact;
import com.svh.addressbook.contact.ContactDetails;

/**
 * Created by SVh on 29/12/2016.
 */
public class RemoteContact extends ContactDetails implements Contact {
    private String id;

    public RemoteContact(String id, String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public String getEmailAddress() {
        return super.getEmailAddress();
    }
}
