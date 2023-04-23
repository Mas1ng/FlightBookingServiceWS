package com.flight.service;

import com.flight.dto.ClienteDto;
import com.flight.dto.ClienteListDto;
import com.flight.dto.ClienteListItemDto;
import com.flight.dto.Mapper;
import com.flight.model.Cliente;
import com.flight.model.Email;
import com.flight.model.FBS;
import com.flight.repository.FilesOperation;
import org.springframework.web.servlet.tags.ArgumentAware;

import java.util.ArrayList;

public class ClienteService {

    public static ClienteListDto getClientes() {
      FBS fbs  = FilesOperation.loadFBS();
      ArrayList<Cliente> lista = fbs.getClienteList().getAll();
      ClienteListDto result = Mapper.clienteList2ClienteListDto(lista);
      return result;
    }
    /*public static ClienteDto getCliente(Email email) {
        FBS fbs = FilesOperation.loadFBS();
        Cliente item = fbs.getClienteList().getClienteByEmail(email);
        ClienteDto resutl = Mapper.cliente2ClienteDto(item);
    }*/

    public static void addCliente(ClienteDto arg) {
        FBS fbs = FilesOperation.loadFBS();
        Cliente item = Mapper.
    }
}
