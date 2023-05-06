package com.flight.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Pessoa implements Serializable {
    private BilheteList bilheteList;

    public Cliente(String email, String nome, Data data, long cc, BilheteList bilheteList) {
        super(email, nome, data,cc);
        this.bilheteList = bilheteList;
    }
    public Cliente(String email, String nome, Data data, long cc) {
        super(email, nome, data,cc);
        this.bilheteList = new BilheteList();
    }

    public BilheteList getBilhetes(){
        return bilheteList;
    }

    public void setBilhetes(BilheteList bilheteList) {
        this.bilheteList = bilheteList;
    }

}
