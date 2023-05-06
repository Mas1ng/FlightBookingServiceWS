package com.flight.model;

import java.io.Serializable;
import java.util.ArrayList;

public class PessoaList implements Serializable {
    private ArrayList<Pessoa> pessoas;
    public PessoaList(){pessoas = new ArrayList<Pessoa>();}
    public ArrayList<Pessoa> getAll() {
        ArrayList<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.addAll(this.pessoas);
        return pessoaList;
    }
    public Pessoa getPessoaByCC(long cc){
        for (int i =0;i<pessoas.size();i++) {
            Pessoa pessoa = pessoas.get(i);
            if(pessoa.getCc()==cc){
                return pessoa;
            }
        }
        return null;
    }
    public void add(Pessoa p){
        Pessoa pessoa = getPessoaByCC(p.getCc());
        if(pessoa == null){
            pessoas.add(p);
        }else{
            String msg = "Não deu para adicionar essa pessoa.";
            throw new RuntimeException(msg);
        }
    }

    public void update(Pessoa p, String nome, Data data, long cc)
    {
        if(p!=null)
        {
            p.setNome(nome);
            p.setData(data);
            p.setCc(cc);
        }else{
            String msg ="A pessoa não existe";
            throw new RuntimeException(msg);
        }
    }
    public void remove ( Pessoa p ){
    if(p!=null){
                pessoas.remove(p);}
           else{
            String msg = "Essa pessoa não existe.";
            throw new RuntimeException(msg);
        }
    }

}
