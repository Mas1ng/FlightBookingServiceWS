package com.flight.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName="criticas")
public class CriticaListDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "criticas")
    private ArrayList<CriticaDto> criticas;

    public CriticaListDto() {
    }

    public CriticaListDto(ArrayList<CriticaDto> criticas) {
        this.criticas = criticas;
    }

    public ArrayList<CriticaDto> getCriticas() {
        return criticas;
    }

    public void setCriticas(ArrayList<CriticaDto> criticas) {
        this.criticas = criticas;
    }
}
