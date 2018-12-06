package com.practice.first.controller;

import com.practice.first.dto.TestDto;
import com.practice.first.service.TestSrv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/test")
@Slf4j
public class TestController {

    @Autowired
    TestSrv testSrv;

    @RequestMapping("/getTest")
    public TestDto getTest(@RequestParam(value = "codeId") TestDto testDto){
        log.info("Start method - TestController.getTest");
        log.info("Input - {}", testDto);

        TestDto response = testSrv.getTest(testDto);

        log.info("End method - TestController.getTest");
        log.info("Output - {}", response);

        return response;
    }
}
