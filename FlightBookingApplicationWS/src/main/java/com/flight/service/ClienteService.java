package com.flight.service;

import com.flight.model.FBS;
import com.flight.repository.FilesOperation;

public class ClienteService {

    public static ClienteListDTO getClientes() {
      FBS fbs  = FilesOperation.loadFBS();
    }
}
