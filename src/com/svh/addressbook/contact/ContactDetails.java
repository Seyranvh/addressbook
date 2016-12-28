package com.svh.addressbook.contact;

import java.io.Serializable;

/**
 * Created by SVh on 12/27/2016.
 */
public class ContactDetails implements Serializable {
    private String firstName;
    private String lastName;
    private String email;

    public ContactDetails(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return email;
    }

}
