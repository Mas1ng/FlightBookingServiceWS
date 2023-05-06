package com.flight.exceptions;

import com.flight.model.Email;

public class ClienteDuplicadoException extends RuntimeException{
    public ClienteDuplicadoException(String msg) {
        super(msg);
    }
}
