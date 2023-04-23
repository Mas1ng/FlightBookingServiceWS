package com.flight.controller;

import com.flight.dto.ClienteDto;
import com.flight.dto.ClienteListDto;
import com.flight.dto.ErrorDto;
import com.flight.model.Email;
import com.flight.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @GetMapping(value = "/clientes",
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getClientes() {
        try {
            ClienteListDto result = ClienteService.getClientes();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
    /*@GetMapping(value = "/clientes/{email}",
        produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getClientes(@PathVariable("email") Email email) {
        try {
            ClienteDto result = ClienteService.getClientes()
        }
    }*/
    @PostMapping(value = "/clientes",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addCliente(@RequestBody ClienteDto arg) {
        try {
            ClienteService.addStudent(arg);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
}
