package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.flight.model.Companhia;


@JsonPropertyOrder({"lugaresTotais", "companhia", "cidadeInicial","cidadeFinal", "dataPartida", "dataChegada","horarioPartida","horarioChegada", "lugaresEconomicos", "lugaresExecutivos", "lugaresPrimeiraClasse"} )
@JacksonXmlRootElement(localName = "viagem")
public class ViagemDto {
    @JacksonXmlProperty(localName = "nomeViagem")
    private String nomeViagem;
    @JacksonXmlProperty(localName = "lugaresTotais")
    private int LugaresTotais;
    @JacksonXmlProperty(localName = "companhia")
    private Companhia companhia;
    @JacksonXmlProperty(localName = "cidadeFinal")
    private String cidadeFinal;
    @JacksonXmlProperty(localName = "cidadeInicial")
    private String cidadeInicial;
    @JacksonXmlProperty(localName = "dataPartida")
    private DataDto dataPartida;
    @JacksonXmlProperty(localName = "dataChegada")
    private DataDto dataChegada;

    @JacksonXmlProperty(localName = "horarioPartida")
    private HorarioDto horarioPartida;
    @JacksonXmlProperty(localName = "horarioChegada")
    private HorarioDto horarioChegada;
    @JacksonXmlProperty(localName = "lugaresEconomicos")
    private int lugaresEconomicos;
    @JacksonXmlProperty(localName = "lugaresExecutivos")
    private int lugaresExecutivos;
    @JacksonXmlProperty(localName = "lugaresPrimeiraClasse")
    private int lugaresPrimeiraClasse;

    public ViagemDto() {
    }

    public ViagemDto(Companhia companhia, DataDto dataPartida, DataDto dataChegada) {
        this.companhia = companhia;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
    }

    public ViagemDto(String nomeViagem, int lugaresTotais, Companhia companhia, String cidadeInicial, String cidadeFinal, DataDto dataPartida, DataDto dataChegada, HorarioDto horarioPartida,HorarioDto horarioChegada, int lugaresEconomicos, int lugaresExecutivos, int lugaresPrimeiraClasse) {
        this.nomeViagem=nomeViagem;
        this.LugaresTotais = lugaresTotais;
        this.companhia = companhia;
        this.cidadeFinal = cidadeFinal;
        this.cidadeInicial = cidadeInicial;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
        this.horarioPartida=horarioPartida;
        this.horarioChegada=horarioChegada;
        this.lugaresEconomicos = lugaresEconomicos;
        this.lugaresExecutivos = lugaresExecutivos;
        this.lugaresPrimeiraClasse = lugaresPrimeiraClasse;
    }

    public int getLugaresTotais() {
        return LugaresTotais;
    }
    public Companhia getCompanhia() {
        return companhia;
    }
    public String getCidadeFinal() {
        return cidadeFinal;
    }
    public String getCidadeInicial() {
        return cidadeInicial;
    }
    public DataDto getDataPartida() {
        return dataPartida;
    }
    public DataDto getDataChegada() {
        return dataChegada;
    }

    public HorarioDto getHorarioPartida() {
        return horarioPartida;
    }

    public HorarioDto getHorarioChegada() {
        return horarioChegada;
    }

    public int getLugaresEconomicos() {
        return lugaresEconomicos;
    }
    public int getLugaresExecutivos() {
        return lugaresExecutivos;
    }
    public int getLugaresPrimeiraClasse() {
        return lugaresPrimeiraClasse;
    }
}
