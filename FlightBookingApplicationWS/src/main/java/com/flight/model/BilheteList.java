package com.flight.model;

import com.flight.exceptions.EmailInvalidException;

import java.util.ArrayList;

public class BilheteList {
    private ArrayList<Bilhete> bilhetes = new ArrayList<>();



    public void addBilhete(Bilhete bilhete) {
    ArrayList<Bilhete> bilheteList = getBilheteListByNomeViagem(bilhete.viagem.getNomeViagem());
    Bilhete b = getBilheteByNumLugar(bilheteList);
    if(b==null) {
        bilhetes.add(bilhete);
    }else {
        //throw new ClienteDuplicadoException(cliente.getEmail());
    }
    }

    public Bilhete getBilheteByNumLugar(ArrayList<Bilhete> bilheteList) {
        for(Bilhete bilhete : bilhetes) {
            for(int i=0;i<bilheteList.size();i++) {
                if(bilhete.getnumLugar()==bilheteList.get(i).getnumLugar()) {
                    return bilhete;
                }
            }
        }
        return null;
    }

    public ArrayList<Bilhete> getBilheteListByNomeViagem(String nomeViagem) {
        ArrayList<Bilhete> bilhetesByNomeViagem = new ArrayList<>();
        for(Bilhete bilhete : bilhetes) {
            if(bilhete.viagem.getNomeViagem().equals(nomeViagem)) {
                bilhetesByNomeViagem.add(bilhete);
            }
        }
        return bilhetesByNomeViagem;
    }

    public ArrayList<Bilhete> getAll() {
        ArrayList<Bilhete> bilhetelist = new ArrayList<>();
        bilhetes.addAll(this.bilhetes);
        return  bilhetelist;
    }

    public void remove (Bilhete b) {
        for(Bilhete bilhete : bilhetes) {
            if(bilhete.getnumLugar()==b.getnumLugar()) {
                bilhetes.remove(bilhete);
            }else {
                String msg= "Errado numero de lugar de bilhete";
                //throw new EmailInvalidException(msg);
            }
        }
    }

    public void update(Viagem viagemAntiga, int numLugarNovo, Viagem viagemNova, Extras extrasNovo, TipoPassageiro tipoPassageiroNovo) {
        ArrayList<Bilhete> bilheteList = getBilheteListByNomeViagem(viagemAntiga.getNomeViagem());
        Bilhete b = getBilheteByNumLugar(bilheteList);
        if(b!=null) {
            b.setViagem(viagemNova);
            b.setNumLugar(numLugarNovo);
            b.setExtras(extrasNovo);
            b.setTipoPassageiro(tipoPassageiroNovo);
        } else {
            String msg= "A Viagem"+ viagemAntiga + "não existe";
            //throw new EmailInvalidException(msg);
        }
    }
}
