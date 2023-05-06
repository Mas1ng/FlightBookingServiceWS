package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flight.model.Mala;

@JsonPropertyOrder({"seguro","comida","mala"})
@JacksonXmlRootElement(localName = "extras")
public class ExtrasDto {
    @JacksonXmlProperty(localName="seguro")
    private boolean seguro;
    @JacksonXmlProperty(localName="comida")
    private boolean comida;
    @JacksonXmlProperty(localName="mala")
    private Mala mala;

    public ExtrasDto() {
    }

    public ExtrasDto(boolean seguro, boolean comida, Mala mala) {
        this.seguro = seguro;
        this.comida = comida;
        this.mala = mala;
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
