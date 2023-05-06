package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JsonPropertyOrder({"email", "bilhetes"})
@JacksonXmlRootElement(localName = "clienteBilhete")
public class ClienteBilhetesNumLugarDto {
    @JacksonXmlProperty(localName = "email")
    private String email;
    @JacksonXmlProperty(localName = "bilhetes")
    private ArrayList<BilheteNumLugarDto> bilhetes;

    public ClienteBilhetesNumLugarDto(String email, ArrayList<BilheteNumLugarDto> bilhetes) {
        this.email = email;
        this.bilhetes = bilhetes;
    }
}
