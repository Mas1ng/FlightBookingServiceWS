package com.flight.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName="clientes")
public class ClienteListDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "cliente")
    private ArrayList<ClienteDto> clientes;

    public ClienteListDto() {
    }
    public ClienteListDto(ArrayList<ClienteDto> clientes) {
        this.clientes = clientes;
    }
}
