package com.flight.exceptions;

import com.flight.model.Email;

public class ClienteDuplicadoException extends RuntimeException{
    public ClienteDuplicadoException(String email) {
        System.out.println("Já existe um utilizador com o username " + email);
    }
}
