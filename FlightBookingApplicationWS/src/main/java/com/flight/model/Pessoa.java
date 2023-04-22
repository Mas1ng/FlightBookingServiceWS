package com.flight.model;
import com.flight.exceptions.InvalidDataException;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private Data data;
    private Email email;
    private boolean isNameValid(String name){
        if(name.length() < 3){
            return false;
        }
        return true;
    }
    public Pessoa(String nome){
        setNome(nome);
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        if(isNameValid(nome)){
            this.nome = nome;
        }else{
            String msg = "Person: " + nome;
            throw new InvalidDataException(msg);
        }
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
