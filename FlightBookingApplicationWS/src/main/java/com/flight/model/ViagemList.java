package com.flight.model;

import com.flight.exceptions.InvalidException;
import com.flight.exceptions.InvalidDataException;

import java.io.Serializable;
import java.util.ArrayList;

public class ViagemList implements Serializable {
    private ArrayList<Viagem> viagens;

    public ViagemList() {
        viagens = new ArrayList<Viagem>();
    }

    public void addViagem(Viagem viagem) {
        Viagem v = getViagemByNomeViagem(viagem.getNomeViagem());
        if(v==null) {
            viagens.add(viagem);
        } else {
            //throw new ClienteDuplicadoException(cliente.getEmail());
        }
    }

    public Viagem getViagemByNomeViagem(String nomeViagem) {
        for(Viagem viagem : viagens) {
            if(viagem== null) {
                return null;
            }
            if(viagem.getNomeViagem().equals(nomeViagem)) {
                return viagem;
            }
        }
        return null;
    }

    public Viagem getViagembyIndex(int i){
        Viagem v = viagens.get(i);
        return v;
    }

    public int sizeViagemList() {
        int size=0;
        for(Viagem viagem : viagens) {
            size++;
        }
        return size;
    }

    /*public static boolean validarBilheteList(BilheteList item,ViagemList viagemList){
        for(int i=0;i<item.sizeBilheteList();i++) {
            for(int j=0;j<viagemList.sizeViagemList();j++){
                if(item.getBilheteListIndex(i).getNomeViagem().equals(viagemList.getViagembyIndex(j).getNomeViagem()) && item.getBilheteListIndex(i).getNumLugar()==viagemList.getViagembyIndex(j).get){
                    return true;
                }
            }
        }return false;
    }*/

    public ArrayList<Viagem> getAll() {
        ArrayList<Viagem> viagemList = new ArrayList<>();
        viagemList.addAll(this.viagens);
        return viagemList;
    }

    public void remove(Viagem v) {
        if(v!=null) {
            viagens.remove(v);
        } else {
            String msg= "A viagem "+v.getNomeViagem()+"nao existe";
            throw new InvalidException(msg);
        }
    }

    public void update(String nomeViagem, Companhia companhia, Data dataF, Data dataI) {
        Viagem viagem = getViagemByNomeViagem(nomeViagem);
        if(viagem!=null)
        {
            viagem.setCompanhia(companhia);
            viagem.setDataChegada(dataF);
            viagem.setDataPartida(dataI);
        }else{
            String msg = "A viagem: " + nomeViagem+" não existe!!";
            throw  new InvalidDataException(msg);
        }
    }
}
