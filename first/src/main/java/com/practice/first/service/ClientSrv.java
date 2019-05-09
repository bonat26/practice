package com.practice.first.service;

import com.practice.first.dto.ClientDto;
import com.practice.first.model.Client;

import java.util.List;

public interface ClientSrv {

    /****  CRUD ****/
    void saveClient(Client client);
    Client getClient(Integer clientId);
    List<Client> getAll(Integer page, Integer size);
    void updateClientNameById(Integer id, String name);


    /**** MAPPING ****/
    Client transform (ClientDto dto);
    ClientDto transform (Client client);
    List<ClientDto> transform(List<Client> clients);
}
