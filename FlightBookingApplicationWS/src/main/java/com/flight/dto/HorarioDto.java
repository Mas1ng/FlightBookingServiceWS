package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"hora","minuto"})
@JacksonXmlRootElement(localName = "horario")
public class HorarioDto {
    @JacksonXmlProperty(localName="hora")
    private int hora;
    @JacksonXmlProperty(localName="minuto")
    private int minuto;

    public HorarioDto(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public HorarioDto() {
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }
}
