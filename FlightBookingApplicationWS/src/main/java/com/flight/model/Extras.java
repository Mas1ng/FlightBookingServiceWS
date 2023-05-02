package com.flight.model;

import java.io.Serializable;

public class Extras implements Serializable {
    int preco;
    String tipoLugar;
    boolean seguro;
    boolean comida;
    Mala mala;

    public Extras(int preco, String tipoLugar, boolean seguro, boolean comida, Mala mala) {
        this.preco = preco;
        this.tipoLugar = tipoLugar;
        this.seguro = seguro;
        this.comida = comida;
        this.mala = mala;
    }

    public void getextra(String [] args)
    {
        args[0]= String.valueOf(this.preco);
        args[1]= this.tipoLugar;
        args[2] = String.valueOf(this.seguro);
        args[3] = String.valueOf(this.comida);
        args[4] = String.valueOf(this.mala);
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getTipoLugar() {
        return tipoLugar;
    }

    public void setTipoLugar(String tipoLugar) {
        this.tipoLugar = tipoLugar;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public Mala getMala() {
        return mala;
    }

    public void setMala(Mala mala) {
        this.mala = mala;
    }
}
