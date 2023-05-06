package com.flight.model;

import com.flight.exceptions.ClienteDuplicadoException;
import com.flight.exceptions.InvalidException;
import com.flight.repository.FilesOperation;

import java.io.Serializable;
import java.util.ArrayList;

public class ClienteList implements Serializable {
    private ArrayList<Cliente> clientes;

    public ClienteList() {
        clientes = new ArrayList<Cliente>();
    }

    public void addCliente(Cliente cliente) {
        Cliente c = getClienteByEmail(cliente.getEmail());
        Cliente c1 = getClienteByCc(cliente.getCc());
        if (c == null) {
            if(c1==null) {
                clientes.add(cliente);
            }
            else{
                String msg = "Um cliente com o cc "+cliente.getCc()+" ja foi criado";
                throw new ClienteDuplicadoException(msg);
            }
        } else {
            String msg = "Um cliente com o email "+cliente.getEmail()+" ja foi criado";
            throw new ClienteDuplicadoException(msg);
        }
    }

    public Cliente getClienteByEmail(String email){
        for (int i =0;i<clientes.size();i++) {
            Cliente cliente = clientes.get(i);
            if(cliente.getEmail().equals(email)){
                return cliente;
            }
        }return null;
    }
    public Cliente getClienteByCc(long cc){
        for (int i =0;i<clientes.size();i++) {
            Cliente cliente = clientes.get(i);
            if(cliente.getCc()==cc){
                return cliente;
            }
        }return null;
    }

    public ArrayList<Cliente> getAll() {
        ArrayList<Cliente> clienteList = new ArrayList<>();
        clienteList.addAll(this.clientes);
        return clienteList;
    }

    public void remove(Cliente c) {
        if(c!=null) {
            clientes.remove(c);
        } else {
            String msg= "O c \"" + c.getEmail() + "\"não esta associado a nenhum cliente";
            throw new InvalidException(msg);
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
            throw new InvalidException(msg);
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
            throw new InvalidException(msg);
        }
    }
    public boolean getBilheteClienteByNome(String nomeviagem, String e){
        FBS fbs = FilesOperation.loadFBS();
        boolean vf=false;
        Cliente c =fbs.getClienteList().getClienteByEmail(e);
        BilheteList b = fbs.getViagemList().get(nomeviagem).getBilhetesParaVender();
        for(int i=0; i<c.getBilhetes().sizeBilheteList();i++){
            if(c.getBilhetes().getBilheteByIndex(i).getNomeViagem().equals(nomeviagem)){
                vf=true;
            }
        }
        return vf;
    }
}
