package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flight.model.TipoBilhete;
import com.flight.model.TipoPassageiro;

@JsonPropertyOrder({"numLugar","nomeViagem","extras","tipoPassageiro","tipoBilhete","cc","preco"})
@JacksonXmlRootElement(localName = "bilhete")
public class BilheteNumLugarDto {

    @JacksonXmlProperty(localName="numLugar")
    private int numLugar;
    @JacksonXmlProperty(localName="nomeViagem")
    private String nomeViagem;
    @JacksonXmlProperty(localName="extras")
    private ExtrasDto extras;
    @JacksonXmlProperty(localName="tipoPassageiro")
    private TipoPassageiro tipoPassageiro;
    @JacksonXmlProperty(localName="tipoBilhete")
    private TipoBilhete tipoBilhete;
    @JacksonXmlProperty(localName="cc")
    private String cc;
    @JacksonXmlProperty(localName="preco")
    private int preco;


    public BilheteNumLugarDto() {
    }

    public BilheteNumLugarDto(int numLugar, String nomeViagem, ExtrasDto extras, TipoPassageiro tipoPassageiro, TipoBilhete tipoBilhete, String cc,int preco) {
        this.numLugar=numLugar;
        this.nomeViagem = nomeViagem;
        this.extras = extras;
        this.tipoPassageiro = tipoPassageiro;
        this.tipoBilhete = tipoBilhete;
        this.cc=cc;
        this.preco=preco;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }

    public int getNumLugar() {
        return numLugar;
    }

    public ExtrasDto getExtrasDto() {
        return extras;
    }

    public TipoPassageiro getTipoPassageiro() {
        return tipoPassageiro;
    }

    public TipoBilhete getTipoBilhete() {
        return tipoBilhete;
    }

    public String getCc() {
        return cc;
    }

    public int getPreco() {
        return preco;
    }
}
