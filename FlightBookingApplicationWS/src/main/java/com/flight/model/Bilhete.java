package com.flight.model;

public class Bilhete {
    int numLugar;
    Viagem viagem;
    Extras extras;
    TipoPassageiro tipoPassageiro;

    public Bilhete(int numLugar, Viagem viagem, Extras extras, TipoPassageiro tipoPassageiro) {
         this.numLugar = numLugar;
         this.viagem= viagem;
         this.extras = extras;
         this.tipoPassageiro = tipoPassageiro;
    }

    public int getnumLugar()
    {
        return numLugar;
    }

    public void setNumLugar(int numLugar) {
        this.numLugar = numLugar;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public void setExtras(Extras extras) {
        this.extras = extras;
    }

    public void setTipoPassageiro(TipoPassageiro tipoPassageiro) {
        this.tipoPassageiro = tipoPassageiro;
    }
}
