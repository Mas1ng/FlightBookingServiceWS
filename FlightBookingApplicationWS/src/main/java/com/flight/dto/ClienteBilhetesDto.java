package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JsonPropertyOrder({"email", "bilhetes"})
@JacksonXmlRootElement(localName = "cliente")
public class ClienteBilhetesDto {

    @JacksonXmlProperty(localName = "email")
    private String email;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "bilhetes")
    private ArrayList<BilheteDto> bilhetes;

    public ClienteBilhetesDto(String email, ArrayList<BilheteDto> bilhetes) {
        this.email = email;
        this.bilhetes = bilhetes;
    }

    public ClienteBilhetesDto() {
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<BilheteDto> getBilhetes() {
        return bilhetes;
    }
}
