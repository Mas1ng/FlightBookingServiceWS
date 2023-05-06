package com.flight.dto;

import com.flight.model.*;
import com.flight.repository.FilesOperation;

import java.util.ArrayList;

public class Mapper {
    public static ClienteDto cliente2ClienteDto(Cliente args){
        DataDto data = data2DataDto(args.getData());
        ClienteDto obj = new ClienteDto(args.getEmail(), args.getNome(), data, args.getCc());
        return obj;
    }

    public static BilheteDto bilhete2BilheteDto(Bilhete args){
        ExtrasDto extrasDto = extra2ExtraDto(args.getExtras());
        BilheteDto obj = new BilheteDto(args.getNomeViagem(), extrasDto, args.getTipoPassageiro(),args.getTipoBilhete(), args.getCc());
        return obj;
    }

    public static BilheteNumLugarDto bilhete2BilheteNumLugarDto(Bilhete args){
        ExtrasDto extrasDto = extra2ExtraDto(args.getExtras());
        BilheteNumLugarDto obj = new BilheteNumLugarDto(args.getNumLugar(), args.getNomeViagem(), extrasDto, args.getTipoPassageiro(),args.getTipoBilhete(), args.getCc(),args.getPreco());
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

    public static ClientesBilhetesNumLugarDto clientesBilheteList2ClientesBilheteNumLugarListDto(ArrayList<Cliente> arg) {
        ArrayList<ClienteBilhetesNumLugarDto> lista = new ArrayList<>();
        for(Cliente cliente : arg) {
            BilheteListNumLugarDto bilheteListNumLugarDto = Mapper.bilheteList2BilheteNumLugarListDto(cliente.getBilhetes().getAll());
            ArrayList<BilheteNumLugarDto> arraybilheteListDto = bilheteListNumLugarDto.getBilhetes();
            ClienteBilhetesNumLugarDto item = new ClienteBilhetesNumLugarDto(cliente.getEmail(),arraybilheteListDto);
            lista.add(item);
        }
        ClientesBilhetesNumLugarDto obj = new ClientesBilhetesNumLugarDto(lista);
        return obj;
    }

    public static ClientesBilhetesDto clientesBilheteList2ClientesBilheteListDto(ArrayList<Cliente> arg) {
        ArrayList<ClienteBilhetesDto> lista = new ArrayList<>();
        for(Cliente cliente : arg) {
            BilheteListDto bilheteListDto = Mapper.bilheteList2BilheteListDto(cliente.getBilhetes().getAll());
            ArrayList<BilheteDto> arraybilheteListDto = bilheteListDto.getBilhetes();
            ClienteBilhetesDto item = new ClienteBilhetesDto(cliente.getEmail(),arraybilheteListDto);
            lista.add(item);
        }
        ClientesBilhetesDto obj = new ClientesBilhetesDto(lista);
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

    public static BilheteListNumLugarDto bilheteList2BilheteNumLugarListDto(ArrayList<Bilhete> arg) {
        ArrayList<BilheteNumLugarDto> lista = new ArrayList<>();
        for(Bilhete bilhete : arg) {
            BilheteNumLugarDto item = bilhete2BilheteNumLugarDto(bilhete);
            lista.add(item);
        }
        BilheteListNumLugarDto obj = new BilheteListNumLugarDto(lista);
        return obj;
    }

    public static BilheteList bilheteListDto2BilheteList(ArrayList<BilheteDto> arg) {
        ArrayList<Bilhete> lista = new ArrayList<>();
        for(BilheteDto bilhete : arg) {
            Bilhete item = bilheteDto2Bilhete(bilhete);
            lista.add(item);
        }
        BilheteList obj = new BilheteList(lista);
        return obj;
    }

    public static DataDto data2DataDto(Data arg){
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
        Cliente  obj = new Cliente(arg.getEmail(),arg.getNome(),date,arg.getCc());
        return obj;
    }
    /*public static Bilhete bilheteDto2Bilhete(BilheteDto arg) {
        Cliente  obj = new Cliente(arg.getExtras(),arg.getNomeViagem());
        return obj;
    }*/

    public static Extras extrasDto2Extra (ExtrasDto arg)
    {
        Extras obj = new Extras(arg.isComida(), arg.isSeguro(), arg.getMala());
        return obj;
    }
    public static ExtrasDto extra2ExtraDto( Extras arg)
    {
        ExtrasDto obj = new ExtrasDto(arg.getSeguro(),arg.getComida(),arg.getMala());
        return obj;
    }
    public static Bilhete bilheteDto2Bilhete(BilheteDto arg) {
        Extras extra = extrasDto2Extra(arg.getExtrasDto());
        Bilhete  b = new Bilhete(arg.getNomeViagem(), extra, arg.getTipoPassageiro(),arg.getTipoBilhete(),arg.getCc());
        return b;
    }

    /*public static BilheteList clienteBilheteListDto2ClienteBilheteList(ClienteBilhetesDto arg) {
        ArrayList<Bilhete> lista = new ArrayList<>();
        for(int i=0;i<arg.getBilhetes().size();i++) {
            Bilhete b = bilheteDto2Bilhete(arg.getBilhetes().get(i));
            lista.add(b);
        }
        BilheteList obj = new BilheteList(lista);
        return obj;
    }*/

    public static ViagemListDto viagemList2ViagemListDto(ArrayList<Viagem> arg) {
        ArrayList<ViagemDto> lista = new ArrayList<>();
        for(Viagem viagem : arg) {
            if(viagem==null) {
            }
            else {
                ViagemDto item = viagem2ViagemDto(viagem);
                lista.add(item);
            }
        }
        ViagemListDto obj = new ViagemListDto(lista);
        return obj;
    }

    public static ViagemDto viagem2ViagemDto(Viagem args){
        DataDto datapDto = data2DataDto(args.getDataPartida());
        DataDto datacDto = data2DataDto(args.getDataChegada());
        ViagemDto obj = new ViagemDto(args.getNomeViagem(), args.getLugaresTotais(), args.getCompanhia(), args.getCidadeInicial(), args.getCidadeFinal(),datapDto,datacDto,args.getLugaresEconomicos(),args.getLugaresExecutivos(),args.getLugaresPrimeiraClasse());
        return obj;
    }

    public static Viagem viagemDto2Viagem(ViagemDto arg){
        Data datap = dataDto2Data(arg.getDataPartida());
        Data datac = dataDto2Data(arg.getDataChegada());
        Viagem  obj = new Viagem(arg.getCompanhia(), arg.getLugaresTotais(), arg.getCidadeInicial(), arg.getCidadeFinal(), datap, datac, arg.getLugaresEconomicos(), arg.getLugaresExecutivos(), arg.getLugaresPrimeiraClasse());
        return obj;
    }
}
