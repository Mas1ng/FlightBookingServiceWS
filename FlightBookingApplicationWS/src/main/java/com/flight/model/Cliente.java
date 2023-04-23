package com.flight.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Pessoa implements Serializable {
    //ArrayList<Bilhete> bilhetes;
    private BilheteList bilheteList;

    public Cliente(Email email, String nome, Data data, BilheteList bilheteList) {
        super(email, nome, data);
        this.bilheteList = bilheteList;
    }

    public BilheteList getBilhetes(){
        return bilheteList;
    }

    public void setBilhetes(BilheteList bilheteList) {
        this.bilheteList = bilheteList;
    }
}
