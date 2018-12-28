package com.practice.first.controller;

import com.practice.first.dto.ClientDto;
import com.practice.first.model.Client;
import com.practice.first.service.ClientSrv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/client")
@Slf4j
public class ClientController {

    @Autowired
    ClientSrv clientSrv;

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

    @RequestMapping(method = RequestMethod.GET)
    public ClientDto getClient(@RequestParam(name = "id") Integer clientId){
        log.info("Start method - ClientController.getClient");
        log.info("Input - {}", clientId);

        final Client client = clientSrv.getClient(clientId);
        final ClientDto clientDto = clientSrv.transform(client);

        log.info("End method - ClientController.getClient");
        log.info("Output - {}", clientDto);

        return clientDto;

    }
}
