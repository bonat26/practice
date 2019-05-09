package com.practice.first.controller;

import com.practice.first.dto.ClientDto;
import com.practice.first.model.Client;
import com.practice.first.service.ClientSrv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/client")
@Slf4j
public class ClientController {

    ClientSrv clientSrv;

    public ClientController(ClientSrv clientSrv){
        this.clientSrv = clientSrv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ClientDto saveClient(@RequestBody ClientDto clientDto){
        log.info("Start method - ClientController.saveClient");
        log.info("Input - {}", clientDto);

        final Client client = clientSrv.transform(clientDto);
        clientSrv.saveClient(client);

        log.info("End method - ClientController.saveClient");
        log.info("Output - {}", clientDto);

        return clientSrv.transform(client);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ClientDto getClient(@PathVariable(name = "id") Integer clientId){
        log.info("Start method - ClientController.getClient");
        log.info("Input - {}", clientId);

        final Client client = clientSrv.getClient(clientId);
        final ClientDto clientDto = clientSrv.transform(client);

        log.info("End method - ClientController.getClient");
        log.info("Output - {}", clientDto);

        return clientDto;

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ClientDto> getAll(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        log.info("Start method - ClientController.getAll");
        log.info("Input - {}, {}", page, size);

        final List<Client> clients = clientSrv.getAll(page, size);
        final List<ClientDto> clientDtos = clientSrv.transform(clients);

        log.info("End method - ClientController.getAll");
        log.info("Output - {}", clientDtos);

        return clientDtos;

    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateNameById(@RequestParam(name = "id") Integer id, @RequestParam(name = "name") String name){

        log.info("Start method - ClientController.updateNameById");
        log.info("Input - {}, {}", id, name);

        clientSrv.updateClientNameById(id, name);

        log.info("End method - ClientController.updateNameById");
    }
}
