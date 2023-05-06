package com.flight.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName="clientes")
public class ClientesBilhetesNumLugarDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "cliente")
    private ArrayList<ClienteBilhetesNumLugarDto> clientes;

    public ClientesBilhetesNumLugarDto(ArrayList<ClienteBilhetesNumLugarDto> clientes) {
        this.clientes = clientes;
    }

    public ClientesBilhetesNumLugarDto() {
    }

    public ArrayList<ClienteBilhetesNumLugarDto> getClientes() {
        return clientes;
    }
}
