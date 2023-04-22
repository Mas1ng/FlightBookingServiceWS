package com.flight.model;

public class Extras {
    int preco;
    String tipoDeLugar;
    boolean seguro;
    boolean comida;
    Mala mala;

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getTipoDeLugar() {
        return tipoDeLugar;
    }

    public void setTipoDeLugar(String tipoDeLugar) {
        this.tipoDeLugar = tipoDeLugar;
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
