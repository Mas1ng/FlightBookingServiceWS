package com.flight.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;

public class ViagemListDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "viagem")
    private ArrayList<ViagemListDto> viagens;

    public ViagemListDto() {
    }

    public ViagemListDto(ArrayList<ViagemListDto> viagens) {
        this.viagens = viagens;
    }

    public ArrayList<ViagemListDto> getViagens() {
        return viagens;
    }

    public void setViagens(ArrayList<ViagemListDto> viagens) {
        this.viagens = viagens;
    }
}
