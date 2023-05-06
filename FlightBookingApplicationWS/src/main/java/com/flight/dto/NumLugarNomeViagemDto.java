package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numLugar","nomeViagem"})
@JacksonXmlRootElement(localName = "detalhes")
public class NumLugarNomeViagemDto {
    @JacksonXmlProperty(localName="numLugar")
    private int nLugar;
    @JacksonXmlProperty(localName="nomeViagem")
    private String nomeViagem;

    public NumLugarNomeViagemDto(int nLugar, String nomeViagem) {
        this.nLugar = nLugar;
        this.nomeViagem = nomeViagem;
    }

    public NumLugarNomeViagemDto() {
    }

    public int getnLugar() {
        return nLugar;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }
}
