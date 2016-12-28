package com.svh.addressbook.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SVh on 12/27/2016.
 */
public class HelpMenu {
    private List<Command> commands;

    public HelpMenu() {
        this.commands = new ArrayList<>();
        build();
    }

    public List<Command> getCommands() {
        return this.commands;
    }

    private void build() {
        this.commands.add(new AddContactCommand());
        this.commands.add(new DeleteContactCommand());
        this.commands.add(new ListCommand());
        this.commands.add(new SearchCommand());
        this.commands.add(new HelpCommand());
        this.commands.add(new QuitCommand());
    }
}
