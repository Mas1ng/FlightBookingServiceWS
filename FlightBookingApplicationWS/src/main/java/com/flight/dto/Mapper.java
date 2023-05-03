package com.flight.dto;

import com.flight.model.*;

import java.util.ArrayList;

public class Mapper {
    public static ClienteDto cliente2ClienteDto(Cliente args){
        DataDto data = date2DateDto(args.getData());
        ClienteDto obj = new ClienteDto(args.getEmail(), args.getNome(), data);
        return obj;
    }

    public static BilheteDto bilhete2BilheteDto(Bilhete args){
        ExtrasDto extrasDto = extra2ExtraDto(args.getExtras());
        BilheteDto obj = new BilheteDto(args.getNumLugar(), args.getNomeViagem(), extrasDto, args.getTipoPassageiro());
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

    /*public static PessoaListDto pessoaList2PessoaListDto(ArrayList<Pessoa> arg) {

    }*/

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

    public static Data dataDto2Data(DataDto arg){
        Data  obj = new Data(arg.getDia(),arg.getMes(),arg.getAno());
        return obj;
    }

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

    public static Extras extrasDto2Extra ( ExtrasDto arg)
    {
        Extras obj = new Extras(arg.getPreco(), arg.getTipoLugar(), arg.isComida(), arg.isSeguro(), arg.getMala());
        return obj;
    }
    public static ExtrasDto extra2ExtraDto( Extras arg)
    {
        ExtrasDto obj = new ExtrasDto(arg.getPreco(), arg.getTipoLugar(), arg.isSeguro(),arg.isComida(),arg.getMala());
        return obj;
    }
    public static Bilhete bilheteDto2Bilhete(BilheteDto arg) {
        Extras extra = extrasDto2Extra(arg.getExtrasDto());
        Bilhete  b = new Bilhete(arg.getNumLugar(), arg.getNomeViagem(), extra, arg.getTipoPassageiro());
        return b;
    }

    public static BilheteList clienteBilheteListDto2ClienteBilheteList(ClienteBilhetesDto arg) {
        ArrayList<Bilhete> lista = new ArrayList<>();
        for(int i=0;i<arg.getBilhetes().size();i++) {
            Bilhete b = bilheteDto2Bilhete(arg.getBilhetes().get(i));
            lista.add(b);
        }
        BilheteList obj = new BilheteList(lista);
        return obj;
    }
}
