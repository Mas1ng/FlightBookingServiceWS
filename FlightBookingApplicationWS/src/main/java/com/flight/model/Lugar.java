package com.flight.model;

public class Lugar {
    int numLugar;
    Viagem viagem;
    Extras extras;
    Cliente cliente;

    public Lugar(int numLugar, Viagem viagem, Extras extras, Cliente cliente) {
         this.numLugar = numLugar;
         this.viagem= viagem;
         this.extras = extras;
         this.cliente = cliente;
    }

    public void setCliente(Cliente c) {
        this.cliente = c;
    }
    public int getnumLugar()
    {
        return numLugar;
    }
}
