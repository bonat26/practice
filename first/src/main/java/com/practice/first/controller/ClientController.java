package com.practice.first.controller;

import com.practice.first.dto.ClientDto;
import com.practice.first.model.Client;
import com.practice.first.service.ClientSrv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/test")
@Slf4j
public class ClientController {

    @Autowired
    ClientSrv clientSrv;
    
    @RequestMapping("/saveClient")
    public void saveClient(@RequestParam(value = "codeId") ClientDto clientDto){
        log.info("Start method - TestController.saveClient");
        log.info("Input - {}", clientDto);

        Client client = clientSrv.transform(clientDto);
        clientSrv.saveClient(client);

        log.info("End method - TestController.saveClient");
        log.info("Output - {}", clientDto);

    }
}
