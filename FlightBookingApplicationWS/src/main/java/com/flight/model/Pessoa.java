package com.flight.model;
import com.flight.exceptions.InvalidException;
import com.flight.exceptions.InvalidDataException;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pessoa implements Serializable {
    private String nome;
    private Data data;
    private String email;
    private long cc;
    private boolean isNameValid(String name){
        if(name.length() < 3){
            return false;
        }
        return true;
    }

    private boolean isCcValid(long cc){
        if(cc < 100000000 || cc > 999999999){
            return false;
        }
        return true;
    }
    public Pessoa(String email, String nome, Data data,long cc){
        setEmail(email);
        setNome(nome);
        setData(data);
        setCc(cc);
    }

    public Pessoa(String nome, Data data,long cc){
        setNome(nome);
        setData(data);
        setCc(cc);
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
        if (validateEmail(email)) {
            this.email = email;
        } else {
            String msg = "Email invalido";
            throw new InvalidException(msg);
        }
    }

    public boolean validateEmail(String email){
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern emailPat = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }

    public long getCc() {
        return cc;
    }

    public void setCc(long cc) {
        if(isCcValid(cc)) {
            this.cc=cc;
        }
        else {
            String msg = "Numero cc invalido";
            throw new InvalidException(msg);
        }
    }
}
