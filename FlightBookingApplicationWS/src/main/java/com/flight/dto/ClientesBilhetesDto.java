package com.flight.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName="clientes")
public class ClientesBilhetesDto {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "cliente")
    private ArrayList<ClienteBilhetesDto> clientes;

    public ClientesBilhetesDto(ArrayList<ClienteBilhetesDto> clientes) {
        this.clientes = clientes;
    }

    public ClientesBilhetesDto() {
    }

    public ArrayList<ClienteBilhetesDto> getClientes() {
        return clientes;
    }
}
