package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flight.model.BilheteList;
import com.flight.model.Cliente;
import com.flight.model.Data;
import com.flight.model.Email;

import java.io.Serializable;

@JsonPropertyOrder({"email","nome","data"})
@JacksonXmlRootElement(localName="clientes")
public class ClienteDto implements Serializable {
    @JacksonXmlProperty(localName = "bilhete")
    private BilheteList bilheteList;

    @JacksonXmlProperty(localName = "email")
    private String email;

    @JacksonXmlProperty(localName = "nome")
    private String nome;

    @JacksonXmlProperty(localName = "data")
    private DataDto data;

    public ClienteDto(String email, String nome, DataDto data) {
        this.email = email;
        this.nome = nome;
        this.data = data;
    }

    public ClienteDto() {
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public DataDto getData() {
        return data;
    }
}
