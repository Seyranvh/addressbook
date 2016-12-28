package com.svh.addressbook.application;

import com.svh.addressbook.command.CommandLineInterface;
import com.svh.addressbook.registry.AutoSave;
import com.svh.addressbook.registry.Registry;
import com.svh.addressbook.registry.RegistryPersister;

/**
 * Created by SVh on 12/27/2016.
 */
public class Application {

    private Registry registry;
    private RegistryPersister registryPersister;

    public void start() {
        this.registry = new Registry();
        this.registryPersister = new RegistryPersister(this);
        this.registryPersister.load();
        AutoSave autoSave = new AutoSave(this.registryPersister);
        Thread autosaveThread = new Thread(autoSave);
        autosaveThread.start();
        CommandLineInterface cli = new CommandLineInterface(this);
    }

    public void quit() {
        this.registryPersister.save();
        System.exit(0);
    }

    public Registry getRegistry() {
        return this.registry;
    }
}
