package com.flight.exceptions;

import com.flight.model.Email;

public class ClienteDuplicadoException extends Throwable{
    public ClienteDuplicadoException(Email e) {
        System.out.println("Já existe um utilizador com o username " + e.getEmail());
    }
}
