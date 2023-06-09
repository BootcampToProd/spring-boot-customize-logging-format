package com.bootcamptoprod.springbootcustomizeloggingformat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomizeApplicationLoggingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomizeApplicationLoggingController.class);

    @GetMapping("/hello")
    public String sendGreetings() {
        LOGGER.info("Sending greeting to user");
        return "Hello User!";
    }
}
