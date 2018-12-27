package com.practice.first.mapper;

import com.practice.first.dto.ClientDto;
import com.practice.first.model.Client;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperImpl implements ClientMapper {

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public Client transform(ClientDto clientDto){
        return mapper.map(clientDto, Client.class);
    }

    @Override
    public ClientDto transform(Client client){
        return mapper.map(client, ClientDto.class);
    }
}
