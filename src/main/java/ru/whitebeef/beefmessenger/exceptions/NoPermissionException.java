package ru.whitebeef.beefmessenger.exceptions;

public class NoPermissionException extends RuntimeException {

    public NoPermissionException(String message) {
        super(message);
    }
}
