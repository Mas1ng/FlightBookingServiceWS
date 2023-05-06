package com.flight.mock;

import com.flight.model.Cliente;
import com.flight.model.ClienteList;
import com.flight.model.Data;
import com.flight.model.FBS;

import java.util.Random;

public class MockData {

    private String[] nome_cliente ={"Joao Jose","Jose Joao"};
    private String[] nome_email = {"joaojose@gmai.com","josejoao@gmail.com"};
    private long[] cc = {123454321,987656789};

    private Data genDate(){
        Random gen = new Random(System.currentTimeMillis());

        int day = 1 + (gen.nextInt(Integer.MAX_VALUE) % 27);
        int month = 1 + (gen.nextInt(Integer.MAX_VALUE) % 12);
        int year = 1970 + (gen.nextInt(Integer.MAX_VALUE) % 40);
        Data dt = new Data(day,month,year);
        return dt;
    }

    private void  insertClientes(ClienteList container){
        for (int i = 0; i < nome_cliente.length;i++){
            Data dt = genDate();
            Cliente obj = new Cliente(nome_email[i],nome_cliente[i],dt,cc[i]);
            container.addCliente(obj);
        }
    }

    public void  generateData(FBS fbs){
        insertClientes(fbs.getClienteList());
    }
}
