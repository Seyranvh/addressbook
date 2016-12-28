package com.svh.addressbook.console;

import com.svh.addressbook.command.CommandLine;
import com.svh.addressbook.command.InputHandler;

import java.util.Scanner;

/**
 * Created by SVh on 12/27/2016.
 */
public class Console implements ConsolePrinter {
    @Override
    public void print(String string) {
        System.out.println(string);
    }

    public void registerInputHandler(InputHandler handler) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            CommandLine cl = CommandLine.parse(scanner.nextLine());
            handler.handle(cl);
        }
    }
}
