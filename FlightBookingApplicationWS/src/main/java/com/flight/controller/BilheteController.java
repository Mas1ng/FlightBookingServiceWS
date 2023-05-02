package com.flight.controller;

import com.flight.dto.BilheteDto;
import com.flight.dto.BilheteListDto;
import com.flight.dto.ErrorDto;
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
            BilheteListDto result = BilheteService.getBilhetes();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);

        }
   }
    @GetMapping(value = "/bilhetes/{nomeViagem}",
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getStudent(@PathVariable("nomeViagem") String nomeViagem, @RequestBody int numlugar) {
        try {
            BilheteDto result = BilheteService.getBilhete(nomeViagem, numlugar);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/bilhetes",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addBilhete(@RequestBody BilheteDto arg) {
        try {
            BilheteService.addBilhete(arg);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/bilhetes/{viagem}",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateStudent(@PathVariable("nomeViagem")String nomeViagem, @RequestBody int numlugar, BilheteDto arg) {
        try {
            BilheteService.updateBilhete(nomeViagem, numlugar, arg);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/bilhetes/{bilhete}",
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeStudent(@PathVariable("nomeViagem")String nomeViagem, @RequestBody int numlugar) {
        try {
            BilheteService.removeBilhete(nomeViagem, numlugar);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
}
