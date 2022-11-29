package com.nimsoc.spring.controllers;


import com.nimsoc.spring.config.ConsulConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@EnableConfigurationProperties(value = ConsulConfiguration.class)
public class GreetingsController {

    @Autowired
    private ConsulConfiguration consulConfiguration;

    @GetMapping("/greetings")
    public String greetings() {
        return "Hello from a service through Consul! " + consulConfiguration.getEmail();
    }
}
