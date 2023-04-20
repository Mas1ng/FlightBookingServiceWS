package com.flight.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"n", "name"})
@JacksonXmlRootElement(localName = "student")
public class ClienteListItemDto {
}
