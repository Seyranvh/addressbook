package com.svh.addressbook.registry;

/**
 * Created by SVh on 12/28/2016.
 */
public class AutoSave implements Runnable {
    private RegistryPersister registryPersister;

    public AutoSave(RegistryPersister registryPersister) {
        this.registryPersister = registryPersister;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                threadSafeSave();
            } catch (InterruptedException e) {
                System.out.println("Auto saving encountered a problem." + e.getMessage());
            }
        }
    }

    private synchronized void threadSafeSave() {
        this.registryPersister.save();
    }
}
