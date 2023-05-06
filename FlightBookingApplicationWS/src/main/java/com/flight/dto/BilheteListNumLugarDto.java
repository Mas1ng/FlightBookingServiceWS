package com.flight.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName="bilhetes")
public class BilheteListNumLugarDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "bilhete")
    private ArrayList<BilheteNumLugarDto> bilhetes;

    public BilheteListNumLugarDto(ArrayList<BilheteNumLugarDto> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public ArrayList<BilheteNumLugarDto> getBilhetes() {
        return bilhetes;
    }
}
