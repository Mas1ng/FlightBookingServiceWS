package com.flight.model;

import com.flight.exceptions.EmailInvalidException;

import java.io.Serializable;
import java.util.ArrayList;

public class ViagemList implements Serializable {
    private ArrayList<Viagem> viagens;

    public ViagemList() {
        viagens = new ArrayList<Viagem>();
    }

    public void addViagem(Viagem viagem) {
        Viagem v = getViagemByNomeViagem(viagem.getNomeViagem());
        if(v!=null) {
            viagens.add(v);
        } else {
            //throw new ClienteDuplicadoException(cliente.getEmail());
        }
    }

    public Viagem getViagemByNomeViagem(String nomeViagem) {
        for(Viagem viagem : viagens) {
            if(viagem.getNomeViagem().equals(nomeViagem)) {
                return viagem;
            }
        }
        return null;
    }

    public ArrayList<Viagem> getAll() {
        ArrayList<Viagem> viagemList = new ArrayList<>();
        viagemList.addAll(this.viagens);
        return viagemList;
    }

    public void remove(String nomeViagem) {
        for(Viagem viagem : viagens) {
            if(viagem.getNomeViagem().equals(nomeViagem)) {
                viagens.remove(viagem);
            } else {
                String msg= "A viagem "+viagem.getNomeViagem()+"nao existe";
                //throw new EmailInvalidException(msg);
            }
        }
    }

    public void update() {
    }
}
