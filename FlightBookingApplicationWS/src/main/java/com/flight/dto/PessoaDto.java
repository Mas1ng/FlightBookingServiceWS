package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JsonPropertyOrder({"nome","data","cc"})
@JacksonXmlRootElement(localName="pessoas")
public class PessoaDto {
    @JacksonXmlProperty(localName = "nome")
    private String nome;

    @JacksonXmlProperty(localName = "data")
    private DataDto data;
    @JacksonXmlProperty(localName = "cc")
    private long cc;

    public PessoaDto(String nome, DataDto data, long cc) {
        this.nome = nome;
        this.data = data;
        this.cc = cc;
    }
    public PessoaDto() {
    }

    public String getNome() {
        return nome;
    }

    public DataDto getData() {
        return data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(DataDto data) {
        this.data = data;
    }

    public long getCc() {
        return cc;
    }

    public void setCc(long cc) {
        this.cc = cc;
    }
}
