package com.svh.addressbook.contact;

import java.io.Serializable;
import java.util.Comparator;
import java.util.UUID;

/**
 * Created by SVh on 12/27/2016.
 */
public class LocalContact implements Contact, Serializable {

    private UUID id;
    private ContactDetails contactDetails;

    public LocalContact(UUID id, ContactDetails contactDetails) {
        this.id = id;
        this.contactDetails = contactDetails;
    }

    @Override
    public String getId() {
        return id.toString();
    }

    @Override
    public String getFirstName() {
        return this.contactDetails.getFirstName();
    }

    @Override
    public String getLastName() {
        return this.contactDetails.getLastName();
    }

    @Override
    public String getEmailAddress() {
        return this.contactDetails.getEmailAddress();
    }

}
