package com.svh.addressbook.remoteregistry;

/**
 * Created by SVh on 29/12/2016.
 */
public class RemoteCatalogueFactory {
    private int defaultPort;

    public RemoteCatalogueFactory() {
        this.defaultPort = 61616;
    }

    public RemoteCatalogueProxy create(String host) {
        return new AtomicRemoteCatalogueProxy(host, defaultPort);
    }
}
