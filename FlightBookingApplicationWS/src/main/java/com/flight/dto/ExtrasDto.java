package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flight.model.Mala;

@JsonPropertyOrder({"preco","tipoLugar","seguro","comida","mala"})
@JacksonXmlRootElement(localName = "extras")
public class ExtrasDto {

    @JacksonXmlProperty(localName="preco")
    private int preco;
    @JacksonXmlProperty(localName="tipoLugar")
    private String tipoLugar;
    @JacksonXmlProperty(localName="seguro")
    private boolean seguro;
    @JacksonXmlProperty(localName="comida")
    private boolean comida;
    @JacksonXmlProperty(localName="mala")
    private Mala mala;

    public ExtrasDto() {
    }

    public int getPreco() {
        return preco;
    }

    public String getTipoLugar() {
        return tipoLugar;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public boolean isComida() {
        return comida;
    }

    public Mala getMala() {
        return mala;
    }
}
