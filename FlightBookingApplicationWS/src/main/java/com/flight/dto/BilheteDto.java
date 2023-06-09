package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flight.model.Extras;
import com.flight.model.TipoBilhete;
import com.flight.model.TipoPassageiro;

@JsonPropertyOrder({"nomeViagem","extras","tipoPassageiro","tipoBilhete","cc"})
@JacksonXmlRootElement(localName = "bilhete")
public class BilheteDto {

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


    public BilheteDto() {
    }

    public BilheteDto(String nomeViagem, ExtrasDto extras, TipoPassageiro tipoPassageiro, TipoBilhete tipoBilhete, String cc) {
        this.nomeViagem = nomeViagem;
        this.extras = extras;
        this.tipoPassageiro = tipoPassageiro;
        this.tipoBilhete = tipoBilhete;
        this.cc=cc;
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

    public String getCc() {
        return cc;
    }
}
