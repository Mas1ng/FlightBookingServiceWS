package com.flight.controller;

import com.flight.dto.ClienteListDto;
import com.flight.dto.ErrorDto;
import com.flight.dto.PessoaDto;
import com.flight.dto.PessoaListDto;
import com.flight.model.PessoaList;
import com.flight.service.ClienteService;
import com.flight.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PessoaController {
    @PostMapping(value = "/pessoas",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addPessoa(@RequestBody PessoaDto arg) {
        try {
            PessoaService.addPessoa(arg);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
    @GetMapping(value = "/pessoas",
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getPessoas() {
        try {
            PessoaListDto result = PessoaService.getPessoas();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
    @GetMapping(value = "/pessoas/{cc}",
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getPessoa(@PathVariable("cc") long cc) {
        try {
            PessoaDto result = PessoaService.getPessoa(cc);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/pessoas/{CC}",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updatePessoa(@PathVariable("CC")long CC, @RequestBody PessoaDto arg) {
        try {
            PessoaService.updatePessoa(arg,CC);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/pessoas/{CC}",
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removePessoa(@PathVariable("CC")long cc) {
        try {
           PessoaService.removePessoa(cc);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
}
