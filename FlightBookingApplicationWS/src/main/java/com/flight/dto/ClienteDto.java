package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flight.model.BilheteList;
import com.flight.model.Cliente;
import com.flight.model.Data;
import com.flight.model.Email;

import java.io.Serializable;

@JsonPropertyOrder({"nome","data","email"})
@JacksonXmlRootElement(localName="Cliente")
public class ClienteDto implements Serializable {
    @JacksonXmlProperty(localName = "bilhetes")
    private BilheteList bilheteList;

    @JacksonXmlProperty(localName = "email")
    private Email email;

    @JacksonXmlProperty(localName = "nome")
    private String nome;

    @JacksonXmlProperty(localName = "data")
    private DataDto data;

    public ClienteDto(Email email, String nome, DataDto data) {
        //this.bilheteList = bilheteList;
        this.email = email;
        this.nome = nome;
        this.data = data;
    }

    public Email getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public DataDto getData() {
        return data;
    }
}
