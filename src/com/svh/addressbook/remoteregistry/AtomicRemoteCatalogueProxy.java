package com.svh.addressbook.remoteregistry;

import com.svh.addressbook.contact.Contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SVh on 29/12/2016.
 */
public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {

    private CatalogueClient catalogueClient;

    public AtomicRemoteCatalogueProxy(String host, int port) {
        this.catalogueClient = new CatalogueClient(host, port);
    }

    public List<String> getContacts() {
        this.catalogueClient.connect();
        this.catalogueClient.sendRequest("getall");
        String fileContent = this.catalogueClient.waitForResponse();
        this.catalogueClient.disconnect();
        return createContactListfromString(fileContent);
    }

    public List<String> createContactListfromString(String fileContent) {
        List<String> contactList = new ArrayList<>();
        if (fileContent != null) {
            contactList = Arrays.asList(fileContent.split("\\n"));
        }
        return contactList;
    }
}
