package com.svh.addressbook.remoteregistry;

import java.util.List;

/**
 * Created by SVh on 29/12/2016.
 */
public class CatalogueLoader implements Runnable {

    private RemoteRegistry remoteRegistry;

    public CatalogueLoader(RemoteRegistry rRegisrty) {
        this.remoteRegistry = rRegisrty;
    }

    @Override
    public void run() {
        RemoteCatalogueFactory rcf = new RemoteCatalogueFactory();
        RemoteCatalogueProxy rcp = rcf.create("localhost");
        List<String> contactsStr = rcp.getContacts();
        for (String line : contactsStr) {
            String[] splitedLine = line.split(",");
            this.remoteRegistry.addRemoteContact(splitedLine[0], splitedLine[1], splitedLine[2], splitedLine[3]);
        }
    }

}
