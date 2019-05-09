package com.practice.first.serviceImpl;

import com.practice.first.dao.ClientDao;
import com.practice.first.dto.ClientDto;
import com.practice.first.mapper.ClientMapper;
import com.practice.first.model.Client;
import com.practice.first.service.ClientSrv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ClientSrvImpl implements ClientSrv {

    private ClientDao dao;

    private ClientMapper mapper;

    public ClientSrvImpl(ClientDao dao, ClientMapper mapper){
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public void saveClient(Client client) {
        log.info("Start method - ClientSrv.saveClient");
        log.info("Input - {}", client);

        dao.save(client);

        log.info("End method - ClientSrv.saveClient");
        log.info("Output - {}", client);

    }

    @Override
    public Client getClient(Integer idClient){
        log.info("Start method - ClientSrv.getClient");
        log.info("Input - {}", idClient);

        Client client = dao.findById(idClient).orElse(new Client());

        log.info("End method - ClientSrv.saveClient");
        log.info("Output - {}", client);

        return client;
    }

    @Override
    public List<Client> getAll(Integer page, Integer size) {
        log.info("Start method - ClientSrv.getAll");
        log.info("Input - {}, {}", page, size);

        List<Client> clients = new ArrayList<>();
        dao.findAll(PageRequest.of(page, size)).forEach(a -> clients.add(a));

        log.info("End method - ClientSrv.getAll");
        log.info("Output - {}", clients);

        return clients;
    }

    @Override
    public void updateClientNameById(Integer id, String name){

        log.info("Start method - ClientSrv.updateClientNameById");
        log.info("Input - {}, {}", id, name);

        dao.updateClientName(id, name);

        log.info("End method - ClientSrv.updateClientNameById");
    }

    @Override
    public Client transform(ClientDto dto) {
        return mapper.transform(dto);
    }

    @Override
    public ClientDto transform(Client client) {
        return mapper.transform(client);
    }

    @Override
    public List<ClientDto> transform(List<Client> clients){

        List<ClientDto> clientsDto = new ArrayList<>();

        clients.forEach(a -> clientsDto.add(transform(a)));

        return clientsDto;
    }

}
