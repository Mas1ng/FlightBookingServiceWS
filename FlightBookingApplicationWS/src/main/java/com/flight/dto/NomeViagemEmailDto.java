package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"nomeViagem","email"})
@JacksonXmlRootElement(localName="id")
public class NomeViagemEmailDto {
    @JacksonXmlProperty(localName="nomeViagem")
    private String nomeViagem;
    @JacksonXmlProperty(localName="email")
    private String email;

    public NomeViagemEmailDto() {
    }

    public String getNomeViagem() {
        return nomeViagem;
    }

    public void setNomeViagem(String nomeViagem) {
        this.nomeViagem = nomeViagem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
