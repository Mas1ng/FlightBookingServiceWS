package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JsonPropertyOrder({"nomeViagem", "lugaresTotais","lugaresUsados", "company", "cidadeFinal", "cidadeInicial", "dataPartida", "dataChegada", "lugaresEconomicos", "lugaresExecutivos", "lugaresPrimeiraClasse"} )
@JacksonXmlRootElement(localName = "viagem")
public class ViagemDto {
    @JacksonXmlProperty(localName = "nomeViagem")
    private String nomeViagem;
    @JacksonXmlProperty(localName = "LugaresTotais")
    private String LugaresTotais;
    @JacksonXmlProperty(localName = "LugaresUsados")
    private String LugaresUsados;
    @JacksonXmlProperty(localName = "company")
    private String company;
    @JacksonXmlProperty(localName = "cidadeFinal")
    private String cidadeFinal;
    @JacksonXmlProperty(localName = "cidadeInicial")
    private String cidadeInicial;
    @JacksonXmlProperty(localName = "dataPartida")
    private String dataPartida;
    @JacksonXmlProperty(localName = "dataChegada")
    private String dataChegada;
    @JacksonXmlProperty(localName = "lugaresEconomicos")
    private String lugaresEconomicos;
    @JacksonXmlProperty(localName = "lugaresExecutivos")
    private String lugaresExecutivos;
    @JacksonXmlProperty(localName = "lugaresPrimeiraClasse")
    private String lugaresPrimeiraClasse;

    public ViagemDto() {
    }

    public ViagemDto(String nomeViagem, String lugaresTotais, String lugaresUsados, String company, String cidadeFinal, String cidadeInicial, String dataPartida, String dataChegada, String lugaresEconomicos, String lugaresExecutivos, String lugaresPrimeiraClasse) {
        this.nomeViagem = nomeViagem;
        LugaresTotais = lugaresTotais;
        LugaresUsados = lugaresUsados;
        this.company = company;
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

    public String getLugaresTotais() {
        return LugaresTotais;
    }

    public void setLugaresTotais(String lugaresTotais) {
        LugaresTotais = lugaresTotais;
    }

    public String getLugaresUsados() {
        return LugaresUsados;
    }

    public void setLugaresUsados(String lugaresUsados) {
        LugaresUsados = lugaresUsados;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getLugaresEconomicos() {
        return lugaresEconomicos;
    }

    public void setLugaresEconomicos(String lugaresEconomicos) {
        this.lugaresEconomicos = lugaresEconomicos;
    }

    public String getLugaresExecutivos() {
        return lugaresExecutivos;
    }

    public void setLugaresExecutivos(String lugaresExecutivos) {
        this.lugaresExecutivos = lugaresExecutivos;
    }

    public String getLugaresPrimeiraClasse() {
        return lugaresPrimeiraClasse;
    }

    public void setLugaresPrimeiraClasse(String lugaresPrimeiraClasse) {
        this.lugaresPrimeiraClasse = lugaresPrimeiraClasse;
    }
}
