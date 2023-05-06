package com.flight.model;

import com.flight.exceptions.InvalidDataException;
import com.flight.repository.FilesOperation;

import java.io.Serializable;
import java.util.ArrayList;

public class CriticaList implements Serializable {
    private ArrayList<Critica> criticas;

    public CriticaList() {

        criticas = new ArrayList<Critica>();
    }

    public ArrayList<Critica> getAllCriticas() {
        ArrayList<Critica> criticaList = new ArrayList<>();
        criticaList.addAll(this.criticas);
        return criticaList;
    }
    public Critica procurarCritica(String nomeViagem, String email){
        for(Critica critica : criticas)
        {
            if(critica.getViagem().equals(nomeViagem)){
                if(critica.getEmailCliente().equals(email)){
                    return critica;
                }
            }
        }return null;
    }
    public Critica get(String nomeViagem, String email){
        Critica c = procurarCritica(nomeViagem, email);
        if(c!=null){
            return c;
        }else{
            String msg = "Critica: " + c+ " does not exist!!";
            throw  new InvalidDataException(msg);
        }
    } //primeiro tens de validar o cliente e a viagem verificar se existem
    public void addCritica (Critica critica)
    {
        boolean tf=validarDadosCritica(critica.getEmailCliente(), critica.getDatacritica(), critica.getViagem());
        if(tf=true) {
            Critica c = procurarCritica(critica.getViagem(), critica.getEmailCliente());
            if (c == null) {
                criticas.add(c);
            } else {
                String msg = "O cliente não pode fazer mais criticas a esta viagem!!" +
                        "seu frustradinho";
                throw new InvalidDataException(msg);
            }
        }
    }
    public void remove (Critica c){
            if(c!=null){
                criticas.remove(c);
            }else{
                String msg = "Dados errados";
                throw new InvalidDataException(msg);
            }
        }
    public void update(Critica c, String emailCliente, Data dataCritica, String avaliacao, String textocritica, String assunto, String nomeViagem){
        if(c!= null){
            boolean tf=validarDadosCritica(emailCliente, dataCritica,nomeViagem);
            if(tf){
                c.setEmailCliente(emailCliente);
                c.setDatacritica(dataCritica);
                c.setAssunto(assunto);
                c.setAvaliação(avaliacao);
                c.setTextocritica(textocritica);

            }else{
                String msg = "Dados inválidos";
                throw new RuntimeException(msg);
            }
        }
    }

    public boolean validarDadosCritica(String e , Data dt, String nomeViagem){
        FBS fbs = FilesOperation.loadFBS();
        boolean tf;
        if( fbs.getClienteList().getClienteByEmail(e)!=null){
            if(fbs.getClienteList().getBilheteClienteByNome(nomeViagem, e)){
                if(fbs.getViagemList().getViagemByNomeViagem(nomeViagem).getDataChegada().isSmallerThan(dt)){
                    tf=true;
                }
            }
        }
        else{
            String msg = "Os dados inseridos não estao certos.";
            throw new RuntimeException(msg);
        }
        return true;
    }

}
