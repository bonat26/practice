package com.practice.first.service;

import com.practice.first.dto.ClientDto;
import com.practice.first.model.Client;

public interface ClientSrv {

    /****  CRUD ****/
    void saveClient(Client client);
    Client getClient(Integer clientId);
    void updateClientNameById(Integer id, String name);


    /**** MAPPING ****/
    Client transform (ClientDto dto);
    ClientDto transform (Client client);
}
