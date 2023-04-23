package com.flight.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flight.model.ClienteList;

import java.util.ArrayList;

@JacksonXmlRootElement(localName="Clientes")
public class ClienteListDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "clientes")
    private ArrayList<ClienteListItemDto> clientes;

    public ClienteListDto(ArrayList<ClienteListItemDto> clientes) {
        this.clientes = clientes;
    }
}
