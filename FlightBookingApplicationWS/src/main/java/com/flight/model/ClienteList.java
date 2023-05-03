package com.flight.model;

import com.flight.exceptions.ClienteDuplicadoException;
import com.flight.exceptions.EmailInvalidException;
import com.flight.exceptions.InvalidDataException;

import java.io.Serializable;
import java.util.ArrayList;

public class ClienteList implements Serializable {
    private ArrayList<Cliente> clientes;

    public ClienteList() {
        clientes = new ArrayList<Cliente>();
    }

    public void addCliente(Cliente cliente) {
        Cliente c = getClienteByEmail(cliente.getEmail());
        if (c == null) {
            clientes.add(cliente);
        } else {
            throw new ClienteDuplicadoException(cliente.getEmail());
        }
    }

    public Cliente getClienteByEmail(String email){
        for (int i =0;i<clientes.size();i++) {
            Cliente cliente = clientes.get(i);
            if(cliente.getEmail().equals(email)){
                return cliente;
            }
        }
        return null;
    }

    public ArrayList<Cliente> getAll() {
        ArrayList<Cliente> clienteList = new ArrayList<>();
        clienteList.addAll(this.clientes);
        return clienteList;
    }

    public void remove(String email) {
        for(Cliente cliente : clientes) {
            if(cliente.getEmail().equals(email)) {
                clientes.remove(cliente);
            } else {
                String msg= "O email \"" + email + "\"não esta associado a nenhum cliente";
                throw new EmailInvalidException(msg);
            }
        }
    }

    public void update(String emailAntigo, String nomeNovo, Data dataNovo, String emailNovo) {
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
    public void updateBilhete(BilheteList b, String email) {
        Cliente cliente = getClienteByEmail(email);
        if(cliente != null) {
            if(cliente.getBilhetes()==null){
                cliente.setBilhetes(b);
            }else {
                cliente.getBilhetes().addBilheteList(b);
            }
        } else {
            String msg= "O email \"" + email + "\"não esta associado a nenhum cliente";
            throw new EmailInvalidException(msg);
        }
    }
}
