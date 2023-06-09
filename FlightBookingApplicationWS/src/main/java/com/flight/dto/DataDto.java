package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"dia","mes","ano"})
@JacksonXmlRootElement(localName = "data")
public class DataDto {
    @JacksonXmlProperty(localName="dia")
    private int dia;
    @JacksonXmlProperty(localName="mes")
    private int mes;
    @JacksonXmlProperty(localName="ano")
    private int ano;

    public DataDto(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public DataDto() {
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
}
