package com.flight.controller;

import com.flight.dto.*;
import com.flight.service.CriticaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CriticaController {
    @GetMapping(value = "/criticas",
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getCriticas() {
        try {
            CriticaListDto result = CriticaService.getCriticas();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
    @GetMapping(value = "/critica",
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getCritica(@RequestBody NomeViagemEmailDto x ) {
        try {
            CriticaDto result = CriticaService.getCritica(x);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
    @PostMapping(value = "/criticas",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addCritica(@RequestBody CriticaDto arg) {
        try {
            CriticaService.addCritica(arg);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
    @PutMapping(value = "/criticas/{nomeViagem}",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateCritica(@PathVariable("nomeViagem")String nomeViagem,@RequestBody CriticaEmailDto c ) {
        try {
            CriticaService.updateCritica(nomeViagem,c);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping(value = "/criticas",
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeCritica( @RequestBody NomeViagemEmailDto x ) {
        try {
            CriticaService.removeCritica(x);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
}

