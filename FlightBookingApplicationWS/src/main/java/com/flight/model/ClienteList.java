package com.flight.model;

import com.flight.exceptions.InvalidDataException;

import java.util.ArrayList;
import java.util.Iterator;

public class ClienteList {
    private ArrayList<Cliente> clientes;

    private Cliente search(String nome) {
        Cliente cliente;
        for (int i = 0; i < clientes.size(); i++) {
            Cliente p = clientes.get(i);
            if (p.getName().equals(nome)) {
                return p;
            }
        }
        return null;
    }
    public Cliente get(String nome){
        Cliente cliente = search(nome);
        if(cliente != null){
            return cliente;
        }else{
            String msg = "Cliente: " + cliente+ " não existe!!";
            throw ew InvalidDataException(msg);
        }
    }


}
