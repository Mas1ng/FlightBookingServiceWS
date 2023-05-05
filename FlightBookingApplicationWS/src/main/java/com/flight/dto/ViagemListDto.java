package com.flight.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;

public class ViagemListDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "viagem")
    private ArrayList<ViagemDto> viagens;

    public ViagemListDto() {
    }

    public ViagemListDto(ArrayList<ViagemDto> viagens) {
        this.viagens = viagens;
    }

    public ArrayList<ViagemDto> getViagens() {
        return viagens;
    }

    public void setViagens(ArrayList<ViagemDto> viagens) {
        this.viagens = viagens;
    }
}
