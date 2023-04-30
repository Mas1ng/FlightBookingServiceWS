package com.flight.model;

import java.io.Serializable;

public class Bilhete implements Serializable {
    int numLugar;
    String nomeViagem;
    Extras extras;
    TipoPassageiro tipoPassageiro;

    public Bilhete(int numLugar, String nomeViagem, Extras extras, TipoPassageiro tipoPassageiro) {
         this.numLugar = numLugar;
         this.nomeViagem= nomeViagem;
         this.extras = extras;
         this.tipoPassageiro = tipoPassageiro;
    }

    public int getNumLugar() {
        return numLugar;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }

    public Extras getExtras() {
        return extras;
    }

    public TipoPassageiro getTipoPassageiro() {
        return tipoPassageiro;
    }

    public void setNumLugar(int numLugar) {
        this.numLugar = numLugar;
    }

    public void setViagem(String nomeViagem) {
        this.nomeViagem = nomeViagem;
    }

    public void setExtras(Extras extras) {
        this.extras = extras;
    }

    public void setTipoPassageiro(TipoPassageiro tipoPassageiro) {
        this.tipoPassageiro = tipoPassageiro;
    }
}
