package com.flight.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName="bilhetes")
public class BilheteListDto {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "bilhete")
    private ArrayList<BilheteDto> bilhetes;

    public BilheteListDto(ArrayList<BilheteDto> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public ArrayList<BilheteDto> getBilhetes() {
        return bilhetes;
    }
}
