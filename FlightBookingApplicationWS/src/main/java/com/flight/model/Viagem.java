package com.flight.model;

import java.io.Serializable;
import java.util.Arrays;

public class Viagem implements Serializable {
    private int counter=0;
    private String nomeViagem;
    BilheteList bilhetesTotais;
    BilheteList bilhetesParaVender;
    Companhia companhia;
    int lugaresTotais;
    int lugaresUsados;

    String cidadeFinal;
    String cidadeInicial;

    Data dataPartida;
    Data dataChegada;

    int lugaresEconomicos;
    int lugaresExecutivos;
    int lugaresPrimeiraClasse;

    private String[] cidades_possiveis = new String [] {"Abu Dhabi","Abu Dhabi Bateen", "Dubai", "Algiers","Oran", "Amsterdam","Rotterdam", "Auckland","Christchurch", "Barcelona","Madrid", "Bogota","Barranquilla","Medellin", "Bordeaux","Paris", "Brussels","Charleroi", "Brisbane","Sydney", "Cairo","Luxor", "Sharm el-Sheikh", "Billund", "Copenhagen","Copenhagen Roskilde", "Dar es Salaam","Zanzibar", "Dubai","Sharjah", "Dublin","Cork","Dublin Weston", "Frankfurt","Munich", "Geneva","Bern", "Geneva","Geneva", "Guangzhou","Shenzhen", "Helsinki","Oulu", "Hong Kong","Macau", "Houston","Dallas", "Istanbul","Ankara", "Jakarta","Denpasar", "Johannesburg","Cape Town", "Johannesburg","Durban", "Kuala Lumpur","Kota Kinabalu", "Kuala Lumpur","Penang", "Kunming","Lijiang","Gdansk", "Krakow","Katowice", "Krakow","Poznan", "Krakow","Rzeszow", "Krakow","Warsaw", "Las Vegas","Los Angeles", "Lima","Cusco", "Lisboa","Porto", "London","Manchester", "Los Angeles","San Francisco", "Manila","Cebu", "Manila","Manila Ninoy Aquino", "Marrakesh","Casablanca", "Medellin","Bogota", "Mexico City","Cancun", "Milan","Bergamo", "Montreal","Toronto", "Moscow","Saint Petersburg", "Mumbai","New Delhi", "Munich","Düsseldorf", "New Delhi","Mumbai", "New York City","Los Angeles", "New York City","Newark", "Osaka","Osaka Itami", "Osaka","Tokyo", "Oslo","Bergen", "Palma de Mallorca","Barcelona", "Paris","Nice", "Paris","Paris", "Phnom Penh","Siem Reap", "Rome","Milan", "Santiago","Concepción", "Santiago","Easter Island", "Salzburg","Vienna", "San Francisco","Los Angeles", "São Paulo","Rio de Janeiro", "Seoul","Busan", "Seoul","Jeju", "Seoul","Seoul Gimpo", "Sharm el-Sheikh","Hurghada", "Shanghai","Beijing", "Stockholm","Gothenburg", "Sydney","Melbourne", "Taipei","Kaohsiung", "Taipei","Taipei Songshan", "Tallinn","Tartu", "Tel Aviv","Eilat", "Tehran","Mashhad", "Tehran","Tabriz", "Tokyo","Osaka", "Toulouse","Marseille", "Toulouse","Paris", "Toronto","Vancouver", "Vienna","Graz", "Vilnius","Kaunas", "Zagreb","Split", "Zurich","Basel", "Zurich","Geneva"};

    public Viagem(Companhia companhia, int lugaresTotais, String cidadeInicial, String cidadeFinal, Data dataPartida, Data dataChegada, int lugaresEconomicos, int lugaresExecutivos, int lugaresPrimeiraClasse) {
        counter++;
        this.counter=counter;
        this.companhia=companhia;
        if(lugaresTotais>50 && lugaresTotais<200) {
            this.lugaresTotais = lugaresTotais;
        } else {
            //throw new numeroMaxLugaresInvalidos;
            throw new Exception();
        }
        setCidadeFinal(cidadeFinal);
        setCidadeInicial(cidadeInicial);
        if(dataChegada.isGreaterThan(dataPartida)) {
            this.dataPartida = dataPartida;
            this.dataChegada = dataChegada;
        } else {
            //throw new datachegadaantesdataPartida
            throw new Exception();
        }
        if(lugaresEconomicos>lugaresExecutivos && lugaresExecutivos>lugaresPrimeiraClasse && lugaresEconomicos+lugaresExecutivos+lugaresPrimeiraClasse==lugaresTotais) {
            this.lugaresEconomicos = lugaresEconomicos;
            this.lugaresExecutivos = lugaresExecutivos;
            this.lugaresPrimeiraClasse = lugaresPrimeiraClasse;
        } else {
            //throw new lugaresInvalidos
            throw new Exception();
        }
        this.nomeViagem = setNomeViagem(cidadeFinal,cidadeInicial,counter);
        this.bilhetesTotais = new BilheteList(nomeViagem,lugaresTotais,lugaresEconomicos,lugaresExecutivos,lugaresPrimeiraClasse);
        this.bilhetesParaVender =bilhetesTotais;
    }

    public Viagem() {
        this.bilhetesTotais = new BilheteList();
        this.dataPartida = new Data();
        this.dataChegada = new Data();
    }

    public boolean validadeCidade(String cidade) {
        if(Arrays.asList(cidades_possiveis).contains(cidade)) {
            return true;
        } return false;
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
    public void setNomeViagem(String nomeViagem) {
        this.nomeViagem = nomeViagem;
    }
    public BilheteList getSeats() {
        return bilhetesTotais;
    }
    public void setSeats(BilheteList bilheteList) {
        this.bilhetesTotais = bilheteList;
    }
    public int getLugaresTotais() {
        return lugaresTotais;
    }
    public void setLugaresTotais(int lugaresTotais) {
        this.lugaresTotais = lugaresTotais;
    }
    public int getLugaresUsados() {
        int vendidos = lugaresTotais - bilhetesParaVender.sizeBilheteList();
        return vendidos;
    }
    public void setLugaresUsados(int lugaresUsados) {
        this.lugaresUsados = lugaresUsados;
    }
    public String getCidadeFinal() {
        return cidadeFinal;
    }
    public void setCidadeFinal(String cidadeFinal) {
        if(validadeCidade(cidadeFinal)){
            this.cidadeFinal = cidadeFinal;
        } else {
            //throw new Cidadeexceotion
        }
    }
    public String getCidadeInicial() {
        return cidadeInicial;
    }
    public void setCidadeInicial(String cidadeInicial) {
        if(validadeCidade(cidadeInicial)){
            this.cidadeInicial = cidadeInicial;
        } else {
            //throw new Cidadeexceotion
        }
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
    public BilheteList getBilheteList() {
        return bilhetesTotais;
    }
    public void setBilheteList(BilheteList bilheteList) {
        this.bilhetesTotais = bilheteList;
    }
    public Companhia getCompanhia() {
        return companhia;
    }
    public void setCompanhia(Companhia companhia) {
        this.companhia = companhia;
    }
}
