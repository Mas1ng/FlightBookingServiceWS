package com.flight.service;

import com.flight.dto.*;
import com.flight.model.Critica;
import com.flight.model.Data;
import com.flight.model.FBS;
import com.flight.repository.FilesOperation;

import java.util.ArrayList;

public class CriticaService {
    public static CriticaListDto getCriticas(){
        FBS fbs = FilesOperation.loadFBS();
        ArrayList<Critica> lista = fbs.getCriticaList().getAllCriticas();
        CriticaListDto result = Mapper.criticaList2CriticaListDto(lista);
        return result;
    }
    public static CriticaDto getCritica(NomeViagemEmailDto x){
        FBS fbs = FilesOperation.loadFBS();
        Critica item = fbs.getCriticaList().get(x.getNomeViagem(), x.getEmail());
        CriticaDto result = Mapper.critica2CriticaDto(item);
        return result;
    }
    public static void addCritica (CriticaDto c){
        FBS fbs = FilesOperation.loadFBS();
        Critica item = Mapper.criticaDto2Critica(c);
        fbs.getCriticaList().addCritica(item);
        FilesOperation.storeFBS(fbs);
    }
    public static void updateCritica(String nomeViagem, CriticaEmailDto x){
        FBS fbs = FilesOperation.loadFBS();
        Critica critica = fbs.getCriticaList().procurarCritica(nomeViagem,x.getEmailCliente());
        Data data = Mapper.dataDto2Data(x.getCriticaNova().getDatacritica());
        Critica c = Mapper.criticaDto2Critica(x.getCriticaNova());
        fbs.getCriticaList().update(critica, c.getEmailCliente(), data, c.getAvaliação(), c.getTextocritica(), c.getAssunto(), c.getViagem());
        FilesOperation.storeFBS(fbs);
    }
    public static void removeCritica (NomeViagemEmailDto x ){
        FBS fbs = FilesOperation.loadFBS();
        Critica critica = fbs.getCriticaList().procurarCritica(x.getNomeViagem(), x.getEmail());
        fbs.getCriticaList().remove(critica);
        FilesOperation.storeFBS(fbs);
    }
}
