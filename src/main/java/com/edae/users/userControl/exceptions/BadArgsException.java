package com.edae.users.userControl.exceptions;

public class BadArgsException extends IllegalArgumentException {
    public BadArgsException() {
    }

    public BadArgsException(String message) {
        super(message);
    }

    public BadArgsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadArgsException(Throwable cause) {
        super(cause);
    }

}
