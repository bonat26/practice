package com.practice.first.service;

import com.practice.first.dto.ClientDto;
import com.practice.first.model.Client;

public interface ClientSrv {

    /****  CRUD ****/
    void saveClient(Client client);



    /**** MAPPING ****/
    Client transform (ClientDto dto);
    ClientDto transform (Client client);

}
