/*package com.flight.model;

import com.flight.exceptions.IdadeInvalidaException;

import java.io.Serializable;

public class Piloto extends Pessoa implements Serializable {


    private boolean isIdadeValid(int idade) {
        if(idade<25) {
            return false;
        }
        return true;
    }
    public void setIdade(int idade) {
        if(isIdadeValid(idade)) {
            super.setIdade(idade);
        }else{
            String msg="Idade do Piloto invalida";
            throw new IdadeInvalidaException(msg);
        }
    }

    public Piloto(String name) {
        super(name);
    }
}
*/