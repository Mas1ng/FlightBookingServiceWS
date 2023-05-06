package com.flight.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName="pessoas")
public class PessoaListDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "pessoas")
    private ArrayList<PessoaDto> pessoas;

    public PessoaListDto() {
    }
    public PessoaListDto(ArrayList<PessoaDto> pessoas) {
        this.pessoas = pessoas;
    }
}
