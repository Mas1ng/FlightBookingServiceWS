package com.flight.service;

import com.flight.dto.*;
import com.flight.model.*;
import com.flight.repository.FilesOperation;

import java.util.ArrayList;

public class BilheteService {

    public static ClientesBilhetesNumLugarDto getAllBilhetes() {
        FBS fbs  = FilesOperation.loadFBS();
        ArrayList<Cliente> lista = fbs.getClienteList().getAll();
        ClientesBilhetesNumLugarDto result = Mapper.clientesBilheteList2ClientesBilheteNumLugarListDto(lista);
        return result;
    }
    public static BilheteListNumLugarDto getBilhetesFromCliente(String email) {
        FBS fbs  = FilesOperation.loadFBS();
        Cliente c = fbs.getClienteList().getClienteByEmail(email);
        ArrayList<Bilhete> lista = c.getBilhetes().getAll();
        BilheteListNumLugarDto result = Mapper.bilheteList2BilheteNumLugarListDto(lista);
        return result;
    }
    public static void addBilheteListToCliente(ClienteBilhetesDto arg)
    {
        FBS fbs = FilesOperation.loadFBS();
        Cliente c = fbs.getClienteList().getClienteByEmail(arg.getEmail());
        BilheteList bilheteList = new BilheteList();
        ArrayList<BilheteDto> lista = arg.getBilhetes();
        BilheteList b = Mapper.bilheteListDto2BilheteList(lista);
        for(int i =0;i<fbs.getViagemList().sizeViagemList();i++) {
            for(int j=0;j<b.sizeBilheteList();j++){
                if(fbs.getViagemList().getViagembyIndex(i).getNomeViagem().equals(b.getBilheteByIndex(j).getNomeViagem())) {
                   bilheteList.addBilhete(b.getBilheteByIndex(j));
                }
            }
        }
        bilheteList.updateBilheteC(fbs);
        c.getBilhetes().addBilheteList(bilheteList);
        fbs.getBilheteList().addBilheteList(bilheteList);
        FilesOperation.storeFBS(fbs);
    }
    /*public static void updateBilhete(String nomeViagem, int numLugar, BilheteDto arg)
    {
        FBS fbs  = FilesOperation.loadFBS();
        BilheteList bilheteList = fbs.getBilheteList().getBilheteListByNome(nomeViagem);
        Bilhete b = bilheteList.getBilheteByNum(numLugar);
        Extras extras = Mapper.extrasDto2Extra(arg.getExtrasDto());
        fbs.getBilheteList().update(b, arg.getNumLugar(), arg.getNomeViagem(),extras, arg.getTipoPassageiro());
        FilesOperation.storeFBS(fbs);
    }*/
    public static void removeBilhete(String email, NumLugarNomeViagemDto arg){
        FBS fbs = FilesOperation.loadFBS();
        Cliente c = fbs.getClienteList().getClienteByEmail(email);
        BilheteList bilheteList = c.getBilhetes().getBilheteListByNome(arg.getNomeViagem());
        Bilhete b = bilheteList.getBilheteByNum(arg.getnLugar());
        c.getBilhetes().remove(b);
        fbs.getViagemList().getViagemByNomeViagem(arg.getNomeViagem()).getBilhetesParaVender().addBilhete(b);
        fbs.getViagemList().getViagemByNomeViagem(arg.getNomeViagem()).getBilhetesVendidos().remove(b);
        fbs.getViagemList().getViagemByNomeViagem(arg.getNomeViagem()).alterarNumerosLugar(fbs,b);
        FilesOperation.storeFBS(fbs);
    }
}