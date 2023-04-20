package com.flight.model;

public class Extras {
    int type;
    int preco;
    //int newPreco;
    String tipoDeLugar;
    String wifi;
    String specialFood;

    public Extras(int type, int preco, String tipoDeLugar, String wifi, String specialFood) {
        this.type = type;
        this.preco = preco;
        this.tipoDeLugar = tipoDeLugar;
        this.wifi = wifi;
        this.specialFood = specialFood;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

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

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getSpecialFood() {
        return specialFood;
    }

    public void setSpecialFood(String specialFood) {
        this.specialFood = specialFood;
    }
}
