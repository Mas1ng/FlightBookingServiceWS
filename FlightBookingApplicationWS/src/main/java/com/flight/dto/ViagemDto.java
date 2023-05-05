package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flight.model.Companhia;


@JsonPropertyOrder({"nomeViagem","lugaresTotais", "companhia", "cidadeInicial","cidadeFinal", "dataPartida", "dataChegada", "lugaresEconomicos", "lugaresExecutivos", "lugaresPrimeiraClasse"} )
@JacksonXmlRootElement(localName = "viagem")
public class ViagemDto {
    @JacksonXmlProperty(localName = "nomeViagem")
    private String nomeViagem;
    @JacksonXmlProperty(localName = "LugaresTotais")
    private int LugaresTotais;
    @JacksonXmlProperty(localName = "companhia")
    private Companhia companhia;
    @JacksonXmlProperty(localName = "cidadeFinal")
    private String cidadeFinal;
    @JacksonXmlProperty(localName = "cidadeInicial")
    private String cidadeInicial;
    @JacksonXmlProperty(localName = "dataPartida")
    private DataDto dataPartida;
    @JacksonXmlProperty(localName = "dataChegada")
    private DataDto dataChegada;
    @JacksonXmlProperty(localName = "lugaresEconomicos")
    private int lugaresEconomicos;
    @JacksonXmlProperty(localName = "lugaresExecutivos")
    private int lugaresExecutivos;
    @JacksonXmlProperty(localName = "lugaresPrimeiraClasse")
    private int lugaresPrimeiraClasse;

    public ViagemDto() {
    }

    public ViagemDto(int lugaresTotais, Companhia companhia, String cidadeInicial, String cidadeFinal, DataDto dataPartida, DataDto dataChegada, int lugaresEconomicos, int lugaresExecutivos, int lugaresPrimeiraClasse) {
        this.LugaresTotais = lugaresTotais;
        this.companhia = companhia;
        this.cidadeFinal = cidadeFinal;
        this.cidadeInicial = cidadeInicial;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
        this.lugaresEconomicos = lugaresEconomicos;
        this.lugaresExecutivos = lugaresExecutivos;
        this.lugaresPrimeiraClasse = lugaresPrimeiraClasse;
    }

    public ViagemDto(String nomeViagem, int lugaresTotais, Companhia companhia, String cidadeInicial, String cidadeFinal, DataDto dataPartida, DataDto dataChegada, int lugaresEconomicos, int lugaresExecutivos, int lugaresPrimeiraClasse) {
        this.nomeViagem=nomeViagem;
        this.LugaresTotais = lugaresTotais;
        this.companhia = companhia;
        this.cidadeFinal = cidadeFinal;
        this.cidadeInicial = cidadeInicial;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
        this.lugaresEconomicos = lugaresEconomicos;
        this.lugaresExecutivos = lugaresExecutivos;
        this.lugaresPrimeiraClasse = lugaresPrimeiraClasse;
    }

    public int getLugaresTotais() {
        return LugaresTotais;
    }
    public Companhia getCompanhia() {
        return companhia;
    }
    public String getCidadeFinal() {
        return cidadeFinal;
    }
    public String getCidadeInicial() {
        return cidadeInicial;
    }
    public DataDto getDataPartida() {
        return dataPartida;
    }
    public DataDto getDataChegada() {
        return dataChegada;
    }
    public int getLugaresEconomicos() {
        return lugaresEconomicos;
    }
    public int getLugaresExecutivos() {
        return lugaresExecutivos;
    }
    public int getLugaresPrimeiraClasse() {
        return lugaresPrimeiraClasse;
    }
}
