package com.flight.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flight.model.Email;

@JsonPropertyOrder({"email","nome"})
@JacksonXmlRootElement(localName="cliente")
public class ClienteListItemDto {
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "email")
    private Email email;

    public ClienteListItemDto(Email email, String nome) {
        this.email = email;
        this.nome = nome;
    }
}
