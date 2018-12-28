package com.practice.first.serviceImpl;

import com.practice.first.dao.ClientDao;
import com.practice.first.dto.ClientDto;
import com.practice.first.mapper.ClientMapper;
import com.practice.first.model.Client;
import com.practice.first.service.ClientSrv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClientSrvImpl implements ClientSrv {

    @Autowired
    private ClientDao dao;

    @Autowired
    private ClientMapper mapper;

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
    public void updateClientNameById(Integer id, String name){

        log.info("Start method - ClientSrv.updateClientNameById");
        log.info("Input - {}, {}", id, name);

        dao.updateClientName(id, name);

        log.info("End method - ClientSrv.updateClientNameById");
//        log.info("Output - {}, {}", id, name);


    }

    @Override
    public Client transform(ClientDto dto) {
        return mapper.transform(dto);
    }

    @Override
    public ClientDto transform(Client client) {
        return mapper.transform(client);
    }

}
