package com.svh.addressbook.command;

import com.svh.addressbook.contact.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by SVh on 12/28/2016.
 */
public class ContactListSorter {

    public static List<Contact> sort(List<Contact> contacts) {
        // List<Contact> copiedList = (ArrayList)((ArrayList)contacts).clone();
        Collections.sort(contacts, contactComparator);
        return contacts;
    }

    public static Comparator<Contact> contactComparator = new Comparator<Contact>() {

        public int compare(Contact c1, Contact c2) {
            String contactName1 = c1.getFirstName().toLowerCase();
            String contactName2 = c2.getFirstName().toLowerCase();
            return contactName1.compareToIgnoreCase(contactName2);
        }
    };

}
