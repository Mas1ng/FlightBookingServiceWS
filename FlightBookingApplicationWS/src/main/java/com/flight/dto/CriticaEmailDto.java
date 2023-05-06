package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"emailCliente","critica"})
@JacksonXmlRootElement(localName = "id")

public class CriticaEmailDto {
    @JacksonXmlProperty(localName="emailCliente")
    private String emailCliente;
    @JacksonXmlProperty(localName="critica")
    private CriticaDto criticaNova;

    public CriticaEmailDto() {
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public CriticaDto getCriticaNova() {
        return criticaNova;
    }

    public void setCriticaNova(CriticaDto criticaNova) {
        this.criticaNova = criticaNova;
    }
}

