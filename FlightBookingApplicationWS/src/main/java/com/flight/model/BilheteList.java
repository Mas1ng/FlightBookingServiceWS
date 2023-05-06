package com.flight.model;

import com.flight.exceptions.InvalidDataException;

import java.io.Serializable;
import java.util.ArrayList;

import static com.flight.model.Mala.*;
import static com.flight.model.TipoBilhete.*;
import static com.flight.model.TipoPassageiro.*;

public class BilheteList implements Serializable {
    private ArrayList<Bilhete> bilhetes = new ArrayList<>();

    public BilheteList() {
        bilhetes = new ArrayList<Bilhete>();
    }
    public BilheteList(ArrayList<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }


    public BilheteList(String nomeViagem,int total,int nEc,int nEx,int nPr) {
        ArrayList<Bilhete> bilheteList = new ArrayList<>();
        TipoBilhete economico = ECONOMICO;
        TipoBilhete executivo = EXECUTIVO;
        TipoBilhete primeiraclasse = PRIMEIRACLASSE;
        int i=0;
        for(i=0;i<nEc;i++) {
            int nec = i+1;
            Bilhete b = new Bilhete(nec,nomeViagem,economico);
            bilheteList.add(b);
        }
        for(i=0;i<nEx;i++) {
            int nex = nEc+i+1;
            Bilhete b = new Bilhete(nex,nomeViagem,executivo);
            bilheteList.add(b);
        }
        for(i=0;i<nPr;i++) {
            int npr = nEx+nEc+i+1;
            Bilhete b = new Bilhete(npr,nomeViagem,primeiraclasse);
            bilheteList.add(b);
        }
        this.bilhetes = new ArrayList<>(bilheteList);
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
    public void addBilheteList(BilheteList bilheteList) {
        for(int i=0;i<bilheteList.sizeBilheteList();i++) {
            bilhetes.add(bilheteList.getBilheteByIndex(i));
        }
    }
    public int sizeBilheteList() {
        int size=0;
        for(Bilhete bilhete : bilhetes) {
            size++;
        }
        return size;
    }
    public Bilhete getBilheteByIndex(int i){
        Bilhete b = bilhetes.get(i);
        return b;
    }

    public boolean existeTipoBilhete(TipoBilhete tipoBilhete) {
        int i=0;
        for (Bilhete b : bilhetes) {
            if (b.tipoBilhete == tipoBilhete) {
                i++;
            }
        }
        if(i!=0) {
            return true;
        }else {
            return false;
        }

    }

    public Bilhete getPrimeiroBilheteByTipoBilhete(TipoBilhete tipoBilhete) {
        Bilhete bilhete = bilhetes.get(0);
        return bilhete;
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

    public Bilhete getNomeViagemByBilhete(int i) {
        Bilhete b = getBilheteByIndex(i);
        return b;
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

    public void removeBilheteList(BilheteList bilheteList){
        BilheteList bilheteList1 = new BilheteList();
        for(Bilhete b : bilhetes) {
            for(int i=0;i<bilheteList.sizeBilheteList();i++) {
                if(b.getNomeViagem().equals(bilheteList.getBilheteByIndex(i).getNomeViagem())){
                    bilheteList1.addBilhete(b);
                }
            }
        }
        for(int i=0;i<bilheteList1.sizeBilheteList();i++){
            bilhetes.remove(bilheteList1.getBilheteByIndex(i));
        }
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
        int numLugar1=-1;
        for(Bilhete bilhete : bilhetes) {
            if (bilhete.getNumLugar() == b.getNumLugar()) {
                numLugar1 = b.getNumLugar();
            }
        }
        bilhetes.remove(getBilheteByNum(numLugar1));
    }
    public void removeByIndex (int i) {
        bilhetes.remove(i);
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


    public void updatePreco() {
        for (Bilhete b : bilhetes) {
            int preco = b.getPreco();
            if (b.getTipoBilhete() == ECONOMICO) {
                preco = preco + 50;
            }
            if (b.getTipoBilhete() == EXECUTIVO) {
                preco = preco + 90;
            }
            if (b.getTipoBilhete() == PRIMEIRACLASSE) {
                preco = preco + 150;
            }


            if (b.getTipoPassageiro() == ADULTO) {
                preco = preco + 20;
            }
            if (b.getTipoPassageiro() == ADOLESCENTE) {
                preco = preco + 15;
            }
            if (b.getTipoPassageiro() == CRIANCA) {
                preco = preco + 10;
            }
            if (b.getTipoPassageiro() == BEBE) {
                preco = preco + 5;
            }

            if (b.getExtras().getSeguro()) {
                preco = preco + 40;
            }

            if (b.getExtras().getComida()) {
                preco = preco + 30;
            }

            if (b.getExtras().getMala() == PEQUENA) {
                preco = preco + 10;
            }
            if (b.getExtras().getMala() == MEDIA) {
                preco = preco + 20;
            }
            if (b.getExtras().getMala() == GRANDE) {
                preco = preco + 30;
            }
            b.setPreco(preco);
        }
    }

    public void updateNum(FBS fbs) {
        for (Bilhete b : bilhetes) {
            String nomeViagem = b.getNomeViagem();
            if (fbs.getViagemList().getViagemByNomeViagem(nomeViagem).getBilhetesParaVender().existeTipoBilhete(b.getTipoBilhete())) {
                Bilhete bilhete = fbs.getViagemList().getViagemByNomeViagem(nomeViagem).getBilhetesParaVender().getPrimeiroBilheteByTipoBilhete(b.getTipoBilhete());
                Bilhete bilhete1 = fbs.getViagemList().getViagemByNomeViagem(nomeViagem).getBilhetesParaVender().getPrimeiroBilheteByTipoBilhete(b.getTipoBilhete());
                b.setNumLugar(bilhete.getNumLugar());
                fbs.getViagemList().getViagemByNomeViagem(nomeViagem).getBilhetesVendidos().addBilhete(bilhete);
                fbs.getViagemList().getViagemByNomeViagem(nomeViagem).getBilhetesParaVender().remove(bilhete1);
                if(b.getTipoBilhete().equals(ECONOMICO)){
                    int i = fbs.getViagemList().getViagemByNomeViagem(nomeViagem).getLugaresEconomicos()-1;
                    fbs.getViagemList().getViagemByNomeViagem(nomeViagem).setLugaresEconomicos(i);
                }
                if(b.getTipoBilhete().equals(EXECUTIVO)){
                    int i = fbs.getViagemList().getViagemByNomeViagem(nomeViagem).getLugaresExecutivos()-1;
                    fbs.getViagemList().getViagemByNomeViagem(nomeViagem).setLugaresExecutivos(i);
                }
                if(b.getTipoBilhete().equals(EXECUTIVO)){
                    int i = fbs.getViagemList().getViagemByNomeViagem(nomeViagem).getLugaresEconomicos()-1;
                    fbs.getViagemList().getViagemByNomeViagem(nomeViagem).setLugaresEconomicos(i);
                }
            } else {
                String msg = "Nao existe mais nenhum bilhete do tipo:"+b.getTipoBilhete();
                throw new RuntimeException(msg);
            }
        }
    }

    public void updateBilheteC(FBS fbs) {
        updateNum(fbs);
        updatePreco();
    }
}
