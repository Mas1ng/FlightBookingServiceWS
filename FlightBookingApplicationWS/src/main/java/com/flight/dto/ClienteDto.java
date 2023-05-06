package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flight.model.BilheteList;


@JsonPropertyOrder({"email","nome","data","cc"})
@JacksonXmlRootElement(localName="cliente")
public class ClienteDto {

    @JacksonXmlProperty(localName = "bilhete")
    private BilheteListDto bilheteList;

    @JacksonXmlProperty(localName = "email")
    private String email;

    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "data")
    private DataDto data;
    @JacksonXmlProperty(localName = "cc")
    private long cc;

    public ClienteDto(String email, String nome, DataDto data, long cc) {
        this.email = email;
        this.nome = nome;
        this.data = data;
        this.cc=cc;

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

    public long getCc() {
        return cc;
    }
}
