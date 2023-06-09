package com.flight.controller;

import com.flight.dto.*;
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
    @GetMapping(value = "/clientes/{email}",
        produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getCliente(@PathVariable("email") String email) {
        try {
            ClienteDto result = ClienteService.getCliente(email);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
    @PostMapping(value = "/clientes",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addCliente(@RequestBody ClienteDto arg) {
        try {
            ClienteService.addCliente(arg);
            return new ResponseEntity<>("Sucesso: O cliente "+arg.getEmail()+" foi criado",HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
    @PutMapping(value = "/clientes/{email}",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateCliente(@PathVariable("email") String email, @RequestBody ClienteDto arg) {
        try {
            ClienteService.updateCliente(arg,email);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
    @PutMapping(value = "/clientes",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateCliente(@RequestBody ClienteBilhetesDto arg) {
        try {
            //ClienteService.updateClienteBilhetes(arg);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/clientes/{email}",
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeCliente(@PathVariable("email") String email) {
        try {
            ClienteService.removeCliente(email);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
}
