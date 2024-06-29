package ru.whitebeef.beefmessenger.exceptions;

public class IncorrectCredentialsException extends RuntimeException {
    public IncorrectCredentialsException(String message) {
        super(message);
    }
}
