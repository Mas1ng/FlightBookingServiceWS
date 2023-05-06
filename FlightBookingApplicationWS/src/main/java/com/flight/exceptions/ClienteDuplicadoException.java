package com.flight.exceptions;

public class ClienteDuplicadoException extends RuntimeException{
    public ClienteDuplicadoException(String msg) {
        super(msg);
    }
}
