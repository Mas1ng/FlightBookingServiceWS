package com.flight.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.flight.dto.*;
import com.flight.model.*;
import com.flight.repository.FilesOperation;

import java.util.ArrayList;
import java.util.List;

public class ViagemService {
    public static ViagemListDto getViagens(){
        FBS fbs = FilesOperation.loadFBS();
        ArrayList<Viagem> list = fbs.getViagemList().getAll();
        ViagemListDto result = Mapper.viagemList2ViagemListDto(list);
        return result;
    }
    public static ViagemDto getViagem(String nomeViagem){
        FBS fbs =FilesOperation.loadFBS();
        Viagem item = fbs.getViagemList().getViagemByNomeViagem(nomeViagem);
        ViagemDto result = Mapper.viagem2ViagemDto(item);
        return result;
    }
    public static void addViagem ( ViagemDto arg)
    {
        FBS fbs = FilesOperation.loadFBS();
        Viagem v = Mapper.viagemDto2Viagem(arg);
        fbs.getViagemList().addViagem(v);
        FilesOperation.storeFBS(fbs);
    }
    public static void updateViagem(String nomeViagem, ViagemDto arg)
    {
        FBS fbs = FilesOperation.loadFBS();
        Data dataChegada = Mapper.dataDto2Data(arg.getDataChegada());
        Data dataPartida = Mapper.dataDto2Data(arg.getDataPartida());
        fbs.getViagemList().update(nomeViagem, arg.getCompanhia(), dataChegada, dataPartida);
        FilesOperation.storeFBS(fbs);
    }
    public static void removeViagem (String nomeViagem)
    {
        FBS fbs = FilesOperation.loadFBS();
        Viagem v = fbs.getViagemList().getViagemByNomeViagem(nomeViagem);
        fbs.getViagemList().remove(v);
        FilesOperation.storeFBS(fbs);
    }
}
