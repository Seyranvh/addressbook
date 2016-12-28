package com.svh.addressbook.command;

/**
 * Created by SVh on 12/27/2016.
 */
public interface Command {
    public String getName();

    public String getDescription();

    public void execute();
}
