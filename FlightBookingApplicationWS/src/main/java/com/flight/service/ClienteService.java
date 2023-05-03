package com.flight.service;

import com.flight.dto.ClienteBilhetesDto;
import com.flight.dto.ClienteDto;
import com.flight.dto.ClienteListDto;
import com.flight.dto.Mapper;
import com.flight.model.BilheteList;
import com.flight.model.Cliente;
import com.flight.model.Data;
import com.flight.model.FBS;
import com.flight.repository.FilesOperation;

import java.util.ArrayList;

public class ClienteService {

    public static ClienteListDto getClientes() {
      FBS fbs  = FilesOperation.loadFBS();
      ArrayList<Cliente> lista = fbs.getClienteList().getAll();
      ClienteListDto result = Mapper.clienteList2ClienteListDto(lista);
      return result;
    }

    public static ClienteDto getCliente(String email) {
        FBS fbs = FilesOperation.loadFBS();
        System.out.println(fbs.getClienteList().getAll());
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
    public static void updateCliente(ClienteDto arg, String email){
        FBS fbs = FilesOperation.loadFBS();
        Data data = Mapper.dataDto2Data(arg.getData());
        fbs.getClienteList().update(email, arg.getNome(),data,arg.getEmail());
        FilesOperation.storeFBS(fbs);
    }
    public static void updateClienteBilhetes(ClienteBilhetesDto arg, String email){
        FBS fbs = FilesOperation.loadFBS();
        BilheteList item = Mapper.clienteBilheteListDto2ClienteBilheteList(arg);
        fbs.getClienteList().updateBilhete(item, email);
        FilesOperation.storeFBS(fbs);
    }
    public static void removeCliente(String email){
        FBS fbs = FilesOperation.loadFBS();
        fbs.getClienteList().remove(email);
        FilesOperation.storeFBS(fbs);
    }
}
