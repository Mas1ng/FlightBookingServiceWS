package com.flight.model;
import com.flight.exceptions.EmailInvalidException;
import com.flight.exceptions.InvalidDataException;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pessoa implements Serializable {
    private String nome;
    private Data data;
    private String email;
    private boolean isNameValid(String name){
        if(name.length() < 3){
            return false;
        }
        return true;
    }
    public Pessoa(String email, String nome, Data data){
        setEmail(email);
        setNome(nome);
        setData(data);
    }

    public Pessoa(String nome, Data data) {
        this.nome = nome;
        this.data = data;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try {
            if (validateEmail(email)) {
                this.email = email;
            } else {
                String msg = "Email invalido";
                throw new EmailInvalidException(msg);
            }
        }catch (EmailInvalidException e) {}
    }

    public boolean validateEmail(String email){
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern emailPat = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }
}
