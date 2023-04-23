package com.flight.dto;

import com.flight.model.Bilhete;
import com.flight.model.Cliente;
import com.flight.model.Data;

import java.util.ArrayList;

public class Mapper {
    public static ClienteListItemDto cliente2ClienteListItemDto(Cliente args){
        ClienteListItemDto obj = new ClienteListItemDto(args.getEmail(), args.getNome());
        return obj;
    }
    public static ClienteListDto clienteList2ClienteListDto(ArrayList<Cliente> arg) {
        ArrayList<ClienteListItemDto> lista = new ArrayList<>();
        for(Cliente cliente : arg) {
            ClienteListItemDto item = cliente2ClienteListItemDto(cliente);
            lista.add(item);
        }
        ClienteListDto obj = new ClienteListDto(lista);
        return obj;
    }

    public static DataDto date2DateDto(Data arg){
        int [] dmy = {0,0,0};
        arg.getDate(dmy);
        DataDto  obj = new DataDto(dmy[0],dmy[1],dmy[2]);
        return obj;
    }
    public static Data dataDto2Data(DataDto arg){
        Data  obj = new Data(arg.getDia(),arg.getMes(),arg.getAno());
        return obj;
    }

    public static Cliente clienteDto2Cliente(ClienteDto arg){
        Data date = dataDto2Data(arg.getData());
        Cliente  obj = new Cliente(arg.getEmail());
        return obj;
    }



    /*public static ClienteDto cliente2ClienteDto(Cliente arg) {
        //BilheteDto bilheteDto = bilhete2BilheteDto(arg.getBilhetes())
        DataDto dataDto = data2DataDto(arg.getData());
        ClienteDto obj = new ClienteDto(arg.getBilhetes(),arg.getEmail(),arg.getNome(),arg.getData());
        return obj;
    }*/
}
