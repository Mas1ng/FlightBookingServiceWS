package com.flight.model;

import com.flight.exceptions.EmailInvalidException;

import java.io.Serializable;
import java.util.ArrayList;

public class BilheteList implements Serializable {
    private ArrayList<Bilhete> bilhetes = new ArrayList<>();

    public BilheteList() {
        bilhetes = new ArrayList<Bilhete>();
    }

    public void addBilhete(Bilhete bilhete) {
        BilheteList bilheteList = getBilheteListByNome(bilhete.nomeViagem);
        Bilhete b = bilheteList.getBilheteByNum(bilhete.numLugar);

        if(b==null) {
            bilhetes.add(bilhete);
        }else {
            //throw new ClienteDuplicadoException(cliente.getEmail());
        }
    }


    public  Bilhete getBilheteByNumLugar(ArrayList<Bilhete> bilheteList) {
        for(Bilhete bilhete : bilheteList) {
            for(int i=0;i<bilheteList.size();i++) {
                if(bilhete.getNumLugar()==bilheteList.get(i).getNumLugar()) {
                    return bilhete;
                }
            }
        }
        return null;
    }
    public Bilhete getBilheteByNum(int numLugar){
        for (Bilhete bilhete : bilhetes)
        {
            if( bilhete.getNumLugar()==numLugar){
                return bilhete;
            }
        }return  null;
    }

    public ArrayList<Bilhete> getBilheteListByNomeViagem(String nomeViagem) {
        ArrayList<Bilhete> bilhetesByNomeViagem = new ArrayList<>();
        for(Bilhete bilhete : bilhetes) {
            if(bilhete.nomeViagem.equals(nomeViagem)) {
                bilhetesByNomeViagem.add(bilhete);
            }
        }
        return bilhetesByNomeViagem;
    }
    public BilheteList getBilheteListByNome(String nomeViagem) {
        BilheteList bilhetesByNomeViagem = new BilheteList();
        for(Bilhete bilhete : bilhetes) {
            if(bilhete.nomeViagem.equals(nomeViagem)) {
                bilhetesByNomeViagem.addBilhete(bilhete);
            }
        }
        return bilhetesByNomeViagem;
    }

    public ArrayList<Bilhete> getAll() {
        ArrayList<Bilhete> bilhetelist = new ArrayList<>();
        bilhetelist.addAll(this.bilhetes);
        return  bilhetelist;
    }

    public void remove (Bilhete b) {
        for(Bilhete bilhete : bilhetes) {
            if(bilhete.getNumLugar()==b.getNumLugar()) {
                bilhetes.remove(bilhete);
            }else {
                String msg= "Errado numero de lugar de bilhete";
                //throw new EmailInvalidException(msg);
            }
        }
    }

    public void update(Bilhete b, int numLugarNovo, String viagemNova, Extras extrasNovo, TipoPassageiro tipoPassageiroNovo) {
        if(b!=null) {
            b.setViagem(viagemNova);
            b.setNumLugar(numLugarNovo);
            b.setExtras(extrasNovo);
            b.setTipoPassageiro(tipoPassageiroNovo);
        } else {
            String msg= "A Viagem"+ b.getNomeViagem() + "não existe";
            //throw new EmailInvalidException(msg);
        }
    }
}
