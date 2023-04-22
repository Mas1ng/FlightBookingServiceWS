package com.flight.model;

import com.flight.exceptions.EmailInvalidException;
import com.flight.exceptions.InvalidDataException;

import java.util.ArrayList;

public class ClienteList {
    private ArrayList<Cliente> clientes;

    public void addCliente(Cliente cliente) {
        Cliente c = getClienteByEmail(cliente.getEmail());
        if (c != null){
            clientes.add(cliente);
        }else {
            //throw new ClienteDuplicadoException(cliente.getEmail());
        }
    }

    public Cliente getClienteByEmail(Email e){
        for (int i =0;i<clientes.size();i++) {
            Cliente cliente = clientes.get(i);
            if(cliente.getEmail().getEmail().equals(e.getEmail())){
                return  cliente;
            }
        }
        return null;
    }

    public ArrayList<Cliente> getAll() {
        ArrayList<Cliente> clienteList = new ArrayList<>();
        clienteList.addAll(this.clientes);
        return clienteList;
    }

    public void remove(Email email) {
        for(Cliente cliente : clientes) {
            if(cliente.getEmail().getEmail().equals(email.getEmail())) {
                clientes.remove(cliente);
            } else {
                String msg= "O email \"" + email + "\"não esta associado a nenhum cliente";
                throw new EmailInvalidException(msg);
            }
        }
    }

    public void update(String nomeNovo, Email emailAntigo, Data dataNovo, Email emailNovo) {
        Cliente cliente = getClienteByEmail(emailAntigo);
        if(cliente != null) {
            cliente.setData(dataNovo);
            cliente.setEmail(emailNovo);
            cliente.setNome(nomeNovo);
        } else {
            String msg= "O email \"" + emailAntigo + "\"não esta associado a nenhum cliente";
            throw new EmailInvalidException(msg);
        }
    }
}
