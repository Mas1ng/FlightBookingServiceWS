package com.flight.controller;

import com.flight.dto.ErrorDto;
import com.flight.dto.ViagemDto;
import com.flight.dto.ViagemListDto;
import com.flight.service.ViagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ViagemController {
    @GetMapping(value = "/viagens" , produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getViagens(){
        try{
            ViagemListDto result = ViagemService.getViagens();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);

        }
    }
    @GetMapping(value = "/viagens/{nomeViagem}",
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getViagem(@PathVariable("nomeViagem") String nomeViagem) {
        try {
            ViagemDto result = ViagemService.getViagem(nomeViagem);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/viagens",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addViagem(@RequestBody ViagemDto arg) {
        try {
            ViagemService.addViagem(arg);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/viagens/{nomeViagem}",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateStudent(@PathVariable("nomeViagem")String nomeViagem, @RequestBody ViagemDto arg) {
        try {
            ViagemService.updateViagem(nomeViagem, arg);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/viagens/{nomeViagem}",
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeViagem(@PathVariable("nomeViagem")String nomeViagem) {
        try {
            ViagemService.removeViagem(nomeViagem);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
}
