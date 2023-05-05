package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flight.model.Extras;
import com.flight.model.TipoBilhete;
import com.flight.model.TipoPassageiro;

@JsonPropertyOrder({"numLugar","nomeViagem","extras","tipoPassageiro","tipoBilhete"})
@JacksonXmlRootElement(localName = "bilhete")
public class BilheteDto {

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


    public BilheteDto() {
    }

    public BilheteDto(int numLugar, String nomeViagem, ExtrasDto extras, TipoPassageiro tipoPassageiro, TipoBilhete tipoBilhete) {
        this.numLugar = numLugar;
        this.nomeViagem = nomeViagem;
        this.extras = extras;
        this.tipoPassageiro = tipoPassageiro;
        this.tipoBilhete = tipoBilhete;
    }

    public int getNumLugar() {
        return numLugar;
    }

    public String getNomeViagem() {
        return nomeViagem;
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
}
