package com.flight.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "students")
public class ClienteListDto {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "student")
    private ArrayList<ClienteListItemDto> students;

    public StudentListDto() {
    }

    public StudentListDto(ArrayList<StudentListItemDto> students) {
        this.students = students;
    }

    public ArrayList<StudentListItemDto> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<StudentListItemDto> students) {
        this.students = students;
    }
}