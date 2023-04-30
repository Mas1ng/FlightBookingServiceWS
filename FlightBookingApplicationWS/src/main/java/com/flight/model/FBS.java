package com.flight.model;

import java.io.Serializable;

public class FBS implements Serializable {
    private String nome;
    private ClienteList clienteList;
    private BilheteList bilheteList;
    private ViagemList viagemList;

    private void setDataForConsistency() {
        //this.bilheteList.
    }

    public FBS() {
        this.nome="FBS";
        this.bilheteList= new BilheteList();
        this.clienteList=new ClienteList();
        this.viagemList = new ViagemList();
        setDataForConsistency();
    }

    public String getNome() {
        return nome;
    }

    public ClienteList getClienteList() {
        return clienteList;
    }

    public BilheteList getBilheteList() {
        return bilheteList;
    }

    public ViagemList getViagemList() {
        return viagemList;
    }
}
