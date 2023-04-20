package com.flight.model;
import com.flight.exceptions.InvalidDataException;

import javax.xml.crypto.Data;
import java.io.Serializable;

public class Pessoa implements Serializable {
    private String name;
    private Date data;
    private boolean isNameValid(String name){
        if(name.length() < 3){
            return false;
        }
        return true;
    }
    public Pessoa(String name){
        setName(name);
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        if(isNameValid(name)){
            this.name = name;
        }else{

            String msg = "Person: " + name;
            throw new InvalidDataException(msg);
        }
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
