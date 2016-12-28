package com.svh.addressbook.exception;

/**
 * Created by SVh on 12/27/2016.
 */
public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException(String message) {
        super(message);
    }
}
