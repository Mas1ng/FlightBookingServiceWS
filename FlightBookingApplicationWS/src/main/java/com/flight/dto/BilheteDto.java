package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flight.model.Extras;
import com.flight.model.TipoPassageiro;

@JsonPropertyOrder({"numLugar","nomeViagem","extras","tipoPassageiro"})
@JacksonXmlRootElement(localName = "bilhete")
public class BilheteDto {

    @JacksonXmlProperty(localName="numLugar")
    private int numLugar;
    @JacksonXmlProperty(localName="nomeViagem")
    private String nomeViagem;
    @JacksonXmlProperty(localName="extras")
    private Extras extras;
    @JacksonXmlProperty(localName="tipoPassageiro")
    private TipoPassageiro tipoPassageiro;

    public BilheteDto() {
    }

    public BilheteDto(int numLugar, String nomeViagem, Extras extras, TipoPassageiro tipoPassageiro) {
        this.numLugar = numLugar;
        this.nomeViagem = nomeViagem;
        this.extras = extras;
        this.tipoPassageiro = tipoPassageiro;
    }

    public int getNumLugar() {
        return numLugar;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }

    public Extras getExtras() {
        return extras;
    }

    public TipoPassageiro getTipoPassageiro() {
        return tipoPassageiro;
    }
}
