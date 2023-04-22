package com.flight.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Pessoa implements Serializable {
    //ArrayList<Bilhete> bilhetes;
    private BilheteList bilheteList;

    public Cliente(String name, BilheteList bilheteList, Viagem viagem) {
        super(name);
        this.bilheteList = bilheteList;
    }

    public Cliente(String name) {
        super(name);
        this.bilheteList = new BilheteList();
    }

    public BilheteList getBilhetes(){
        return bilheteList;
    }

    public void setBilhetes(BilheteList bilheteList) {
        this.bilheteList = bilheteList;
    }
}
