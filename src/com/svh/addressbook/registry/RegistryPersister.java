package com.svh.addressbook.registry;

import com.svh.addressbook.application.Application;
import com.svh.addressbook.contact.Contact;

import java.io.*;
import java.util.List;

/**
 * Created by SVh on 12/27/2016.
 */
public class RegistryPersister {

    private Registry registry;

    public RegistryPersister(Application app) {
        this.registry = app.getRegistry();
    }

    public void save() {
        File outputDirectory = new File("C:/temp");
        if (!outputDirectory.exists()) {
            outputDirectory.mkdirs();
        }
        File file = new File(outputDirectory, "registrydata.ser");
        {
            try (FileOutputStream fos = new FileOutputStream(file);
                 ObjectOutputStream oos = new ObjectOutputStream(fos);) {
                oos.writeObject(this.registry.getContacts());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void load() {
        File outputDirectory = new File("C:/temp");
        File serFile = new File(outputDirectory, "registrydata.ser");
        if (serFile.exists()) {
            try (FileInputStream is = new FileInputStream(serFile);
                 ObjectInputStream ois = new ObjectInputStream(is);) {
                List<Contact> tempList = (List<Contact>) ois.readObject();
                this.registry.load(tempList);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
