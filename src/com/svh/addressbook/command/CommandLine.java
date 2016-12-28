package com.svh.addressbook.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SVh on 12/27/2016.
 */
public class CommandLine {
    private String command;
    private List<String> parameters;

    public String getCommand() {
        return this.command;
    }

    public List<String> getParameters() {
        return this.parameters;
    }

    private CommandLine(String command, List<String> params) {
        this.command = command;
        this.parameters = params;
    }

    public static CommandLine parse(String lineStr) {
        String[] splited = lineStr.split("\\s+");
        List<String> params = new ArrayList<>();
        String command = splited[0].toLowerCase();
        if (splited.length > 1) {
            for (int i = 1; i < splited.length; ++i) {
                params.add(splited[i]);
            }
        }
        CommandLine cl = new CommandLine(command, params);
        return cl;
    }

}
