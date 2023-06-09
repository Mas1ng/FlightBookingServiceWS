package com.flight.model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FBS implements Serializable {
    private String nome;
    private ClienteList clienteList;
    private BilheteList bilheteList;
    private ViagemList viagemList;
    private PessoaList pessoaList;
    private CriticaList criticaList;

    private void setDataForConsistency() {
        //this.bilheteList.
    }

    public FBS() {
        this.nome="FBS";
        this.bilheteList= new BilheteList();
        this.clienteList=new ClienteList();
        this.viagemList = new ViagemList();
        this.pessoaList = new PessoaList();
        this.criticaList= new CriticaList();
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

    public PessoaList getPessoaList() {
        return pessoaList;
    }

    public CriticaList getCriticaList() {
        return criticaList;
    }
}
