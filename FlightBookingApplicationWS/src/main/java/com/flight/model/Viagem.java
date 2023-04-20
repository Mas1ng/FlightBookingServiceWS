package com.flight.model;

import java.sql.Date;
import java.util.ArrayList;

public class Viagem {
    private String nomeViagem;
    ArrayList<Lugar> lugares;
    int lugaresTotais;
    int lugaresUsados;

    String cidadeFinal;
    String cidadeInicial;

    Date dataPartida;
    Date dataChegada;

    int lugaresEconomicos;
    int lugaresExecutivos;
    int lugaresPrimeiraClasse;

    //int oldESeats;
    //int oldBSeats;
    //int oldFSeats;
    //int oldTSeats;

    //public boolean isChanged;


    public Viagem(String nomeViagem, ArrayList<Lugar> lugares, int lugaresTotais, int lugaresUsados, String cidadeFinal, String cidadeInicial, Date dataPartida, Date dataChegada, int lugaresEconomicos, int lugaresExecutivos, int lugaresPrimeiraClasse) {
        this.nomeViagem = nomeViagem;
        this.lugares = lugares;
        this.lugaresTotais = lugaresTotais;
        this.lugaresUsados = lugaresUsados;
        this.cidadeFinal = cidadeFinal;
        this.cidadeInicial = cidadeInicial;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
        this.lugaresEconomicos = lugaresEconomicos;
        this.lugaresExecutivos = lugaresExecutivos;
        this.lugaresPrimeiraClasse = lugaresPrimeiraClasse;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }

    public void setNomeViagem(String nomeViagem) {
        this.nomeViagem = nomeViagem;
    }

    public ArrayList<Lugar> getSeats() {
        return lugares;
    }

    public void setSeats(ArrayList<Lugar> seats) {
        this.lugares = seats;
    }

    public int getLugaresTotais() {
        return lugaresTotais;
    }

    public void setLugaresTotais(int lugaresTotais) {
        this.lugaresTotais = lugaresTotais;
    }

    public int getLugaresUsados() {
        return lugaresUsados;
    }

    public void setLugaresUsados(int lugaresUsados) {
        this.lugaresUsados = lugaresUsados;
    }

    public String getCidadeFinal() {
        return cidadeFinal;
    }

    public void setCidadeFinal(String cidadeFinal) {
        this.cidadeFinal = cidadeFinal;
    }

    public String getCidadeInicial() {
        return cidadeInicial;
    }

    public void setCidadeInicial(String cidadeInicial) {
        this.cidadeInicial = cidadeInicial;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public int getLugaresEconomicos() {
        return lugaresEconomicos;
    }

    public void setLugaresEconomicos(int lugaresEconomicos) {
        this.lugaresEconomicos = lugaresEconomicos;
    }

    public int getLugaresExecutivos() {
        return lugaresExecutivos;
    }

    public void setLugaresExecutivos(int lugaresExecutivos) {
        this.lugaresExecutivos = lugaresExecutivos;
    }

    public int getLugaresPrimeiraClasse() {
        return lugaresPrimeiraClasse;
    }

    public void setLugaresPrimeiraClasse(int lugaresPrimeiraClasse) {
        this.lugaresPrimeiraClasse = lugaresPrimeiraClasse;
    }

    public void setCliente (Cliente c) {
        lugares.get(lugaresTotais-lugaresUsados).setCliente(c);
    }
}
