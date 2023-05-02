package com.flight.service;

import com.flight.dto.*;
import com.flight.exceptions.InvalidDataException;
import com.flight.model.*;
import com.flight.repository.FilesOperation;

import java.util.ArrayList;

public class BilheteService {

    public static BilheteListDto getBilhetes() {
        FBS fbs  = FilesOperation.loadFBS();
        ArrayList<Bilhete> lista = fbs.getBilheteList().getAll();
        BilheteListDto result = Mapper.bilheteList2BilheteListDto(lista);
        return result;
    }
    public static BilheteDto getBilhete(String nomeViagem, int numLugar) {
        FBS fbs  = FilesOperation.loadFBS();
        BilheteList bilheteList = fbs.getBilheteList().getBilheteListByNome(nomeViagem);
        Bilhete b = bilheteList.getBilheteByNum(numLugar);
        BilheteDto result = Mapper.bilhete2BilheteDto(b);
        return result; //mas e se não houver viagem com esse nome
    }
    public static void addBilhete(BilheteDto arg)
    {
        FBS fbs = FilesOperation.loadFBS();
        Bilhete i = Mapper.bilheteDto2Bilhete(arg);
        fbs.getBilheteList().addBilhete(i);
        FilesOperation.storeFBS(fbs);
    }
    public static void updateBilhete(String nomeViagem, int numLugar, BilheteDto arg)
    {
        FBS fbs  = FilesOperation.loadFBS();
        BilheteList bilheteList = fbs.getBilheteList().getBilheteListByNome(nomeViagem);
        Bilhete b = bilheteList.getBilheteByNum(numLugar);
        Extras extras = Mapper.extrasDto2Extra(arg.getExtrasDto());
        fbs.getBilheteList().update(b, arg.getNumLugar(), arg.getNomeViagem(),extras, arg.getTipoPassageiro());
        FilesOperation.storeFBS(fbs);
    }
    public static void removeBilhete(String nomeViagem, int numLugar){
        FBS fbs = FilesOperation.loadFBS();
        BilheteList bilheteList = fbs.getBilheteList().getBilheteListByNome(nomeViagem);
        Bilhete b = bilheteList.getBilheteByNum(numLugar);
        fbs.getBilheteList().remove(b);
        FilesOperation.storeFBS(fbs);
    }
}