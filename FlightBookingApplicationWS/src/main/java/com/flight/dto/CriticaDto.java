package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"emailCliente","data","avaliacao","textocritica", "assunto", "nomeViagem"})
@JacksonXmlRootElement(localName = "critica")
public class CriticaDto {
    @JacksonXmlProperty(localName="emailCliente")
    private String emailCliente;
    @JacksonXmlProperty(localName="data")
    private DataDto datacritica;
    @JacksonXmlProperty(localName="avaliacao")
    private String avaliacao;
    @JacksonXmlProperty(localName="textocritica")
    private String textocritica;
    @JacksonXmlProperty(localName="assunto")
    private String assunto;
    @JacksonXmlProperty(localName="nomeViagem")
    private String nomeViagem;

    public CriticaDto() {
    }

    public CriticaDto(String emailCliente, DataDto datacritica, String avaliacao, String textocritica, String assunto, String nomeViagem) {
        this.emailCliente = emailCliente;
        this.datacritica = datacritica;
        this.avaliacao = avaliacao;
        this.textocritica = textocritica;
        this.assunto = assunto;
        this.nomeViagem = nomeViagem;

    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public DataDto getDatacritica() {

        return datacritica;
    }

    public void setDatacritica(DataDto datacritica) {
        this.datacritica = datacritica;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getTextocritica() {
        return textocritica;
    }

    public void setTextocritica(String textocritica) {
        this.textocritica = textocritica;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }

    public void setNomeViagem(String nomeViagem) {
        this.nomeViagem = nomeViagem;
    }
}
