package com.flight.service;

import com.flight.dto.ClienteListDto;
import com.flight.dto.Mapper;
import com.flight.dto.PessoaDto;
import com.flight.dto.PessoaListDto;
import com.flight.model.*;
import com.flight.repository.FilesOperation;

import java.util.ArrayList;

public class PessoaService {

    public static void addPessoa(PessoaDto arg) {
        FBS fbs = FilesOperation.loadFBS();
       Pessoa item = Mapper.pessoaDto2Pessoa(arg);
        fbs.getPessoaList().add(item);
        FilesOperation.storeFBS(fbs);
    }
    public static PessoaListDto getPessoas() {
        FBS fbs  = FilesOperation.loadFBS();
        ArrayList<Pessoa> lista = fbs.getPessoaList().getAll();
        PessoaListDto result = Mapper.pessoaList2PessoaListDto(lista);
        return result;
    }
    public static PessoaDto getPessoa(long cc) {
        FBS fbs  = FilesOperation.loadFBS();
        Pessoa p = fbs.getPessoaList().getPessoaByCC(cc);
        PessoaDto result = Mapper.pessoa2PessoaDto(p);
        return result;
    }
    public static void updatePessoa(PessoaDto p, long CC){
        FBS fbs = FilesOperation.loadFBS();
        Pessoa item = fbs.getPessoaList().getPessoaByCC(CC);
        Data data = Mapper.dataDto2Data(p.getData());
        fbs.getPessoaList().update(item, p.getNome(), data, p.getCc());
        FilesOperation.storeFBS(fbs);
    }
    public static void removePessoa(long CC){
        FBS fbs = FilesOperation.loadFBS();
        Pessoa p = fbs.getPessoaList().getPessoaByCC(CC);
        fbs.getPessoaList().remove(p);
        FilesOperation.storeFBS(fbs);
    }


}
