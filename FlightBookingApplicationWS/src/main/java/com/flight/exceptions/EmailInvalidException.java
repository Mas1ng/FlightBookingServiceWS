package com.flight.exceptions;

public class EmailInvalidException extends RuntimeException{
    public EmailInvalidException(String s) {
        super(s);
    }
}
