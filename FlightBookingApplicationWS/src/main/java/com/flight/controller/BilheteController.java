package com.flight.controller;

import com.flight.dto.*;
import com.flight.service.BilheteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BilheteController {
    @GetMapping(value = "/bilhetes" , produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getBilhetes(){
        try{
            ClientesBilhetesNumLugarDto result = BilheteService.getAllBilhetes();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);

        }
    }
   @GetMapping(value = "/bilhetes/{email}" , produces = MediaType.APPLICATION_XML_VALUE)
        public ResponseEntity<Object> getBilhetes(@PathVariable("email") String email){
        try{
            BilheteListNumLugarDto result = BilheteService.getBilhetesFromCliente(email);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);

        }
   }
    @PostMapping(value = "/bilhetes",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addBilhete(@RequestBody ClienteBilhetesDto arg) {
        try {
            BilheteService.addBilheteListToCliente(arg);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    /*@PutMapping(value = "/bilhetes/{viagem}",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateStudent(@PathVariable("nomeViagem")String nomeViagem, @RequestBody int numlugar, BilheteDto arg) {
        try {
            BilheteService.update(nomeViagem, numlugar, arg);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }*/

    @DeleteMapping(value = "/bilhetes/{email}",
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeStudent(@PathVariable("email")String email, @RequestBody NumLugarNomeViagemDto arg) {
        try {
            BilheteService.removeBilhete(email, arg);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
}
