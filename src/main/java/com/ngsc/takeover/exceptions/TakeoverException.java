package com.ngsc.takeover.exceptions;

public class TakeoverException extends RuntimeException {
    public TakeoverException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public TakeoverException(String exMessage) {
        super(exMessage);
    }
}
