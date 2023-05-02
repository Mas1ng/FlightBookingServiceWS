/*package com.flight.service;

import com.flight.dto.ClienteDto;
import com.flight.dto.ClienteListDto;
import com.flight.dto.Mapper;
import com.flight.model.Cliente;
import com.flight.model.FBS;
import com.flight.model.Pessoa;

import com.flight.repository.FilesOperation;

import java.util.ArrayList;

public class PessoaService {
    public static ClienteListDto getPessoas() {
        FBS fbs  = FilesOperation.loadFBS();
        ArrayList<Pessoa> lista = fbs.getPessoaList();
        ClienteListDto result = Mapper.clienteList2ClienteListDto(lista);
        return result;
    }

    public static ClienteDto getCliente(String email) {
        FBS fbs = FilesOperation.loadFBS();
        Cliente item = fbs.getClienteList().getClienteByEmail(email);
        ClienteDto result = Mapper.cliente2ClienteDto(item);
        return result;
    }

    public static void addCliente(ClienteDto arg) {
        FBS fbs = FilesOperation.loadFBS();
        Cliente item = Mapper.clienteDto2Cliente(arg);
        fbs.getClienteList().addCliente(item);
        FilesOperation.storeFBS(fbs);
    }
}*/
