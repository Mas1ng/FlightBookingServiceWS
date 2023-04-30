package com.flight.dto;

import com.flight.model.Bilhete;
import com.flight.model.Cliente;
import com.flight.model.Data;
import com.flight.model.Email;

import java.util.ArrayList;

public class Mapper {
    public static ClienteDto cliente2ClienteDto(Cliente args){
        DataDto data = null;
        if (args.getData() != null) {
            data = date2DateDto(args.getData());
        }
        ClienteDto obj = new ClienteDto(args.getEmail(), args.getNome(), data);
        return obj;
    }

    public static BilheteDto bilhete2BilheteDto(Bilhete args){
        BilheteDto obj = new BilheteDto(args.getNumLugar(), args.getNomeViagem(), args.getExtras(), args.getTipoPassageiro());
        return obj;
    }

    public static ClienteListDto clienteList2ClienteListDto(ArrayList<Cliente> arg) {
        ArrayList<ClienteDto> lista = new ArrayList<>();
        for(Cliente cliente : arg) {
            ClienteDto item = cliente2ClienteDto(cliente);
            lista.add(item);
        }
        ClienteListDto obj = new ClienteListDto(lista);
        return obj;
    }

    public static BilheteListDto bilheteList2BilheteListDto(ArrayList<Bilhete> arg) {
        ArrayList<BilheteDto> lista = new ArrayList<>();
        for(Bilhete bilhete : arg) {
            BilheteDto item = bilhete2BilheteDto(bilhete);
            lista.add(item);
        }
        BilheteListDto obj = new BilheteListDto(lista);
        return obj;
    }

    public static DataDto date2DateDto(Data arg){
        if (arg == null) {
            return null;
        }
        int [] dmy = {0,0,0};
        arg.getDate(dmy);
        DataDto  obj = new DataDto(dmy[0],dmy[1],dmy[2]);
        return obj;
    }

    /*public static EmailDto email2EmailDto(Email arg){
        String email = arg.getEmail();
        EmailDto obj = new EmailDto(email);
        return obj;
    }*/
    public static Data dataDto2Data(DataDto arg){
        Data  obj = new Data(arg.getDia(),arg.getMes(),arg.getAno());
        return obj;
    }

    /*
    public static Email emailDto2Email(EmailDto arg) {
        Email obj = new Email(arg.getEmail());
        return obj;
    }*/

    public static Cliente clienteDto2Cliente(ClienteDto arg){
        Data date = dataDto2Data(arg.getData());
        //Email email = emailDto2Email(arg.getEmail());
        Cliente  obj = new Cliente(arg.getEmail(),arg.getNome(),date);
        return obj;
    }
    /*public static Bilhete bilheteDto2Bilhete(BilheteDto arg) {
        Cliente  obj = new Cliente(arg.getExtras(),arg.getNomeViagem());
        return obj;
    }*/
}
