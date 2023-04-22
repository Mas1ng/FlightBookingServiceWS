package com.flight.model;

public class Viagem {
    private int counter=0;
    private String nomeViagem;
    BilheteList bilheteList;
    int lugaresTotais;
    int lugaresUsados;

    String cidadeFinal;
    String cidadeInicial;

    Data dataPartida;
    Data dataChegada;

    int lugaresEconomicos;
    int lugaresExecutivos;
    int lugaresPrimeiraClasse;

    public Viagem(BilheteList bilheteList, int lugaresTotais, int lugaresUsados, String cidadeFinal, String cidadeInicial, Data dataPartida, Data dataChegada, int lugaresEconomicos, int lugaresExecutivos, int lugaresPrimeiraClasse) {
        counter++;
        this.counter=counter;
        this.bilheteList = bilheteList;
        this.lugaresTotais = lugaresTotais;
        this.lugaresUsados = lugaresUsados;
        this.cidadeFinal = cidadeFinal;
        this.cidadeInicial = cidadeInicial;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
        this.lugaresEconomicos = lugaresEconomicos;
        this.lugaresExecutivos = lugaresExecutivos;
        this.lugaresPrimeiraClasse = lugaresPrimeiraClasse;
        this.nomeViagem = setNomeViagem(cidadeFinal,cidadeInicial,counter);
    }

    public Viagem() {
        this.bilheteList = new BilheteList();
        this.dataPartida = new Data();
        this.dataChegada = new Data();
    }

    public String setNomeViagem(String cidadeFinal, String cidadeInicial, int counter) {
        char a1  =cidadeInicial.charAt(0) ;
        char b1  =cidadeInicial.charAt(1) ;
        char c1  =cidadeInicial.charAt(2) ;
        char a2  =cidadeFinal.charAt(0) ;
        char b2  =cidadeFinal.charAt(1) ;
        char c2  =cidadeFinal.charAt(2) ;
        String nomeViagem = a1+b1+c1+"x"+a2+b2+c2+counter;
        return nomeViagem;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }

    public BilheteList getSeats() {
        return bilheteList;
    }

    public void setSeats(BilheteList bilheteList) {
        this.bilheteList = bilheteList;
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

    public Data getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Data dataPartida) {
        this.dataPartida = dataPartida;
    }

    public Data getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Data dataChegada) {
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
}
