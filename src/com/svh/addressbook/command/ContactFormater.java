package com.svh.addressbook.command;

import com.svh.addressbook.contact.Contact;

/**
 * Created by SVh on 12/28/2016.
 */
public class ContactFormater {
    public static String format(Contact contact) {
        StringBuilder sb = new StringBuilder();
        sb.append(contact.getId() + "\n");
        sb.append(contact.getFirstName() + "\n");
        sb.append(contact.getLastName() + "\n");
        sb.append(contact.getEmailAddress() + "\n");
        sb.append("-----------------------------------\n");
        return sb.toString();
    }
}
