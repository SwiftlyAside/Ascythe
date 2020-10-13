package com.ngsc.ascythe.exceptions;

public class AscytheException extends RuntimeException {
    public AscytheException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public AscytheException(String exMessage) {
        super(exMessage);
    }
}
