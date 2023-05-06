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

    public static HorarioDto horario2HorarioDto(Horario arg){
        if (arg == null) {
            return null;
        }
        int [] hm = {0,0};
        arg.getHorario(hm);
        HorarioDto  obj = new HorarioDto(hm[0],hm[1]);
        return obj;
    }

    public static Data dataDto2Data(DataDto arg){
        Data  obj = new Data(arg.getDia(),arg.getMes(),arg.getAno());
        return obj;
    }

    public static Horario horarioDto2Horario(HorarioDto arg){
        Horario obj = new Horario(arg.getHora(),arg.getMinuto());
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
        HorarioDto horariopDto = horario2HorarioDto(args.getHoraPartida());
        HorarioDto horariocDto = horario2HorarioDto(args.getHoraChegada());
        ViagemDto obj = new ViagemDto(args.getNomeViagem(), args.getLugaresTotais(), args.getCompanhia(), args.getCidadeInicial(), args.getCidadeFinal(),datapDto,datacDto,horariopDto,horariocDto,args.getLugaresEconomicos(),args.getLugaresExecutivos(),args.getLugaresPrimeiraClasse());
        return obj;
    }

    public static Viagem viagemDto2Viagem(ViagemDto arg){
        Data datap = dataDto2Data(arg.getDataPartida());
        Data datac = dataDto2Data(arg.getDataChegada());
        Horario horariop = horarioDto2Horario(arg.getHorarioPartida());
        Horario horarioc = horarioDto2Horario(arg.getHorarioChegada());
        Viagem  obj = new Viagem(arg.getCompanhia(), arg.getLugaresTotais(), arg.getCidadeInicial(), arg.getCidadeFinal(), datap, datac, horariop,horarioc,arg.getLugaresEconomicos(), arg.getLugaresExecutivos(), arg.getLugaresPrimeiraClasse());
        return obj;
    }

    public static CriticaDto critica2CriticaDto (Critica c){
        DataDto dataDto = data2DataDto(c.getDatacritica());
        CriticaDto obj = new CriticaDto(c.getEmailCliente(), dataDto, c.getAvaliação(),c.getTextocritica(), c.getAssunto(), c.getViagem());
        return obj;
    }
    public static CriticaListDto criticaList2CriticaListDto(ArrayList<Critica>arg){
        ArrayList<CriticaDto> lista = new ArrayList<>();
        for(Critica critica : arg){
            CriticaDto item = critica2CriticaDto(critica);
            lista.add(item);
        }
        CriticaListDto obj = new CriticaListDto(lista);
        return obj;
    }
    public static Critica criticaDto2Critica(CriticaDto c){
        Data datac= dataDto2Data(c.getDatacritica());
        Critica obj = new Critica(c.getEmailCliente(), datac, c.getAvaliacao(), c.getTextocritica(), c.getAssunto(), c.getNomeViagem());
        return obj;
    }
    public static PessoaDto pessoa2PessoaDto(Pessoa p){
        DataDto dataDto = data2DataDto(p.getData());
        PessoaDto obj = new PessoaDto(p.getNome(), dataDto, p.getCc());
        return obj;
    }
    public static PessoaListDto pessoaList2PessoaListDto(ArrayList<Pessoa> lista){
        ArrayList<PessoaDto> list = new ArrayList<>();
        for(Pessoa pessoa : lista){
            PessoaDto item = pessoa2PessoaDto(pessoa);
            list.add(item);
        }
        PessoaListDto obj = new PessoaListDto(list);
        return obj;
    }
    public static Pessoa pessoaDto2Pessoa (PessoaDto arg){
        Data data = dataDto2Data(arg.getData());
        Pessoa p = new Pessoa(arg.getNome(), data,arg.getCc());
        return p;
    }
}
