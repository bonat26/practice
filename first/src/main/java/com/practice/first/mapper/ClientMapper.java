package com.practice.first.mapper;

import com.practice.first.dto.ClientDto;
import com.practice.first.model.Client;

public interface ClientMapper {

    Client transform(ClientDto clientDto);
    ClientDto transform(Client clientDto);
}
