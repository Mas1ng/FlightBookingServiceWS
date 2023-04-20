package com.flight.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Pessoa implements Serializable {
    ArrayList<Lugar> lugares;

    public Cliente(String name) {
        super(name);
    }
    public ArrayList<Lugar> getLugares(){
        return lugares;
    }


}
